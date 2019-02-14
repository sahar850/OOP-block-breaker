import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

/**
*@author Yair Frank, 203699566
*@author Sahar Levi, 203405147
*/
public class GameLevel implements Animation {
    private SpriteCollection sprites;
    private GameEnvironment environment;
    private Counter blocksCounter;
    private Counter ballCounter;
    private Counter scoreCounter;
    private Counter livesCounter;
    private Paddle paddle;
    private AnimationRunner runner;
    private boolean running;
    private KeyboardSensor keyboard;
    private List<Block> blockcollection;
    private LevelInformation level;
    /**
     * constractor.
     * @param levelInfo the level information
     * @param keyboard the keyboard sensor from the game
     * @param runner the animation runner for the level
     * @param scoreCounter the score counter of the game
     * @param livesCounter the lives counter of the game
     */
    public GameLevel(LevelInformation levelInfo, KeyboardSensor keyboard,
                     AnimationRunner runner, Counter scoreCounter, Counter livesCounter) {
        this.level = levelInfo;
        this.environment = new GameEnvironment();
        this.sprites = new SpriteCollection();
        this.blocksCounter = new Counter(this.level.numberOfBlocksToRemove());
        this.ballCounter = new Counter(0);
        this.scoreCounter = scoreCounter;
        this.livesCounter = livesCounter;
        this.runner = runner;
        this.running = true;
        this.keyboard = keyboard;
        this.blockcollection = new ArrayList<Block>(this.level.blocks());

    }
    /**
     * @param c we get a new collidable and add it to the list
     */
    public void addCollidable(Collidable c) {
        this.environment.addCollidable(c);
    }
    /**
     * @param s we get a new sprite and add it to the list
     */
    public void addSprite(Sprite s) {
        this.sprites.addSprite(s);
    }
    /**
     * initializing the perliminary level invironment.
     */
    public void initialize() {
        //level name
        LevelNameIndicator name = new LevelNameIndicator(this.level.levelName());
        name.addToGame(this);
        //background
        this.sprites.addSprite(this.level.getBackground());
        ScoreTrackingListener score = new ScoreTrackingListener(this.scoreCounter);
        ScoreIndicator death = new ScoreIndicator(this.scoreCounter);
        death.addToGame(this);
        LivesIndicator li = new LivesIndicator(this.livesCounter);
        li.addToGame(this);
        Point p;
        Rectangle rec;
        PrintingHitListener pr;
        BlockRemover br;
        BallRemover bar;
        br = new BlockRemover(this, this.blocksCounter);
        pr = new PrintingHitListener();
        for (int i = 0; i < this.blocksCounter.getValue(); i++) {
            this.blockcollection.get(i).addHitListener(pr);
            this.blockcollection.get(i).addHitListener(br);
            this.blockcollection.get(i).addHitListener(score);
            this.blockcollection.get(i).addToGame(this);
        }
        //left border blocks
        p = new Point(0, 20);
        rec = new Rectangle(p, 20, 600);
        Block block = new Block(rec, Color.darkGray, 0);
        block.addToGame(this);
        //right border block
        p = new Point(780, 20);
        rec = new Rectangle(p, 20, 800);
        block = new Block(rec, Color.darkGray, 0);
        block.addToGame(this);
        //top border block
        p = new Point(0, 20);
        rec = new Rectangle(p, 800, 20);
        block = new Block(rec, Color.darkGray, 0);
        block.addToGame(this);
        //death paddle
        p = new Point(0, 600);
        rec = new Rectangle(p, 800, 20);
        block = new Block(rec, Color.lightGray, 0);
        block.addToGame(this);
        bar = new BallRemover(this, this.ballCounter);
        block.addHitListener(bar);
        //paddle
        p = new Point(400 - (this.level.paddleWidth() / 2), 560);
        rec = new Rectangle(p, this.level.paddleWidth(), 20);
        this.paddle = new Paddle(this.runner.getGui(),
                java.awt.Color.YELLOW, 775 - this.level.paddleWidth(), 25, rec, this.level.paddleSpeed());
        paddle.addToGame(this);
    }
    /**
     *this method uses to play one turn.
     */
    public void playOneTurn() {
        this.createBallsOnTopOfPaddle();
        this.running = true;
        this.runner.run(new CountdownAnimation(120, 3, this.sprites));
        // use our runner to run the current animation -- which is one turn of
        // the game.
        this.runner.run(this);
    }
    /**
     * @param c we get a new collidable and remove it from the list
     */
    public void removeCollidable(Collidable c) {
        this.environment.getGameEnvironmentList().remove(c);
    }
    /**
     * @param s we get a new sprite and remove it from the sprite list
     */
    public void removeSprite(Sprite s) {
        this.sprites.getSpriteCollection().remove(s);
    }
    /**
     * @return  s a bolean for stopin one turn
     */
    public boolean shouldStop() {

       return !this.running;
    }
    /**
     * @param d in order to draw any surface we get
     * @param dt make the program run per sec
     */
    public void doOneFrame(DrawSurface d, double dt) {
        Animation hsa1 = new PauseScreen();
        if (this.keyboard.isPressed("p")) {
            this.runner.run(new KeyPressStoppableAnimation(this.keyboard, "space", hsa1));
        }
            this.sprites.drawAllOn(d);
            this.sprites.notifyAllTimePassed(dt);
            if (this.ballCounter.getValue() == 0) {
                this.running = false;
            }
            //no lives die condition
            if (this.livesCounter.getValue() == 0) {
                this.running = false;
            }
            //no blocks die condition
            if (this.blocksCounter.getValue() == 0) {
                this.running = false;
            }
        }
    /**
     * this method create the balls and restart the paddle whenever we call the play one turn method.
     */
    public void createBallsOnTopOfPaddle() {
        this.paddle.paddelReset();
        List<Velocity> initialBallVelocities = new ArrayList<Velocity>(this.level.initialBallVelocities());
        for (Velocity hl : initialBallVelocities) {
            Ball ball1 = new Ball(400, 556, 5, Color.white, environment);
            ball1.setVelocity(hl);
            ball1.addToGame(this);
            ballCounter.increase(1);
        }
    }
    /**
     * @return the block counter
     */
    public Counter getblockcounter() {
        return this.blocksCounter;
    }

    /**
     * @return the ball counter
     */
    public Counter getBallCounter() {
        return this.ballCounter;
    }

}
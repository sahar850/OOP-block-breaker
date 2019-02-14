import biuoop.KeyboardSensor;

/**
 * Created by Yair on 28/06/2016.
 */
public class ShowHiScoresTask implements Task<Void> {
    private AnimationRunner runner;
    private Animation highScoresAnimation;
    private KeyboardSensor keyboard;

    /**
     * constructor.
     * @param runner runs the game
     * @param highScoresAnimation the animation of high scores
     * @param keyboard the key that is pressed
     */
    public ShowHiScoresTask(AnimationRunner runner, Animation highScoresAnimation, KeyboardSensor keyboard) {
        this.runner = runner;
        this.highScoresAnimation = highScoresAnimation;
        this.keyboard = keyboard;
    }

    /**
     * @return null
     */
    public Void run() {
        KeyPressStoppableAnimation kpsa = new KeyPressStoppableAnimation(this.keyboard, KeyboardSensor.SPACE_KEY,
                this.highScoresAnimation);
        runner.run(kpsa);
        return null;
    }
}


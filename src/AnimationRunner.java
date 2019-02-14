import biuoop.DrawSurface;
import biuoop.GUI;
import biuoop.Sleeper;

/**
 * @author Yair Frank, 203699566
 * @author Sahar Levi, 203405147
 */
/**
 * this method run the animation of the game.
 */
public class AnimationRunner {
    private GUI gui;
    private int framesPerSecond;
    private Sleeper sleeper;
    private int frameRate;
    private double dt;
    /**
     * @param gui get the gui that the game uses.
     */
    public AnimationRunner(GUI gui) {
        this.gui = gui;
        this.sleeper = new Sleeper();
        this.framesPerSecond = 60;
        this.frameRate = 60;
        this.dt = (double) 1 / this.frameRate;
    }
    /**
     * @param animation get the animation to run
     */
    public void run(Animation animation) {
        int millisecondsPerFrame = 1000 / framesPerSecond;
        while (!animation.shouldStop()) {
            long startTime = System.currentTimeMillis(); // timing
            DrawSurface d = gui.getDrawSurface();
            animation.doOneFrame(d, this.dt);
            if (animation.shouldStop()) {
                break;
            }
            gui.show(d);
            long usedTime = System.currentTimeMillis() - startTime;
            long milliSecondLeftToSleep = millisecondsPerFrame - usedTime;
            if (milliSecondLeftToSleep > 0) {
                this.sleeper.sleepFor(milliSecondLeftToSleep);
            }
        }
    }

    /**
     * @return the gui of the class
     */
    public GUI getGui() {
        return this.gui;
    }
}
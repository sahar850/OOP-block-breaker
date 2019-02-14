/**
 * Created by Yair on 28/06/2016.
 */
public class ShowQuitTask implements Task<Void> {
    private AnimationRunner runner;
    private Animation quitAnimation;

    /**
     * constructor.
     * @param runner runs the animation
     */
    public ShowQuitTask(AnimationRunner runner) {
        this.runner = runner;
    }

    /**
     *
     * @return null (the program is closed)
     */
    public Void run() {
        System.exit(1);
        return null;
    }
}

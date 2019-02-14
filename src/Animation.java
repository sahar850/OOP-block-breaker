import biuoop.DrawSurface;
/**
 * @author Yair Frank, 203699566
 * @author Sahar Levi, 203405147
 */

/**
 * this method is an interface used to run an animation.
 */
public interface Animation {
    /**
     * @param d in order to draw any surface we get
     * @param dt num to make the program run per sec
     */
    void doOneFrame(DrawSurface d, double dt);
    /**
     * @return boolean for stopping the animation
     */
    boolean shouldStop();
}

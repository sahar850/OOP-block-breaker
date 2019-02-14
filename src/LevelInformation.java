import java.util.List;

/**
 * @author Yair Frank, 203699566
 * @author Sahar Levi, 203405147
 */
public interface LevelInformation {
    /**
     *
     * @return the size of the list of balls' velocities
     */
    int numberOfBalls();
    // The initial velocity of each ball
    // Note that initialBallVelocities().size() == numberOfBalls()

    /**
     *
     * @return the initial balls' velocities
     */
    List<Velocity> initialBallVelocities();

    /**
     *
     * @return the velocity of the paddle
     */
    int paddleSpeed();

    /**
     *
     * @return the size of the paddle
     */
    int paddleWidth();
    // the level name will be displayed at the top of the screen.

    /**
     *
     * @return the name of the level
     */
    String levelName();
    // Returns a sprite with the background of the level

    /**
     *
     * @return the matched background
     */
    Sprite getBackground();
    // The Blocks that make up this level, each block contains
    // its size, color and location.

    /**
     *
     * @return the blocks' list
     */
    List<Block> blocks();
    // Number of levels that should be removed
    // before the level is considered to be "cleared".
    // This number should be <= blocks.size();

    /**
     *
     * @return the number of the blocks currently
     */
    int numberOfBlocksToRemove();
}

/**
 * @author Yair Frank, 203699566
 * @author Sahar Levi, 203405147
 */
/**
 * this method use to remove ball from the game if they reach the bottom of the screen (the death paddle).
 */
public class BallRemover implements HitListener {
    private GameLevel gameLevel;
    private Counter remainingBalls;

    /**
     * constructor.
     * @param gameLevel get the current game level
     * @param removedBall uses as a counter for the balls in the game
     */
    public BallRemover(GameLevel gameLevel, Counter removedBall) {
        this.gameLevel = gameLevel;
        this.remainingBalls = removedBall;
    }
    /**
     * this method removing the balls from the game if the ball hit the death paddle we decrees 1 from the ball counter.
     *@param beingHit the daeth paddle, if the ball hits it he is removed from the game
     *@param hitter the ball.
     */
    public void hitEvent(Block beingHit, Ball hitter) {
            hitter.removeFromGame(this.gameLevel);
            remainingBalls.decrease(1);
    }
}


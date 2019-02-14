/**
 * @author Yair Frank, 203699566
 * @author Sahar Levi, 203405147
 */
public interface HitListener {
    // This method is called whenever the beingHit object is hit.
    // The hitter parameter is the Ball that's doing the hitting.

    /**
     * this method removing the balls from the game if the ball hit the death paddle we decrees 1 from the ball counter.
     *@param beingHit the object thats been hit
     *@param hitter the object that hit the beenHit
     */
    void hitEvent(Block beingHit, Ball hitter);
}
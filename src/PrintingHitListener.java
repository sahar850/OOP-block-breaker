/**
 *@author Yair Frank, 203699566
 *@author Sahar Levi, 203405147
 */
public class PrintingHitListener implements HitListener {
    /**
     * printing the occurrences in the game.
     * @param beingHit the object that's been hit
     * @param hitter the object that hit the beingHit
     */
    public void hitEvent(Block beingHit, Ball hitter) {
        System.out.println("A Block with " + beingHit.getHitPoints() + " points was hit.");
    }
}
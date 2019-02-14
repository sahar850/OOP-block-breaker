/**
 *@author Yair Frank, 203699566
 *@author Sahar Levi, 203405147
 */
public class ScoreTrackingListener implements HitListener {
    private Counter currentScore;

    /**
     * constructor.
     * @param scoreCounter the current score we want to change
     */
    public ScoreTrackingListener(Counter scoreCounter) {
        this.currentScore = scoreCounter;
    }

    /**
     * changing the score.
     * @param beingHit the object thats been hit
     * @param hitter the object that hit the beenHit
     */
    public void hitEvent(Block beingHit, Ball hitter) {
       if (beingHit.getHitPoints() >= 0) {
           this.currentScore.increase(5);
       }
        if (beingHit.getHitPoints() == 0) {
            this.currentScore.increase(10);
        }
    }
}
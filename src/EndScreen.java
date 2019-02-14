import biuoop.DrawSurface;
/**
 * @author Yair Frank, 203699566
 * @author Sahar Levi, 203405147
 */
public class EndScreen implements Animation {
    private Counter scoreCounter;
    private Counter liveCounter;
    /**
     * constractor.
     * @param scoreCounter the game score counter
     * @param liveCounter the game score counter
     */
    public EndScreen(Counter scoreCounter, Counter liveCounter) {
        this.scoreCounter = scoreCounter;
        this.liveCounter = liveCounter;
    }
    /**
     *this method draw one fram of the end screen if the player win or lose it print the screen acourdingly.
     * @param d in order to draw any surface we get
     * @param dt make the program run per sec
     */
    public void doOneFrame(DrawSurface d, double dt) {
        String s = Integer.toString(this.scoreCounter.getValue());
        if (this.liveCounter.getValue() == 0) {
            d.drawText(150, d.getHeight() / 2, "GameOver your score is:" + s , 32);
        } else {
            d.drawText(150, d.getHeight() / 2, "You win! your score is:" + s, 32);
        }
    }
    /**
     * @return a boolean for the stop condition.
     */
    public boolean shouldStop() {
        return false;
    }
}
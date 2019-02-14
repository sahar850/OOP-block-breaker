import biuoop.DrawSurface;
import java.awt.Color;
/**
 * @author Yair Frank, 203699566
 * @author Sahar Levi, 203405147
 */
/**
 * this method is a countdown animation screen.
 */
public class CountdownAnimation implements Animation {
    private double numOfSeconds;
    private int countFrom;
    private SpriteCollection gameScreen;
    private boolean stop;
    /**
     * @param numOfSeconds the num of seconds the animation runs
     * @param countFrom the count down numbers
     * @param gameScreen the game behaind the countdown
     */
        public CountdownAnimation(double numOfSeconds, int countFrom, SpriteCollection gameScreen) {
            this.numOfSeconds = numOfSeconds;
            this.countFrom = countFrom;
            this.gameScreen = gameScreen;
            this.stop = false;
             }
    /**
     * this method draw one frame.
     * @param d in order to draw any surface we get
     * @param dt to make the program run per sec
     */
        public void doOneFrame(DrawSurface d, double dt) {
            this.gameScreen.drawAllOn(d);
           String s = new String();
           s = Integer.toString(countFrom);
            d.setColor(Color.red);
            d.drawText(400, d.getHeight() / 2, s, 32);
            numOfSeconds--;
            if (numOfSeconds == 40) {
                countFrom--;
            }
            if (numOfSeconds == 80) {
                countFrom--;
            }
                if (numOfSeconds == 120) {
                    countFrom--;
                }
            if (numOfSeconds == 0) {
                this.stop = true;
            }
        }
    /**
     * @return a boolean for the stop condition.
     */
        public boolean shouldStop() {
            return this.stop;
        }
    }


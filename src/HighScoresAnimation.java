import biuoop.DrawSurface;
import biuoop.KeyboardSensor;
import java.awt.Color;
/**
 * Created by Sahar on 05/06/2016.
 */
public class HighScoresAnimation implements Animation {
    private HighScoresTable scoresTable;
    private String s;
    private KeyboardSensor sensor;

    /**
     *
     * @param scores the high score table
     */
    public HighScoresAnimation(HighScoresTable scores) {
        this.scoresTable = scores;
    }
    /**
     * showing the pause screen.
     * @param d to draw the text on the screen
     * @param dt make the program run per sec
     */
    public void doOneFrame(DrawSurface d, double dt) {
        d.setColor(Color.WHITE);
        d.fillRectangle(0, 0, 800, 600);
        d.setColor(Color.RED);
        d.drawText(280, 190, "High Scores Table", 30);
        for (int i = 0; i < this.scoresTable.getHighScores().size(); i++) {
            d.drawText(290, 230 + 32 * i,
                    this.scoresTable.getHighScores().get(i).getName(), 25);
            d.drawText(470, 230 + 32 * i,
                    Integer.toString(this.scoresTable.getHighScores().get(i).getScore()), 25);
        }
        d.drawText(330, 410, "Press space to continue", 15);

    }
    /**
     * checking if we have stopped the frame of the game.
     * @return the situation of the game
     */
    public boolean shouldStop() {
        return false; }
}

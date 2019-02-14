import biuoop.DrawSurface;

/**
 * Created by Yair on 23/06/2016.
 */
public class LooseScreen implements Animation {
    /**
     * showing the pause screen.
     * @param d to draw the text on the screen
     */
    private Counter score;

    /**
     * constructor.
     * @param score get the final score
     */
    public LooseScreen(Counter score) {
        this.score = score;
    }

    /**
     * @param d in order to draw any surface we get
     * @param dt get the dt in order to turn the game to be per a second
     */
    public void doOneFrame(DrawSurface d, double dt) {
        d.drawText(150, d.getHeight() / 6, "You lost! What a looser...", 32);
        d.drawText(150, d.getHeight() / 2, "Hurry up i've got better things to do!!", 32);
    }

    /**
     * checking if we have stopped the frame of the game.
     * @return the situation of the game
     */
    public boolean shouldStop() {
        return false; }
}

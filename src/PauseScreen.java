import biuoop.DrawSurface;

/**
 * @author Yair Frank, 203699566
 * @author Sahar Levi, 203405147
 */
public class PauseScreen implements Animation {

    /**
     * showing the pause screen.
     * @param d to draw the text on the screen
     * @param dt get the dt in order to turn the game to be per a second
     */
    public void doOneFrame(DrawSurface d, double dt) {
        d.drawText(150, d.getHeight() / 6, "paused -- press space to continue", 32);
        d.drawText(150, d.getHeight() / 2, "Hurry up i've got better things to do!!", 32);
    }

    /**
     * checking if we have stopped the frame of the game.
     * @return the situation of the game
     */
    public boolean shouldStop() {
        return false; }
}
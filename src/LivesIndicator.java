import biuoop.DrawSurface;

import java.awt.Color;

/**
 * @author Yair Frank, 203699566
 * @author Sahar Levi, 203405147
 */
public class LivesIndicator implements Sprite {
    private Rectangle rectangle;
    private Counter numberOfLives;

    /**
     * constructor.
     * @param numberOfLives the number of the lives we want to put in the bracket
     */
    public LivesIndicator(Counter numberOfLives) {
        this.rectangle = new Rectangle(new Point(0, 0), 250, 20);
        this.numberOfLives = numberOfLives;

    }

    /**
     * drawing the  LivesIndicator.
     * @param d in order to draw any surface we get (LivesIndicator in this case)
     */
    public void drawOn(DrawSurface d) {
        d.setColor(Color.lightGray);
        d.fillRectangle((int) this.rectangle.getUpperLeft().getX(), (int) this.rectangle.getUpperLeft().getY(),
                (int) this.rectangle.getWidth(), (int) this.rectangle.getHeight());
        String hit = "Lives:" + Integer.toString(this.numberOfLives.getValue());
        d.setColor(Color.black);
        d.drawText((((int) this.rectangle.getWidth() / 2) + (int) this.rectangle.getUpperLeft().getX()),
                (((int) this.rectangle.getHeight()) + (int) this.rectangle.getUpperLeft().getY()) - 3, hit, 14);

    }
    /**
     * @param dt get the dt in order to turn the game to be per a second
     * not in use here.
     */
    public void timePassed(double dt) {
    }
    /**
     * adding to the game.
     * @param g adding the sprite to the game
     */
    public void addToGame(GameLevel g) {
        g.addSprite(this);
    }
}

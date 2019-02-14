import biuoop.DrawSurface;
import java.awt.Color;

/**
 *@author Yair Frank, 203699566
 *@author Sahar Levi, 203405147
 */
public class ScoreIndicator implements Sprite {
    private Rectangle rectangle;
    private Counter sc;

    /**
     * constructor.
     * @param score the score we want to put in the bracket
     */
    public ScoreIndicator(Counter score) {
        this.rectangle = new Rectangle(new Point(250, 0), 250, 20);
        this.sc = score;
    }
    /**
     * drawing the ScoreIndicator.
     * @param d in order to draw any surface we get (ScoreIndicator in this case)
     */
    public void drawOn(DrawSurface d) {
        d.setColor(Color.lightGray);
        d.fillRectangle((int) this.rectangle.getUpperLeft().getX(),
                (int) this.rectangle.getUpperLeft().getY(), (int) this.rectangle.getWidth(),
                (int) this.rectangle.getHeight());
            String hit = "Score:" + Integer.toString(this.sc.getValue());
            d.setColor(Color.black);
            d.drawText((((int) this.rectangle.getWidth() / 2) + (int) this.rectangle.getUpperLeft().getX()),
                    (((int) this.rectangle.getHeight()) + (int) this.rectangle.getUpperLeft().getY()) - 3, hit, 14);

    }
    /**
     * not in use here.
     * @param dt get the dt in order to turn the game to be per a second
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


import biuoop.DrawSurface;

import java.awt.Color;

/**
 * @author Yair Frank, 203699566
 * @author Sahar Levi, 203405147
 */
public class LevelNameIndicator implements Sprite {
    private Rectangle rectangle;
    private String levelname;

    /**
     * constructor.
     * @param levelName the name of the level we want to put in the bracket
     */
    public LevelNameIndicator(String levelName) {
        this.rectangle = new Rectangle(new Point(500, 0), 300, 20);
        this.levelname = levelName;

    }

    /**
     * drawing the  LevelNameIndicator.
     * @param d in order to draw any surface we get (the LevelNameIndicator in this case)
     */
    public void drawOn(DrawSurface d) {
        d.setColor(Color.lightGray);
        d.fillRectangle((int) this.rectangle.getUpperLeft().getX(), (int) this.rectangle.getUpperLeft().getY(),
                (int) this.rectangle.getWidth(), (int) this.rectangle.getHeight());
        String hit = "Level Name:" + this.levelname;
        d.setColor(Color.black);
        d.drawText(515,
                (((int) this.rectangle.getHeight()) + (int) this.rectangle.getUpperLeft().getY() - 3), hit, 15);

    }

    /**
     * @param dt to make the game run per sec
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



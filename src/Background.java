import biuoop.DrawSurface;

import java.awt.Color;
import java.awt.Image;

/**
 * Created by Sahar on 30/06/2016.
 */
public class Background implements Sprite {
    private Image image;
    private java.awt.Color color;

    /**
     * @param image the image for the background
     */
    public Background(Image image) {
        this.image = image;
        this.color = null;
    }

    /**
     * @param color the color for the background
     */
    public Background(Color color) {
        this.image = null;
        this.color = color;
    }

    /**
     * @param d in order to draw any surface we get
     */
    public void drawOn(DrawSurface d) {
        if (this.image != null) {
            d.drawImage(0, 0, this.image);
        } else {
            d.setColor(this.color);
            d.fillRectangle(0, 0, d.getWidth(), d.getHeight());
        }
    }

    /**
     *
     * @param dt to make the program run per sec
     */
    public void timePassed(double dt) {

    }

    /**
     *
     * @param g the leve to add the background to
     */
    public void addToGame(GameLevel g) {
        g.addSprite(this);
    }
}

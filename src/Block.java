import java.awt.Image;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import biuoop.DrawSurface;
/**
 * @author Yair Frank, 203699566
 * @author Sahar Levi, 203405147
 */
public class Block implements Collidable, Sprite, HitNotifier {
    private List<HitListener> hitListeners;
    private Rectangle rectangle;
    private int hitman;
    private Map<Integer, Color> mapcolor;
    private Map<Integer, Image> mapimage;
    private Color stroke;
    private Color currenthitcolor;
    private Image currenthitimage;
    private Color color;

    /**
     * @param rec get the rectangle
     * @param hitman get the number of hits
     * @param stroke the color for the block
     * @param mapcolor the color map (if the hit change it)
     * @param mapimage the image map (if the hit change it)
     * @param currenthitcolor the current hit of the block
     */
    public Block(Rectangle rec, Color stroke , int hitman, Map<Integer, Color> mapcolor, Map<Integer,
            Image> mapimage, Color currenthitcolor) {
        this.rectangle = rec;
        this.hitman = hitman;
        this.mapcolor = mapcolor;
        this.hitListeners = new ArrayList<HitListener>();
        this.stroke = stroke;
        this.mapimage = mapimage;
        this.currenthitcolor = currenthitcolor;
        this.currenthitimage = null;
    }

    /**
     * @param rec get the rectangle
     * @param stroke the color for the block
     * @param hitman get the number of hit
     * @param mapcolor the color map (if the hit change it)
     * @param mapimage the image map (if the hit change it)
     * @param currenthitimage the current hit of the block
     */
    public Block(Rectangle rec, Color stroke , int hitman, Map<Integer, Color> mapcolor, Map<Integer,
            Image> mapimage, Image currenthitimage) {
        this.rectangle = rec;
        this.hitman = hitman;
        this.mapcolor = mapcolor;
        this.hitListeners = new ArrayList<HitListener>();
        this.stroke = stroke;
        this.mapimage = mapimage;
        this.currenthitimage = currenthitimage;
        this.currenthitcolor = null;
    }

    /**
     * @param rect the rec who build the block
     * @param color the color of the block
     * @param hits the num of hit of the block
     */
    public Block(Rectangle rect, java.awt.Color color, int hits) {
        this.rectangle = rect;
        this.color = color;
        this.hitman = hits;
        this.hitListeners = new ArrayList<HitListener>();
    }
    /**
     * @return the "collision shape" of the object
     */
    public Rectangle getCollisionRectangle() {
        return this.rectangle;
    }
    /**
     * @param collisionPoint get the collision point
     * @param currentVelocity get the velocity
     * @param hitter the ball hitin the block
     * @return a new velocity
     */
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {
        if (this.rectangle.getUpperLeft().getY() == collisionPoint.getY()
                || this.rectangle.getHeight() + this.rectangle.getUpperLeft().getY() == collisionPoint.getY()) {
            Velocity v = new Velocity(currentVelocity.getDx(), -currentVelocity.getDy());
            this.hitman--;
            this.notifyHit(hitter);
            return v;
        }
        if (this.rectangle.getUpperLeft().getX() == collisionPoint.getX()
                || this.rectangle.getWidth() + this.rectangle.getUpperLeft().getX() == collisionPoint.getX()) {
            Velocity v = new Velocity(-currentVelocity.getDx(), currentVelocity.getDy());
            this.hitman--;
            this.notifyHit(hitter);
            return v;
        }
        return currentVelocity;
    }

    /**
     * @return the number of hitts
     */
    public int getHitPoints() {
        return this.hitman;
    }
    /**
     * @param surface that we draw on it
     */
    public void drawOn(DrawSurface surface) {
        if (this.color != null) {
            surface.setColor(this.color);
            surface.fillRectangle((int) this.rectangle.getUpperLeft().getX(),
                    (int) this.rectangle.getUpperLeft().getY(), (int) this.rectangle.getWidth(),
                    (int) this.rectangle.getHeight());
            if (this.stroke != null) {
                surface.setColor(this.stroke);
            }
        } else {
            if (this.currenthitcolor != null) {
                surface.setColor(this.mapcolor.get(hitman));
                surface.fillRectangle((int) this.rectangle.getUpperLeft().getX(),
                        (int) this.rectangle.getUpperLeft().getY(), (int) this.rectangle.getWidth(),
                        (int) this.rectangle.getHeight());
                if (this.stroke != null) {
                    surface.setColor(this.stroke);

                }
                surface.drawRectangle((int) this.rectangle.getUpperLeft().getX(),
                        (int) this.rectangle.getUpperLeft().getY(), (int) this.rectangle.getWidth(),
                        (int) this.rectangle.getHeight());
            } else {
                surface.drawImage((int) this.rectangle.getUpperLeft().getX(),
                        (int) this.rectangle.getUpperLeft().getY(), mapimage.get(hitman));
                if (this.stroke != null) {
                    surface.setColor(this.stroke);
                }
                surface.drawRectangle((int) this.rectangle.getUpperLeft().getX(),
                        (int) this.rectangle.getUpperLeft().getY(), (int) this.rectangle.getWidth(),
                        (int) this.rectangle.getHeight());
            }
        }
    }

    /**
     * @param dt make the program run per sec
     */
    public void timePassed(double dt) {
    }
    /**
     * * this method is eding the block from the game.
     * @param g is the game that we add the block to it
     */
    public void addToGame(GameLevel g) {
        g.addSprite(this);
        g.addCollidable(this);
    }
    /**
     * this method is removing the block from the game.
     * @param g is the game that we add the block to it
     */
    public void removeFromGame(GameLevel g) {
        g.removeCollidable(this);
        g.removeSprite(this);
    }

    /**
     * this method Add hl as a listener to hit events.
     * @param hl the hitlisener to add
     */
    public void addHitListener(HitListener hl) {
        this.hitListeners.add(hl);
    }
    /**
     * this method Remove hl from the list of listeners to hit events.
     * @param hl the hitlisener to remove
     */
    public void removeHitListener(HitListener hl) {
        this.hitListeners.remove(hl);
    }
    /**
     * this method notify the hit to all its listed liseners.
     * @param hitter the ball that hits the paddle
     */
    private void notifyHit(Ball hitter) {
        // Make a copy of the hitListeners before iterating over them.
        List<HitListener> listeners = new ArrayList<HitListener>(this.hitListeners);
        // Notify all listeners about a hit event:
        for (HitListener hl : listeners) {
            hl.hitEvent(this, hitter);
        }
    }
}
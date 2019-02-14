import java.awt.Color;
import biuoop.DrawSurface;
/**
 * @author Yair Frank, 203699566
 * @author Sahar Levi, 203405147
 */
public class Ball implements Sprite {
    private Point center;
    private int r;
    private Color color;
    private Velocity velocity;
    private GameEnvironment enviroment;
    /**
     * constructor.
     * constructor - without boundary's.
     * @param center get the center point of the ball
     * @param r get the radius of the ball
     * @param color gets the color of the ball
     * @param enviroment get the list of blocks
     */
   public Ball(Point center, int r, Color color, GameEnvironment enviroment) {
       this.center = center;
       this.r = r;
       this.color = color;
       this.velocity = new Velocity(0, 0);
      this.enviroment = enviroment;
   }
   /**
     * constructor.
     * constructor -coordination without boundary's.
     * @param x get the x point
     * @param y get the y point
     * @param r get the radius of the ball
     * @param color gets the color of the ball
     * @param enviroment get the list of blocks
     */
   public Ball(int x, int y, int r, Color color, GameEnvironment enviroment) {
       this.center = new Point((double) x, (double) y);
       this.r = r;
       this.color = color;
       this.velocity = new Velocity(0, 0);
      this.enviroment = enviroment;
   }
   /**
    * this method get the x value of the center and return it as an integer.
    * @return the x values of this point
    */
   public int getX() {
   return (int) this.center.getX();
   }
   /**
    * this method get the y value of the center and return it as an integer.
    * @return the y values of this point
    */
   public int getY() {
       return (int) this.center.getY();
   }
   /**
    * this method get the radius value and return it.
    * @return the radius values of this ball
    */
   public int getSize() {
       return this.r;
   }
   /**
    * this method get the color of the ball and return it.
    * @return the color of this ball
    */
   public Color getColor() {
       return this.color;
   }
   /**
    * @param v get the velocity
    * this method get a new Velocity as a point.
    */
   public void setVelocity(Velocity v) {
       this.velocity = v;
   }
   /**
    * this method get a new Velocity as two coordination.
    * @param dx get the number of units changed in x point
    * @param dy get the number of units changed in y point
    */
   public void setVelocity(double dx, double dy) {
       this.velocity = new Velocity(dx, dy);
   }
   /**
    * this method return the velocity.
    * @return the new Velocity of this ball as this velocity
    */
   public Velocity getVelocity() {
       return this.velocity;
   }
   /**
    * @param dt to make the program run per sec
   * @return the new line that created according to the velocity and the trajectory
   */
  public Line setTrajectory(double dt) {
       return new Line(this.center.getX(), this.center.getY(),
       this.center.getX() + this.getVelocity().setSpeedPerSecond(dt).getDx(), this.center.getY()
               + this.getVelocity().setSpeedPerSecond(dt).getDy());
   }
   /**
    * @param dt to make the program run per sec
   */
   public void moveOneStep(double dt) {
       Line trajectory = setTrajectory(dt);
    if (this.enviroment.getClosestCollision(trajectory) != null) {
        Point p = new Point(enviroment.getClosestCollision(trajectory).collisionPoint().getX(),
        enviroment.getClosestCollision(trajectory).collisionPoint().getY());
            this.setVelocity(enviroment.getClosestCollision(trajectory).
                    collisionObject().hit(this, p, this.velocity));
            } else {
        this.center = setTrajectory(dt).end();
    }
}
   /**
    * this method draw the ball on the given DrawSurface.
    * @param surface get the surface of the ball.
    */
   public void drawOn(DrawSurface surface) {
       surface.setColor(color);
       surface.fillCircle(this.getX(), this.getY(), this.r);
       surface.setColor(Color.black);
       surface.drawCircle(this.getX(), this.getY(), this.r);
   }
       /**
        * @param dt to make the program run per sec
        */
   public void timePassed(double dt) {
       moveOneStep(dt);
   }
       /**
        * @param g is the game that we add the ball to it
        */
   public void addToGame(GameLevel g) {
       g.addSprite(this);
   }
    /**
     * @param g is the game that we remove the ball from it
     */
   public void removeFromGame(GameLevel g) {
        g.removeSprite(this);
    }
}
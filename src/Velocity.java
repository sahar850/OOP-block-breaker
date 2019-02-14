/**
 * @author Yair Frank, 203699566
 * @author Sahar Levi, 203405147
 */
public class Velocity {
    private double dx;
    private double dy;
    /**
     * constructor.
     * @param dx get the change of the coordination of the x axes
     * @param dy get the change of the coordination of the y axes
     */
   public Velocity(double dx, double dy) {
       this.dx = dx;
       this.dy = dy;
   }
   /** this method returns the velocity as angel and speed (as oppose to two position).
     * @param angle get the angel of the ball.
     * @param speed get the speed of the ball.
     * @return the new velocity as angel and speed.
     */
   public static Velocity fromAngleAndSpeed(double angle, double speed) {
       double dx = Math.cos(Math.toRadians(angle - 90)) * speed;
       double dy = Math.sin(Math.toRadians(angle - 90)) * speed;
       return new Velocity(dx, dy);
    }
   /**
    * this method get the dx value and return it.
    * @return the dx values of this velocity.
    */
   public double getDx() {
       return this.dx;
   }
   /**
    * this method get the dy value and return it.
    * @return the dy values of this velocity
    */
   public double getDy() {
       return this.dy;
   }
   /**
    * this method Take a point with position (x,y) and return a new point
    * with position (x+dx, y+dy).
    * @param p the point of the ball.
    * @return a new point with position (x+dx, y+dy)
    */
   public Point applyToPoint(Point p) {
     double newDx = p.getX() + this.dx;
     double newDy = p.getY() + this.dy;
       return new Point(newDx, newDy);
   }
      /**
   * @return the new speed
   */
  public double getSpeed() {
   return Math.sqrt(this.dx * this.dx + this.dy * this.dy);
   }

    /**
     *
     * @param dt get the dt in order to turn the game to be per a second
     * @return new velocity that is depends on the dt
     */
    public Velocity setSpeedPerSecond(double dt) {
        return new Velocity(this.getDx() * dt + 0.1, this.getDy() * dt + 0.1);
    }
  }
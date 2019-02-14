import biuoop.DrawSurface;
import biuoop.GUI;
import biuoop.KeyboardSensor;

import java.awt.Color;

/**
*@author Yair Frank, 203699566
*@author Sahar Levi, 203405147
*/
public class Paddle implements Sprite, Collidable {
        private KeyboardSensor keyboard;
        private java.awt.Color color;
        private int rightBorder;
        private int leftBorder;
        private Rectangle rectangle;
        private int paddleSpeed;
        /**
         * Paddle constructor creates a ball's paddle for the game.
         * @param gui - the graphical user interface window  of the game
         * @param color - the paddle's color
         * @param rightBorder - the paddle's right border (the right wall)
         * @param leftBorder - the paddle's left border (the left wall)
         * @param rect - the rectangle presenting the paddle graphically
         * @param paddleSpeed - the speed of the paddle
         */
        public Paddle(GUI gui, java.awt.Color color, int rightBorder, int leftBorder, Rectangle rect, int paddleSpeed) {
            this.keyboard = gui.getKeyboardSensor();
            this.color = color;
            this.rightBorder = rightBorder;
            this.leftBorder = leftBorder;
            this.rectangle = rect;
            this.paddleSpeed = paddleSpeed;
        }

    /**
     *
     * @param dt get the dt in order to turn the game to be per a second
     */
    public void moveLeft(double dt) {
       if (this.rectangle.getUpperLeft().getX() > this.leftBorder) {
           Point p = new Point(this.rectangle.getUpperLeft().getX() - (int) (this.paddleSpeed * dt),
                   this.rectangle.getUpperLeft().getY());
              this.rectangle = new Rectangle(p, this.rectangle.getWidth(), this.rectangle.getHeight());
                }
       }

    /**
     *
     * @param dt get the dt in order to turn the game to be per a second
     */
    public void moveRight(double dt) {
       if (
      this.rectangle.getUpperLeft().getX() < this.rightBorder) {
           Point p = new Point(this.rectangle.getUpperLeft().getX() + (int) (this.paddleSpeed * dt),
                   this.rectangle.getUpperLeft().getY());
              this.rectangle = new Rectangle(p, this.rectangle.getWidth(), this.rectangle.getHeight());
                }
       }

    /**
     *
     * @param dt get the dt in order to turn the game to be per a second
     */
    public void timePassed(double dt) {
       if (this.keyboard.isPressed(this.keyboard.LEFT_KEY)) {
           System.out.println("The left-key key is pressed");
           this.moveLeft(dt);
       }
       if (this.keyboard.isPressed(this.keyboard.RIGHT_KEY)) {
           System.out.println("The right-key key is pressed");
           this.moveRight(dt);
       }
   }
      /**
   * @param d that we draw on it
   */
   public void drawOn(DrawSurface d) {
       d.setColor(this.color);
       d.fillRectangle(
               (int) (this.rectangle.getUpperLeft().getX()),
               (int) (this.rectangle.getUpperLeft().getY()),
               (int) (this.rectangle.getWidth()),
               (int) (this.rectangle.getHeight()));
       d.setColor(Color.black);
         d.drawRectangle((int) this.rectangle.getUpperLeft().getX(),
                 (int) this.rectangle.getUpperLeft().getY(),
                 (int) this.rectangle.getWidth(),
                 (int) this.rectangle.getHeight());
   }
      /**
   * @return the rectangle that collided
   */
   public Rectangle getCollisionRectangle() {
       return this.rectangle;
   }
    /**
     * @param hitter the ball
   * @param collisionPoint get the collision point
   * @param currentVelocity get the current velocity
   * @return a new velocity
   */
public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {
   double devidedPaddel = this.rectangle.getWidth() / 5;
   Line leftPaddel = new Line(this.rectangle.getUpperLeft().getX(),
           this.rectangle.getUpperLeft().getY(),
           this.rectangle.getUpperLeft().getX() + devidedPaddel,
           this.rectangle.getUpperLeft().getY());
   Line leftSide = new Line(this.rectangle.getUpperLeft().getX(),
           this.rectangle.getUpperLeft().getY(),
           this.rectangle.getUpperLeft().getX(),
           this.rectangle.getHeight());
   Line middleLeftPaddel = new Line(
           this.rectangle.getUpperLeft().getX() + devidedPaddel,
           this.rectangle.getUpperLeft().getY(),
           this.rectangle.getUpperLeft().getX() + 2 * devidedPaddel,
           this.rectangle.getUpperLeft().getY());
   Line middlePaddel = new Line(
           this.rectangle.getUpperLeft().getX() + 2 * devidedPaddel,
           this.rectangle.getUpperLeft().getY(),
           this.rectangle.getUpperLeft().getX() + 3 * devidedPaddel,
           this.rectangle.getUpperLeft().getY());
   Line middleRightPaddel = new Line(
           this.rectangle.getUpperLeft().getX() + 3 * devidedPaddel,
           this.rectangle.getUpperLeft().getY(),
           this.rectangle.getUpperLeft().getX() + 4 * devidedPaddel,
           this.rectangle.getUpperLeft().getY());
   Line rightPaddel = new Line(
           this.rectangle.getUpperLeft().getX() + 4 * devidedPaddel,
           this.rectangle.getUpperLeft().getY(),
           this.rectangle.getUpperLeft().getX() + 5 * devidedPaddel,
           this.rectangle.getUpperLeft().getY());
   Line rightSide = new Line(this.rectangle.getUpperLeft().getX() + this.rectangle.getWidth(),
           this.rectangle.getUpperLeft().getY(),
           this.rectangle.getUpperLeft().getX() + this.rectangle.getWidth(),
           this.rectangle.getHeight() + this.rectangle.getUpperLeft().getY());
   if ((leftPaddel.start().getX() < collisionPoint.getX() && leftPaddel.end().getX() > collisionPoint.getX())
           || (leftSide.start().getY() < collisionPoint.getY() && leftSide.end().getY() > collisionPoint.getY())) {
       return Velocity.fromAngleAndSpeed(300, currentVelocity.getSpeed());
   }
   if (middleLeftPaddel.start().getX() < collisionPoint.getX()
       && middleLeftPaddel.end().getX() > collisionPoint.getX()) {
       return Velocity.fromAngleAndSpeed(330, currentVelocity.getSpeed());
   }
   if (middlePaddel.start().getX() < collisionPoint.getX() && middlePaddel.end().getX() > collisionPoint.getX()) {
       return new Velocity(currentVelocity.getDx(), -currentVelocity.getDy());
   }
   if (middleRightPaddel.start().getX() < collisionPoint.getX()
       && middleRightPaddel.end().getX() > collisionPoint.getX()) {
       return Velocity.fromAngleAndSpeed(30, currentVelocity.getSpeed());
   }
   if ((rightPaddel.start().getX() < collisionPoint.getX() && rightPaddel.end().getX() > collisionPoint.getX())
           || (rightSide.start().getY() < collisionPoint.getY() && rightSide.end().getY() > collisionPoint.getY())) {
       return Velocity.fromAngleAndSpeed(60, currentVelocity.getSpeed());
   }
   return currentVelocity;
}
   /**
   * @param g is the game that we add the paddle to it
   */
   public void addToGame(GameLevel g) {
       g.addSprite(this);
       g.addCollidable(this);
   }

    /**
     * putting the paddle back in the middle after one turn.
     */
    public void paddelReset() {
        this.rectangle = new Rectangle(new Point(400  - (this.rectangle.getWidth() / 2), 560),
                this.rectangle.getWidth(), this.rectangle.getHeight());
    }
}
/**
*@author Yair Frank, 203699566
*@author Sahar Levi, 203405147
*/
public interface Collidable {
    /**
* @return the "collision shape" of the object
*/
   Rectangle getCollisionRectangle();
      /**
       * @param collisionPoint get the collision point
       * @param currentVelocity get the velocity
       * @param hitter the ball hitin the block
       * @return a new velocity
        */
   Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity);
}
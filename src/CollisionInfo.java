/**
*@author Yair Frank, 203699566
*@author Sahar Levi, 203405147
*/
public class CollisionInfo {
        private Point collisionPoint;
        private Collidable collisionObject;
                   /**
       * @param collisionPoint get the collision point
       * @param collisionObject get the collision object
        */
    public CollisionInfo(Point collisionPoint, Collidable collisionObject) {
           this.collisionPoint = collisionPoint;
           this.collisionObject = collisionObject;
    }
           /**
        * @return the collision point
        */
       public Point collisionPoint() {
           return collisionPoint;
       }
                  /**
        * @return the collision object
        */
       public Collidable collisionObject() {
           return collisionObject;
       }
}
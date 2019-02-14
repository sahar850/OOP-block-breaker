import java.util.ArrayList;
/**
*@author Yair Frank, 203699566
*@author Sahar Levi, 203405147
*/
public class GameEnvironment {
    private  ArrayList gameEnvironmentList;
           /**
   */
    public GameEnvironment() {
         this.gameEnvironmentList = new ArrayList();
           }
                 /**
      * @param c add the given collidable to the environment
   */
   public void addCollidable(Collidable c) {
       this.gameEnvironmentList.add(c);
   }
         /**
              * @return the list of blocks
   */
public ArrayList getGameEnvironmentList() {
    return this.gameEnvironmentList;
}
 /**
      * @param trajectory in order to get closest collision
      * @return info about the closest point the ball will collide with or null when we haven't a point
   */
   public CollisionInfo getClosestCollision(Line trajectory) {
       Point point;
       Rectangle rect;
       double min = 0;
       int counter = 0;
       int index = 0;
       if (this.gameEnvironmentList != null) {
           for (int i = 0; i < this.gameEnvironmentList.size(); i++) {
               rect = ((Collidable) this.gameEnvironmentList.get(i)).getCollisionRectangle();
               if (trajectory.closestIntersectionToStartOfLine(rect) != null) {
                   counter++;
                   point = trajectory.closestIntersectionToStartOfLine(rect);
                   if (counter == 1) {
                       min = point.distance(trajectory.start());
                       index = i;
                   } else {
                       if (min > point.distance(trajectory.start())) {
                           min = point.distance(trajectory.start());
                           index = i;
                       }
                   }
               }
           }
           if (counter == 0) {
               return null;
           }
           rect = ((Collidable) this.gameEnvironmentList.get(index)).getCollisionRectangle();
           return new CollisionInfo(trajectory.closestIntersectionToStartOfLine(rect),
                      (Collidable) this.gameEnvironmentList.get(index));
       }
       return null;
   }
}
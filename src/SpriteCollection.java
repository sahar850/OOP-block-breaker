import java.util.ArrayList;
import biuoop.DrawSurface;
/**
*@author Yair Frank, 203699566
*@author Sahar Levi, 203405147
*/
public class SpriteCollection {
    private ArrayList spriteCollection;
       /**
   */
    public SpriteCollection() {
         this.spriteCollection = new ArrayList();
           }
              /**
   * @param s add sprite to the sprite collection
   */
    public void addSprite(Sprite s) {
         this.spriteCollection.add(s);
    }

    /**
     *
     * @param dt get the dt in order to turn the game to be per a second
     */
    public void notifyAllTimePassed(double dt) {
           if (spriteCollection != null) {
           for (int i = 0; i < spriteCollection.size(); i++) {
               Sprite sp = (Sprite) spriteCollection.get(i);
               sp.timePassed(dt);
           }
           }
       }
                 /**
          * @param d get the surface that we want to draw
   */
       public void drawAllOn(DrawSurface d) {
           if (spriteCollection != null) {
               for (int i = 0; i < spriteCollection.size(); i++) {
                   Sprite sp = (Sprite) spriteCollection.get(i);
                   sp.drawOn(d);
               }
    }

}

    /**
     * getting the sprites' list.
     * @return the list
     */
    public ArrayList getSpriteCollection() {
        return this.spriteCollection;
    }
}
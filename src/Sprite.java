import biuoop.DrawSurface;
/**
*@author Yair Frank, 203699566
*@author Sahar Levi, 203405147
*/
public interface Sprite {
       /**
   * @param d in order to draw any surface we get
   */
   void drawOn(DrawSurface d);

    /**
     *
     * @param dt get the dt in order to turn the game to be per a second
     */
   void timePassed(double dt);
}
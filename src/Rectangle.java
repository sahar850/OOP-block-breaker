import java.util.ArrayList;
/**
*@author Yair Frank, 203699566
*@author Sahar Levi, 203405147
*/
class Rectangle {
    private Point upperLeft;
    private double width;
    private double height;
    /**
    * this method Create a new rectangle with location and width/height.
    * @param upperLeft get the upper left point of the rectangle
    * @param width get the width of the rectangle
    * @param height get the height of the rectangle
    */
   public Rectangle(Point upperLeft, double width, double height) {
   this.upperLeft = upperLeft;
   this.width = width;
   this.height = height;
   }
    /**
    * this method  Return a (possibly empty) List of intersection points
    * with the specified line.
    * @param line get a line to check if it have an intersection point with the
    * rectangel lines
    * @return intersectionList a (possibly empty) List of intersection points
    * with the specified line.
    */
   public java.util.List intersectionPoints(Line line) {
   Line [] arrline = new Line [4];
   arrline[0] = new Line(this.upperLeft.getX(), this.upperLeft.getY(),
   this.width + this.upperLeft.getX(), this.upperLeft.getY());
   arrline[1] = new Line(this.upperLeft.getX(), this.upperLeft.getY(),
   this.upperLeft.getX(), this.upperLeft.getY() + this.height);
   arrline[2] = new Line(this.upperLeft.getX(), this.upperLeft.getY() + this.height,
   this.width + this.upperLeft.getX(), this.upperLeft.getY() + this.height);
   arrline[3] = new Line(this.width + this.upperLeft.getX(), this.upperLeft.getY(),
   this.width + this.upperLeft.getX(), this.upperLeft.getY() + this.height);
   ArrayList intersectionList = new ArrayList();
   int j = 0;
   for (int i = 0; i < 4; i++) {
   if (arrline[i].intersectionWith(line) != null) {
       Point inter = arrline[i].intersectionWith(line);
       intersectionList.add(inter);
       j++;
   }
   }
   if (j > 0) {
       return intersectionList;
   } else {
       return null;
   }
   }
   /**
    * @return width of the rectangle
    */
   public double getWidth() {
       return width;
   }
   /**
    * @return height of the rectangle
    */
   public double getHeight() {
       return height;
   }
   /**
    * @return upper-left point of the rectangle.
    */
   public Point getUpperLeft() {
       return upperLeft;
   }
}
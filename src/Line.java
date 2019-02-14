import java.util.ArrayList;
/**
 * @author Yair Frank, 203699566
 * @author Sahar Levi, 203405147
 */
public class Line {
    private Point start;
    private Point end;
/**
* @param start get a starting point
* @param end get an ending point
*/
public Line(Point start, Point end) {
this.start = start;
this.end = end;
}
/**
* @param x1 get coordination and create a starting x point
* @param y1 get coordination and create an ending y point
* @param x2 get coordination and create an ending x point
* @param y2 get coordination and create an ending y point
*/
public Line(double x1, double y1, double x2, double y2) {
this.start = new Point(x1, y1);
this.end = new Point(x2, y2);
   }
   /**
    * @return the length of the line
    */
   public double length() {
    return this.start.distance(this.end);
   }
   /**
    * @return the middle point of the line
    */
   public Point middle() {
       double mx = (this.start.getX() + this.end.getX()) / 2;
       double my = (this.start.getY() + this.end.getY()) / 2;
       Point middel = new Point(mx, my);
       return middel;
   }
   /**
    * @return the start point
    */
   public Point start() {
       return this.start;
   }
   /**
    * @return the end point
    */
   public Point end() {
       return this.end;
   }
   /**
    * @param other in order to compare with this line
    * @return true if it's intersecting or false if it's not intersecting
    */
   public boolean isIntersecting(Line other) {
       if (this.start.getX() - this.end.getX() == 0 && other.start.getX() - other.end.getX() != 0) {
           double m2 = (other.end.getY() - other.start.getY()) / (other.end.getX() - other.start.getX());
           double b2 = other.end.getY() - (m2 * other.end.getX());
           double xin = this.end.getX();
           double yin = (m2 * xin) + b2;
            if (this.start.getX() < this.end.getX()) {
                if (xin > this.end.getX() || xin < this.start.getX()) {
                    return false;
                }
            } else {
                if (xin < this.end.getX() || xin > this.start.getX()) {
                    return false;
                }
            }
            if (other.start.getX() < other.end.getX()) {
                if (xin > other.end.getX() || xin < other.start.getX()) {
                    return false;
                }
            } else {
                if (xin < other.end.getX() || xin > other.start.getX()) {
                    return false;
                }
            }
            if (this.start.getY() < this.end.getY()) {
                if (yin > this.end.getY() || yin < this.start.getY()) {
                    return false;
                }
            } else {
                if (yin < this.end.getY() || yin > this.start.getY()) {
                    return false;
                }
            }
            if (other.start.getY() < other.end.getY()) {
                if (yin > other.end.getY() || yin < other.start.getY()) {
                    return false;
                }
            } else {
                if (yin < other.end.getY() || yin > other.start.getY()) {
                    return false;
                }
            }
           }
       if (other.start.getX() - other.end.getX() == 0 && this.start.getX() - this.end.getX() != 0) {
          double m1 = (this.end.getY() - this.start.getY()) / (this.end.getX() - this.start.getX());
           double b1 = this.end.getY() - (m1 * this.end.getX());
           double xin = this.end.getX();
           double yin = (m1 * xin) + b1;
           if (this.start.getX() < this.end.getX()) {
               if (xin > this.end.getX() || xin < this.start.getX()) {
                   return false;
               }
           } else {
               if (xin < this.end.getX() || xin > this.start.getX()) {
                   return false;
               }
           }
           if (other.start.getX() < other.end.getX()) {
               if (xin > other.end.getX() || xin < other.start.getX()) {
                   return false;
               }
           } else {
               if (xin < other.end.getX() || xin > other.start.getX()) {
                   return false;
               }
           }
           if (this.start.getY() < this.end.getY()) {
               if (yin > this.end.getY() || yin < this.start.getY()) {
                   return false;
               }
           } else {
               if (yin < this.end.getY() || yin > this.start.getY()) {
                   return false;
               }
           }
           if (other.start.getY() < other.end.getY()) {
               if (yin > other.end.getY() || yin < other.start.getY()) {
                   return false;
               }
           } else {
               if (yin < other.end.getY() || yin > other.start.getY()) {
                   return false;
               }
           }
       }
       double m1 = (this.end.getY() - this.start.getY()) / (this.end.getX() - this.start.getX());
       double m2 = (other.end.getY() - other.start.getY()) / (other.end.getX() - other.start.getX());
       if (m1 == m2) {
          return false;
       }
           double b1 = this.end.getY() - (m1 * this.end.getX());
           double b2 = other.end.getY() - (m2 * other.end.getX());
           double xin = (b1 - b2) / (m2 - m1);
           double yin = (m1 * xin) + b1;
           if (this.start.getX() < this.end.getX()) {
               if (xin > this.end.getX() || xin < this.start.getX()) {
                   return false;
               }
           } else {
               if (xin < this.end.getX() || xin > this.start.getX()) {
                   return false;
               }
           }
           if (other.start.getX() < other.end.getX()) {
               if (xin > other.end.getX() || xin < other.start.getX()) {
                   return false;
               }
           } else {
               if (xin < other.end.getX() || xin > other.start.getX()) {
                   return false;
               }
           }
           if (this.start.getY() < this.end.getY()) {
               if (yin > this.end.getY() || yin < this.start.getY()) {
                   return false;
               }
           } else {
               if (yin < this.end.getY() || yin > this.start.getY()) {
                   return false;
               }
           }
           if (other.start.getY() < other.end.getY()) {
               if (yin > other.end.getY() || yin < other.start.getY()) {
                   return false;
               }
           } else {
               if (yin < other.end.getY() || yin > other.start.getY()) {
                   return false;
               }
           }
           return true;
   }
              /**
           * @param other get the line that the our line will intersect with
           * @return the intersection point that is calculated
           */
   public Point intersectionPoint(Line other) {
       if (this.start.getX() - this.end.getX() == 0 && other.start.getX() - other.end.getX() != 0) {
           double m2 = (other.end.getY() - other.start.getY()) / (other.end.getX() - other.start.getX());
           double b2 = other.end.getY() - (m2 * other.end.getX());
           double xin = this.end.getX();
           double yin = (m2 * xin) + b2;
           Point intersecting = new Point(xin, yin);
           return intersecting;
       }
       if (other.start.getX() - other.end.getX() == 0 && this.start.getX() - this.end.getX() != 0) {
           double m1 = (this.end.getY() - this.start.getY()) / (this.end.getX() - this.start.getX());
           double b1 = this.end.getY() - (m1 * this.end.getX());
           double xin = other.end.getX();
           double yin = (m1 * xin) + b1;
           Point intersecting = new Point(xin, yin);
           return intersecting;
           } else {
       double m1 = (this.end.getY() - this.start.getY()) / (this.end.getX() - this.start.getX());
       double m2 = (other.end.getY() - other.start.getY()) / (other.end.getX() - other.start.getX());
           double b1 = this.end.getY() - (m1 * this.end.getX());
           double b2 = other.end.getY() - (m2 * other.end.getX());
           double xin = (b1 - b2) / (m2 - m1);
           double yin = (m1 * xin) + b1;
           Point intersecting = new Point(xin, yin);
           return intersecting;
       }
}
   /**
    * @param other in order to compare with this line
    * @return the intersection point or null if there is non
    */
   public Point intersectionWith(Line other) {
       if (this.isIntersecting(other)) {
           return intersectionPoint(other);
       }
           return null;
       }
   /**
    * @param other in order to check if the lines are equals
    * @return true if equals and false else
    */
   public boolean equals(Line other) {
    boolean eq1 = this.start.equals(other.start());
    boolean eq2 = this.end.equals(other.end());
    boolean equal;
    if (eq1 && eq2) {
        equal = true;
    } else {
        equal = false;
    }
    return equal;
   }
          /**
        * @param rect the current rectangle the ball will collide with
        * @return the closest point to the start of the line or null we have no intersection points
        */
   public Point closestIntersectionToStartOfLine(Rectangle rect) {
       if (rect.intersectionPoints(this) != null) {
       double min = this.length();
       ArrayList intersectionList = (ArrayList) rect.intersectionPoints(this);
       int j = 0;
       for (int i = 0; i < rect.intersectionPoints(this).size(); i++) {
           Point point = (Point) intersectionList.get(i);
           if (point.distance(this.start) < min) {
               min = point.distance(this.start);
               j = i;
           }
       }
       return (Point) intersectionList.get(j);
  } else {
      return null;
  }
  }
   }
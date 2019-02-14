/**
*@author Yair Frank, 203699566
*@author Sahar Levi, 203405147
*/
public class Point {
private double x;
private double y;
/**
*@param x get the coordination of x delegate
*@param y get the coordination of y delegate
*/
public Point(double x, double y) {
this.x = x;
this.y = y;
}
 /**
*@param other get another point to check their distance
*@return the distance of this point to the other point
*/
public double distance(Point other) {
double powerofx = (this.getX() - other.getX()) * (this.getX() - other.getX());
double powerofy = (this.getY() - other.getY()) * (this.getY() - other.getY());
double distance = Math.sqrt(powerofx + powerofy);
return distance;
}
 /**
*@param other get another point to check if it's equal
*@return false if one point is null and the point else
*/
public boolean equals(Point other) {
if (this == null || other == null) {
return false;
}
return (this.x == other.getX()) && (this.y == other.getY());
}
 /**
*@return the x values of this point
*/
public double getX() {
return this.x;
}
 /**
*@return the y values of this point
*/
public double getY() {
return this.y; }
}
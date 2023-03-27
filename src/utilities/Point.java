package utilities;

public class Point {


    /**
     * This class is the Point class, its job is to represent a 2 dimentional point.
     * It has a X and a Y value, it has some constant values that represent the max and min values of each point.
     * This class has a default constructor, a normal constructor and a copy constructor.
     * This class has a toString method to represent the point as a string and some getters and setters.
     */

    private static final int MAX_X = 1000000;
    private static final int MIN_X = 0;
    private static final int MAX_Y = 800;
    private static final int MIN_Y = 0;
    private double x;
    private double y;

    public Point() {
        this.x = 0;
        this.y = 0;
    }

    public Point(double X, double Y) {
        if (!this.setX(X) || !this.setY(Y)) {
            throw new IllegalArgumentException("X or Y are invalid");
        }
    }

    public Point(Point obj) {
        this.x = obj.getX();
        this.y = obj.getY();
    }

    public String toString() {
        return "( " + this.getX() + " , " + this.getY() + " )";
    } 

    public double getX() { return this.x; };
    public double getY() { return this.y; };

    public boolean setX(double X) { 
        if (X <= MAX_X && X >= MIN_X) {
            this.x = X;
            return true;
        }
        return false;
    };
    
    public boolean setY(double Y) { 
        if (Y <= MAX_Y && Y >= MIN_Y) {
            this.y = Y;
            return true;
        }
        return false;
    };

}

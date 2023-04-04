package utilities;

    /**
     * This class is the Point class, its job is to represent a 2 dimentional point.
     * It has a X and a Y value, it has some constant values that represent the max and min values of each point.
     * <p>This class has a default constructor, a normal constructor and a copy constructor.
     * <p>This class has a toString method to represent the point as a string and some getters and setters.
     */
public class Point {
    
    // Private Variables:
    private static final int MAX_X = 1000000;
    private static final int MIN_X = 0;
    private static final int MAX_Y = 800;
    private static final int MIN_Y = 0;
    private double x;
    private double y;

    /**
     * Default Constructor for class Point, it sets the value of X and the value of Y to 0. 
     */
    public Point() {
        this.setX(0);
        this.setY(0);
    }

    /**
    * Normal Constructor for class Point, it sets the value of X and Y to the given values.
    * @param  X  the x value of the point
    * @param  Y the y value of the point
    */
    public Point(double X, double Y) {
        if (!this.setX(X) || !this.setY(Y)) {
            throw new IllegalArgumentException("X or Y are invalid");
        }
    }

    /**
    * Copy Constructor for class Point, it sets the value of X and Y to the values
    * of the given class, this makes a copy of the class.
    * @param  obj  the object we want to copy from
    */
    public Point(Point obj) {
        this.x = obj.getX();
        this.y = obj.getY();
    }

    /**
    * This function returns a String representation of class point -> (X,Y)
    */
    public String toString() {
        return "( " + this.getX() + " , " + this.getY() + " )";
    } 

    /**
     * @return the X value of the point
     */
    public final double getX() { return this.x; };

    /**
     * @return the Y value of the point
     */
    public final double getY() { return this.y; };

    /**
     * A setter for the X value of class Point. it checks that the value is correct 
     * and within the min an max values of the point class
     * @param X the value we want to set.
     * @return true if the placement succeeded and false if it didnt.
     */
    public boolean setX(double X) { 
        if (X <= MAX_X && X >= MIN_X) {
            this.x = X;
            return true;
        }
        return false;
    };
    
    /**
     * A setter for the Y value of class Point. it checks that the value is correct 
     * and within the min an max values of the point class
     * @param Y the value we want to set.
     * @return true if the placement succeeded and false if it didnt.
     */
    public boolean setY(double Y) { 
        if (Y <= MAX_Y && Y >= MIN_Y) {
            this.y = Y;
            return true;
        }
        return false;
    };

    /**
     * A replacement of the equals method that every class inherits from the main Object class.
     * This function evaluates if the current class (this) and the given class are equal.
     * It looks at the X and Y values.
     * @param other an object of type Point
     * @return true if the objects are the same (have the same X and Y values) and false if the dont.
     */
    public boolean equals(Point other) {
        if (this.getX() == other.getX() && this.getY() == other.getY()) { 
            return true;
        }
        return false;
    }

}

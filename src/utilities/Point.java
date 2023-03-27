package utilities;

public class Point {

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
        this.x = X;
        this.y = Y;
    }

    public Point(Point obj) {
        this.x = obj.getX();
        this.y = obj.getY();
    }

    public String toString() {
        return "( " + this.getX() + " , " + this.getY() + " )";
    } 

    private double getX() { return this.x; };
    private double getY() { return this.y; };

    private boolean setX(double X) { 
        this.x = X;
        return true;
    };
    
    private boolean setY(double Y) { 
        this.y = Y;
        return true;
    };

}

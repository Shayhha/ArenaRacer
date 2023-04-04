package game.racers.air;

import game.racers.Racer;
import game.racers.Wheeled;
import utilities.EnumContainer.Color;


public class Airplane extends Racer implements AerialRacer {

    private static final String CLASS_NAME = "Airplane";
    private static final int DEFAULT_WHEELS = 3;
    private static final double DEFAULT_MAX_SPEED = 885;
    private static final double DEFAULT_ACCELERATION = 100;
    private static final Color DEFAULT_color = Color.BLACK;
    private Wheeled wheeled;

    /**
    * Constructs a new Airplane object with default values for its maximum speed, acceleration, color, and number of wheels.
    * The name of the airplane is set to "Airplane #serial_number".
    */
    public Airplane() {
        super("", DEFAULT_MAX_SPEED, DEFAULT_ACCELERATION, DEFAULT_color);
        this.setName(CLASS_NAME + " #" +this.getSerialNumber());
        this.wheeled = new Wheeled(DEFAULT_WHEELS); //? maybe here i need to use the default constructor of Wheeled?
    }

    /**
    *Constructs a new Airplane object with the specified name, maximum speed, acceleration, color, and number of wheels.
    *@param name the name of the airplane. If null or an empty string is provided, the airplane will be given a default name in the format "Airplane #<serial number>".
    *@param maxSpeed the maximum speed of the airplane
    *@param acceleration the acceleration of the airplane
    *@param color the color of the airplane.
    *@param numOfWheels the number of wheels the airplane has.
    */
    public Airplane(String name, double maxSpeed, double acceleration, Color color, int numOfWheels) {
        super(name, maxSpeed, acceleration, color);

        if (name == null || name == "") {
            this.setName(CLASS_NAME + " #" +this.getSerialNumber()); 
        } 

        this.wheeled = new Wheeled(numOfWheels);
    }

    public String className(){ //return the name of the class rowboat
        return CLASS_NAME;
    }  

    public String describeSpecific() {
        return wheeled.describeSpecific();
    }
    
}

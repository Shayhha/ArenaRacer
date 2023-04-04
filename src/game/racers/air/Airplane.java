package game.racers.air;
import game.racers.Racer;
import game.racers.Wheeled;
import utilities.EnumContainer.Color;

/**
 * Class Airplane extends the class Racer and implenets the interface AerialRacer.
 * This class has access to all the variables of the Racer class through the setter and
 * getter function. And it also has some of its own variables, like Class Name, wheeled 
 * and other variables that hold default values like default max speed and more.
 * <p>
 * This class has a default constructor, a normal constructor and it also overrides 
 * the className and describeSpecific functions of class Racer.
 */
public class Airplane extends Racer implements AerialRacer {

    //------------------- Private Variables -------------------//
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

    /**
     * This is a override of the className method of class Racer
     * @return a String that represents the class name of the given racer, for example: "Airplane"
     */
    @Override
    public String className(){ //return the name of the class Airplane
        return CLASS_NAME;
    }  

    /**
     * This is a override of the describeSpecific method of class Racer
     * @return String that represents the description of the specific attributes of the given racer,
     * for example: "Number of Wheels: 3"
     */
    @Override
    protected String describeSpecific() {
        return wheeled.describeSpecific();
    }
    
}

package game.racers.air;
import game.racers.Racer;
import utilities.EnumContainer.Color;

/**
 * Class Helicopter extends the class Racer and implenets the interface AerialRacer.
 * This class has access to all the variables of the Racer class through the setter and
 * getter function. And it also has some of its own variables, like Class Name, 
 * and other variables that hold default values like default max speed and more.
 * <p>
 * This class has a default constructor, a normal constructor and it also overrides 
 * the className and describeSpecific functions of class Racer.
 */
public class Helicopter extends Racer implements AerialRacer {

    //------------------- Private Variables -------------------//
    private static final String CLASS_NAME = "Helicopter";
    private static final double DEFAULT_MAX_SPEED = 400;
    private static final double DEFAULT_ACCELERATION = 50;
    private static final Color DEFAULT_color = Color.BLUE;

    /**
    * Constructs a new Helicopter object with default values for its maximum speed, acceleration, color.
    * The name of the helicopter is set to "Helicopter #serial_number".
    */
    public Helicopter() {
        super("", DEFAULT_MAX_SPEED, DEFAULT_ACCELERATION, DEFAULT_color);
        this.setName(CLASS_NAME + " #" +this.getSerialNumber());
    }

    /**
    *Constructs a new Helicopter object with the specified name, maximum speed, acceleration, color.
    *@param name the name of the helicopter. If null or an empty string is provided, the helicopter will be given a default name in the format "Helicopter #<serial number>".
    *@param maxSpeed the maximum speed of the helicopter
    *@param acceleration the acceleration of the helicopter
    *@param color the color of the helicopter.
    *@param numOfWheels the number of wheels the helicopter has.
    */
    public Helicopter(String name, double maxSpeed, double acceleration, Color color) {
        super(name, maxSpeed, acceleration, color);

        if (name == null || name == "") {
            this.setName(CLASS_NAME + " #" +this.getSerialNumber());
        } 
    }

    /**
     * This is a override of the className method of class Racer
     * @return a String that represents the class name of the given racer, for example: "Helicopter"
     */
    @Override
    public String className(){ //return the name of the class helicopter
        return CLASS_NAME;
    }

    /**
     * This is a override of the describeSpecific method of class Racer
     * @return String that represents the description of the specific attributes of the given racer,
     * for example: "Number of Wheels: 3"
     */
    @Override
    public String describeSpecific() {
        return ""; // there is nothing specific about the helicopter
    }
    
}

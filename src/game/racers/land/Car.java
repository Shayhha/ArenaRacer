/**
 * Parters:
 * name: Shay Hahiashvili, ID: 206423840
 * name: Maxim Subotin, ID: 207695479
 */
package game.racers.land;

import game.racers.Racer;
import game.racers.Wheeled;
import utilities.EnumContainer;
import utilities.EnumContainer.Color;
import utilities.EnumContainer.Engine;

/**
 * Class Car extends the class Racer and implenets the interface LandRacer.
 * This class has access to all the variables of the Racer class through the setter and
 * getter function. And it also has some of its own variables, like Class Name, wheeled 
 * and other variables that hold default values like default max speed and more.
 * <p>
 * This class has a default constructor, a normal constructor and it also overrides 
 * the className and describeSpecific functions of class Racer.
 */
public class Car extends Racer implements LandRacer {
    
    //------------------- Private Variables -------------------//
    private static final String CLASS_NAME = "Car";
    private static final int DEFAULT_WHEELS = 4;
    private static final double DEFAULT_MAX_SPEED = 400;
    private static final double DEFAULT_ACCELERATION = 20;
    private static final Color DEFAULT_color = Color.RED;
    private EnumContainer.Engine engine = Engine.FOURSTROKE;
    private Wheeled wheeled;

    /**
    * Constructs a new Car object with default values for its maximum speed, acceleration, color, and number of wheels.
    * The name of the car is set to "Car #serial_number".
    */
    public Car() {
        super("", DEFAULT_MAX_SPEED, DEFAULT_ACCELERATION, DEFAULT_color);//calls super class 
        this.setName(CLASS_NAME+" #"+ this.getSerialNumber());//we set default name “RowBoat #<serialNumber>
        this.wheeled = new Wheeled(DEFAULT_WHEELS);
    }

    /**
    *Constructs a new Car object with the specified name, maximum speed, acceleration, color, and number of wheels.
    *@param name the name of the car. If null or an empty string is provided, the car will be given a default name in the format "Bicycle #<serial number>".
    *@param maxSpeed the maximum speed of the car
    *@param acceleration the acceleration of the car
    *@param color the color of the car.
    *@param numOfWheels the number of wheels the car has.
    */
    public Car(String name, double maxSpeed, double acceleration, Color color, int numOfWheels) {
        super(name, maxSpeed, acceleration, color);

        if (name == null || name == "") {
            this.setName(CLASS_NAME + " #" +this.getSerialNumber());
        } 

        this.wheeled = new Wheeled(numOfWheels);
    }

    /**
     * This is a override of the className method of class Racer
     * @return a String that represents the class name of the given racer, for example: "Car"
     */
    @Override
    public String className(){ //return the name of the class bicycle
        return CLASS_NAME;
    }

    /**
     * This is a override of the describeSpecific method of class Racer
     * @return String that represents the description of the specific attributes of the given racer,
     * for example: "Number of Wheels: 4, Engine Type: MOUNTAIN"
     */
    @Override
    public String describeSpecific() {
        return wheeled.describeSpecific() + ", Engine Type: "+ this.engine;
    }
    
    //------------------- setter and getter methods -------------------//

    /**
     * @return a value of enum type Engine that represents the type of the car
     */
    public EnumContainer.Engine getEngin(){return this.engine;}

    /**
     * A set function for setting the engine type of the racer using enum values of type Engine.
     * @param temp is the new boat type you want to set to the racer
     * @return an boolean value that is true if the boat type was updated successfully and false if the update failed
     */
    public boolean setType(EnumContainer.Engine temp){
        this.engine=temp;
        return true;
    }

}

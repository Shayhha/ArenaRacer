package game.racers.land;
import game.racers.Racer;
import utilities.EnumContainer;
import utilities.EnumContainer.Breed;
import utilities.EnumContainer.Color;

/**
 * Class Horse extends the class Racer and implenets the interface LandRacer.
 * This class has access to all the variables of the Racer class through the setter and
 * getter function. And it also has some of its own variables, like Class Name and 
 * other variables that hold default values like default max speed and more.
 * <p>
 * This class has a default constructor, a normal constructor and it also overrides 
 * the className and describeSpecific functions of class Racer.
 */
public class Horse extends Racer implements LandRacer{

    //------------------- Private Variables -------------------//
    private static final String CLASS_NAME = "Horse";
    private static final double DEFAULT_MAX_SPEED=50;
    private static final double DEFAULT_ACCELERATION=3;
    private static final EnumContainer.Color DEFAULT_color = Color.BLACK;
    private EnumContainer.Breed breed = Breed.THOROUGHBRED;

    /**
    * Constructs a new Horse object with default values for its maximum speed, acceleration, color.
    * The name of the horse is set to "Horse #serial_number".
    */
    public Horse(){
        super("", DEFAULT_MAX_SPEED, DEFAULT_ACCELERATION, DEFAULT_color);//calls super class 
        this.setName(CLASS_NAME+" #"+ this.getSerialNumber());//we set default name “Horse #<serialNumber>
    }

    /**
    *Constructs a new Horse object with the specified name, maximum speed, acceleration, color.
    *@param name the name of the horse. If null or an empty string is provided, the horse will be given a default name in the format "Bicycle #<serial number>".
    *@param maxSpeed the maximum speed of the horse
    *@param acceleration the acceleration of the horse
    *@param color the color of the horse.
    */
    public Horse(String name, double maxSpeed, double acceleration, Color color){
        super(name,maxSpeed,acceleration,color);//calls super class ctor
        if(name.equals("")){ //checks if string of name is empty 
            this.setName(CLASS_NAME+" #"+ this.getSerialNumber());//we set default name “Horse #<serialNumber>
        }
    }

    /**
     * This is a override of the className method of class Racer
     * @return a String that represents the class name of the given racer, for example: "Horse"
     */
    @Override
    public String className(){ //return the name of the class bicycle
        return CLASS_NAME;
    }

    /**
     * This is a override of the describeSpecific method of class Racer
     * @return String that represents the description of the specific attributes of the given racer,
     * for example: "Breed: THOROUGHBRED"
     */
    @Override
    public String describeSpecific(){
        return ", Breed: "+ this.breed;
    }

    //------------------- setter and getter methods -------------------//

    /**
     * @return a value of enum type Breed that represents the type of the horse
     */
    public EnumContainer.Breed getType(){return this.breed;}

    /**
     * A set function for setting the horse type of the racer using enum values of type Breed.
     * @param temp is the new boat type you want to set to the racer
     * @return an boolean value that is true if the boat type was updated successfully and false if the update failed
     */
    public boolean setBreed(EnumContainer.Breed temp){
        this.breed=temp;
        return true;
    }
}

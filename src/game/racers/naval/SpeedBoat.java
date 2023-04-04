package game.racers.naval;

import game.racers.Racer;
import utilities.EnumContainer;
import utilities.EnumContainer.BoatType;
import utilities.EnumContainer.Color;
import utilities.EnumContainer.Team;

/**
 * Class SpeedBoat extends the class Racer and implenets the interface NavalRacer.
 * This class has access to all the variables of the Racer class through the setter and
 * getter function. And it also has some of its own variables, like Class Name, Boat Type, 
 * Team and other variables that hold default values like default max speed and more.
 * <p>
 * This class has a default constructor, a normal constructor, getter and setter functions
 * and it also overrides the className and describeSpecific functions of class Racer.
 */
public class SpeedBoat extends Racer implements NavalRacer {

    //------------------- Private Variables -------------------//
    private static final String CLASS_NAME = "SpeedBoat";
    private static final double DEFAULT_MAX_SPEED = 170;
    private static final double DEFAULT_ACCELERATION = 5;
    private static final EnumContainer.Color DEFAULT_color = Color.RED;
    private EnumContainer.BoatType type = BoatType.SKULLING;
    private EnumContainer.Team team = Team.DOUBLE;
 
    /**
     * Default constructor for objects of class SpeedBoat, it sets the values of the instance to the 
     * default values that are located in the private variables in the class.<p> It also setts the name
     * of the racer to a combination of its class name and the serial number of the racer, for example: "SpeedBoat #15"
     */
    public SpeedBoat() {
        super("", DEFAULT_MAX_SPEED, DEFAULT_ACCELERATION, DEFAULT_color);//calls super class 
        this.setName(CLASS_NAME+" #"+ this.getSerialNumber());//we set default name “RowBoat #<serialNumber>
    }

    /**
     * Normal constructor for object of class SpeedBoat, setts the values given to the constructor into the fields
     * of the instance using the super constructor and set methods.<p>Also takes care of the posibility that the 
     * user didnt input a name for the racer, in that case we are adding the class name and the serial number. 
     * @param name the name of the racer
     * @param maxSpeed the max speed the racer can go
     * @param acceleration the acceleration of the racer during the racer
     * @param color the color of the racer
     */
    public SpeedBoat(String name, double maxSpeed, double acceleration, Color color) {
        super(name, maxSpeed, acceleration, color);

        if (name == null || name == "") {
            this.setName(CLASS_NAME + " #" +this.getSerialNumber()); 
        } 
    }

    /**
     * This is a override of the className method of class Racer
     * @return a String that represents the class name of the given racer, for example: "Car"
     */
    @Override
    public String className(){ //return the name of the class rowboat
        return CLASS_NAME;
    }
    
    /**
     * This is a override of the describeSpecific method of class Racer
     * @return String that represents the description of the specific attributes of the given racer,
     * for example: "Type: SKULLING, Team: SINGLE"
     */
    @Override
    public String describeSpecific() {
        return "Type: "+ this.type +", Team: "+this.team;
    }
    
    //------------------- setter and getter methods -------------------//

    /**
     * @return a value of enum type BoatType that represents the type of the boat
     */
    public EnumContainer.BoatType getType(){return this.type;}

    /**
     * @return a value of enum type Team that represents the tema of the boat
     */
    public EnumContainer.Team getTeam(){return this.team;}

    /**
     * A set function for setting the boat type of the racer using enum values of type BoatType.
     * @param temp is the new boat type you want to set to the racer
     * @return an boolean value that is true if the boat type was updated successfully and false if the update failed
     */
    public boolean setType(EnumContainer.BoatType temp){
        this.type=temp;
        return true;
    }

    /**
     * A set function for setting the team of the racer using enum values of type Team.
     * @param temp is the new team you want to set to the racer
     * @return an boolean value that is true if the team was updated successfully and false if the update failed
     */
    public boolean setTeam(EnumContainer.Team temp){
        this.team=temp;
        return true;
    }

}

package game.racers.land;
import game.racers.Racer;
import utilities.EnumContainer;
import utilities.EnumContainer.Breed;
import utilities.EnumContainer.Color;

public class Horse extends Racer implements LandRacer{

    private static final String CLASS_NAME = "Horse";
    private static final double DEFAULT_MAX_SPEED=50;
    private static final double DEFAULT_ACCELERATION=3;
    private static final EnumContainer.Color DEFAULT_color = Color.BLACK;
    private EnumContainer.Breed breed = Breed.THOROUGHBRED;

    public Horse(){// default ctor
        super("", DEFAULT_MAX_SPEED, DEFAULT_ACCELERATION, DEFAULT_color);//calls super class 
        this.setName(CLASS_NAME+" #"+ this.getSerialNumber());//we set default name “Horse #<serialNumber>
    }

    public Horse(String name, double maxSpeed, double acceleration, Color color){
        super(name,maxSpeed,acceleration,color);//calls super class ctor
        if(name.equals("")){ //checks if string of name is empty 
            this.setName(CLASS_NAME+" #"+ this.getSerialNumber());//we set default name “Horse #<serialNumber>
        }
    }

    public String className(){ //return the name of the class rowboat
        return CLASS_NAME;
    } 

    public String describeSpecific(){
        return "Breed: "+ this.breed;
    }

    //setter and getter methods
    public EnumContainer.Breed getType(){return this.breed;}
    public boolean setBreed(EnumContainer.Breed temp){
        this.breed=temp;
        return true;
    }
}

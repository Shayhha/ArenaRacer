package game.racers.land.naval;
import game.racers.Racer;
import game.racers.naval.NavalRacer;
import utilities.EnumContainer;
import utilities.EnumContainer.BoatType;
import utilities.EnumContainer.Color;
import utilities.EnumContainer.Team;

public class RowBoat extends Racer implements NavalRacer{
    /*
     * Rowboat class
     * includes default and regular ctors
     * getter and setter methods
     * implemetation of abstract methods from super class racer
     */

    private static final String CLASS_NAME = "RowBoat";
    private static final double DEFAULT_MAX_SPEED=75;
    private static final double DEFAULT_ACCELERATION=10;
    private static final EnumContainer.Color DEFAULT_color = Color.RED;
    private EnumContainer.BoatType type =BoatType.SKULLING;
    private EnumContainer.Team team=Team.DOUBLE;

    public RowBoat(){// default ctor
        super("", DEFAULT_MAX_SPEED, DEFAULT_ACCELERATION, DEFAULT_color);//calls super class 
        this.setName(CLASS_NAME+" #"+ this.getSerialNumber());//we set default name “RowBoat #<serialNumber>
    }

    public RowBoat(String name, double maxSpeed, double acceleration, Color color){
        super(name,maxSpeed,acceleration,color);//calls super class ctor
        if(name.equals("")){ //checks if string of name is empty 
            this.setName(CLASS_NAME+" #"+ this.getSerialNumber());//we set default name “RowBoat #<serialNumber>
        }
    }

    public String className(){ //return the name of the class rowboat
        return this.getClass().getSimpleName();
    } 

    public String describeSpecific(){
        return "Type: "+ this.type +", Team: "+this.team;
    }

    //setter and getter methods
    public EnumContainer.BoatType getType(){return this.type;}
    public EnumContainer.Team getTeam(){return this.team;}
    public boolean setType(EnumContainer.BoatType temp){
        this.type=temp;
        return true;
    }
    public boolean setTeam(EnumContainer.Team temp){
        this.team=temp;
        return true;
    }
}

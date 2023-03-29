package game.racers.naval;

import game.racers.Racer;
import utilities.EnumContainer;
import utilities.EnumContainer.BoatType;
import utilities.EnumContainer.Color;
import utilities.EnumContainer.Team;

public class SpeedBoat extends Racer implements NavalRacer {

    private static final String CLASS_NAME = "SpeedBoat";
    private static final double DEFAULT_MAX_SPEED = 170;
    private static final double DEFAULT_ACCELERATION = 5;
    private static final EnumContainer.Color DEFAULT_color = Color.RED;
    private EnumContainer.BoatType type = BoatType.SKULLING;
    private EnumContainer.Team team = Team.DOUBLE;

    public SpeedBoat() {
        super("", DEFAULT_MAX_SPEED, DEFAULT_ACCELERATION, DEFAULT_color);//calls super class 
        this.setName(CLASS_NAME+" #"+ this.getSerialNumber());//we set default name “RowBoat #<serialNumber>
    }

    public SpeedBoat(String name, double maxSpeed, double acceleration, Color color) {
        super(name, maxSpeed, acceleration, color);

        if (name == null || name == "") {
            this.setName(CLASS_NAME + " #" +this.getSerialNumber()); 
        } 
    }

    public String className(){ //return the name of the class rowboat
        return CLASS_NAME;
    }
    
    public String describeSpecific() {
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

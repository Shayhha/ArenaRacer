package game.racers.land;

import game.racers.Racer;
import game.racers.Wheeled;
import utilities.EnumContainer;
import utilities.EnumContainer.Color;
import utilities.EnumContainer.BicycleType;


public class Bicycle extends Racer implements LandRacer {

    private static final String CLASS_NAME = "Bicycle";
    private static final int DEFAULT_WHEELS = 2;
    private static final double DEFAULT_MAX_SPEED = 270;
    private static final double DEFAULT_ACCELERATION = 10;
    private static final Color DEFAULT_color = Color.GREEN;
    private EnumContainer.BicycleType type = BicycleType.MOUNTAIN;
    private Wheeled wheeled;

    public Bicycle() {
        super("", DEFAULT_MAX_SPEED, DEFAULT_ACCELERATION, DEFAULT_color);//calls super class 
        this.setName(CLASS_NAME+" #"+ this.getSerialNumber());//we set default name “RowBoat #<serialNumber>
        this.wheeled = new Wheeled(DEFAULT_WHEELS);
    }

    public Bicycle(String name, double maxSpeed, double acceleration, Color color, int numOfWheels) {
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
        return wheeled.describeSpecific() + "Bicycle Type: "+ this.type;
    }
    
    //setter and getter methods
    public EnumContainer.BicycleType getType(){return this.type;}
    public boolean setType(EnumContainer.BicycleType temp){
        this.type=temp;
        return true;
    }
}

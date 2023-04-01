package game.racers.land;

import game.racers.Racer;
import game.racers.Wheeled;
import utilities.EnumContainer;
import utilities.EnumContainer.Color;
import utilities.EnumContainer.Engine;

public class Car extends Racer implements LandRacer {
    
    private static final String CLASS_NAME = "Car";
    private static final int DEFAULT_WHEELS = 4;
    private static final double DEFAULT_MAX_SPEED = 400;
    private static final double DEFAULT_ACCELERATION = 20;
    private static final Color DEFAULT_color = Color.RED;
    private EnumContainer.Engine engine = Engine.FOURSTROKE;
    private Wheeled wheeled;

    public Car() {
        super("", DEFAULT_MAX_SPEED, DEFAULT_ACCELERATION, DEFAULT_color);//calls super class 
        this.setName(CLASS_NAME+" #"+ this.getSerialNumber());//we set default name “RowBoat #<serialNumber>
        this.wheeled = new Wheeled(DEFAULT_WHEELS);
    }

    public Car(String name, double maxSpeed, double acceleration, Color color, int numOfWheels) {
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
        return wheeled.describeSpecific() + ", Engine Type: "+ this.engine;
    }
    
    //setter and getter methods
    public EnumContainer.Engine getEngin(){return this.engine;}
    public boolean setType(EnumContainer.Engine temp){
        this.engine=temp;
        return true;
    }

}

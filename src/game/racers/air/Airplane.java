package game.racers.air;

import game.racers.Racer;
import game.racers.Wheeled;
import utilities.EnumContainer.Color;


public class Airplane extends Racer implements AerialRacer {

    private static final String CLASS_NAME = "Airplane";
    private static final int DEFAULT_WHEELS = 3;
    private static final double DEFAULT_MAX_SPEED = 885;
    private static final double DEFAULT_ACCELERATION = 100;
    private static final Color DEFAULT_color = Color.BLACK;
    private Wheeled wheeled;

    public Airplane() {
        super("", DEFAULT_MAX_SPEED, DEFAULT_ACCELERATION, DEFAULT_color);
        this.setName(CLASS_NAME + " #" +this.getSerialNumber());
        this.wheeled = new Wheeled(DEFAULT_WHEELS); //? maybe here i need to use the default constructor of Wheeled?
    }

    public Airplane(String name, double maxSpeed, double acceleration, Color color, int numOfWheels) {
        super(name, maxSpeed, acceleration, color);

        if (name == null || name == "") {
            this.setName(CLASS_NAME + " #" +this.getSerialNumber()); //! getSerialNumber might not work here
        } 

        this.wheeled = new Wheeled(numOfWheels);
    }

    public String className(){ //return the name of the class rowboat
        return CLASS_NAME;
    }  

    public String describeSpecific() {
        return wheeled.describeSpecific();
    }
    
}

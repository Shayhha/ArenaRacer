package game.racers.air;

import game.racers.Racer;
import utilities.EnumContainer.Color;


public class Helicopter extends Racer implements AerialRacer {

    private static final String CLASS_NAME = "Helicopter";
    private static final double DEFAULT_MAX_SPEED = 400;
    private static final double DEFAULT_ACCELERATION = 50;
    private static final Color DEFAULT_color = Color.BLUE;

    public Helicopter() {
        super("", DEFAULT_MAX_SPEED, DEFAULT_ACCELERATION, DEFAULT_color);
        this.setName(CLASS_NAME + " #" +this.getSerialNumber());
    }

    public Helicopter(String name, double maxSpeed, double acceleration, Color color) {
        super(name, maxSpeed, acceleration, color);

        if (name == null || name == "") {
            this.setName(CLASS_NAME + " #" +this.getSerialNumber()); //! getSerialNumber might not work here
        } 
    }

    public String className(){ //return the name of the class rowboat
        return CLASS_NAME;
    }

    public String describeSpecific() {
        return "";
    }
    
}

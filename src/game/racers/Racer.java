package game.racers;
import utilities.*;
import utilities.EnumContainer.Color;
import game.arenas.Arena;

public abstract class Racer {
    private int serialNumber;
    private String name;
    private Point currentLocation;
    private Point finish;
    private Arena arena;
    private double maxSpeed;
    private double acceleration;
    private double currentSpeed;
    private double failureProbability;
    private EnumContainer.Color color; //maybe wont work
    private Mishap mishap;

    public Racer(String name, double maxSpeed, double acceleration, Color color){
        this.name = name;
        this.maxSpeed = maxSpeed;
        this.acceleration = acceleration;
        this.color = color;
    }

    public abstract void initRace(Arena arena, Point start, Point finish);
    

    public Point move(double friction){ //method for racer to show his current location on track
        if(this.currentSpeed < this.maxSpeed){
        this.currentSpeed += this.acceleration*friction;
        this.currentLocation.setX(this.currentLocation.getX()+this.currentSpeed);
        }
        return this.currentLocation;
    }

    public abstract String describeSpecific(); //return number of wheels or horse type and stuff
        
    public String describeRacer(){
        return "Racer id: " + this.serialNumber + " Name: " + this.name + this.describeSpecific();
    }
    public void introduce(){
        System.out.println(this.className() + ": " + this.describeRacer());
    }
    public abstract String className(); //return the name of the class

    public boolean hasMishap() {
        return false; // TODO
    }
    //add setter and getter functions 

    public Point getCurrentLocation(){return this.currentLocation;} //getter for current location
}

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
    //private Mishap mishap;

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

    public String describeSpecific(){ //needs to be worked on
        return "Racer id: "+this.serialNumber+" Name: "+this.name;
    }
    public String describeRacer(){}
    public void introduce(){}
    public String className(){return "ClassName<Racer>";}
    public boolean hasMishap(){}
    //add setter and getter functions 
}

package game.racers;
import utilities.*;
import utilities.EnumContainer.Color;
import game.arenas.Arena;

public class Racer {
    private int serialNumber;
    private String name;
    //private Point currentLocation;
    //private Point finish;
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

    public EnumContainer.Color getC(){
        return this.color;
    }

    public static void main(String[] args) {
        EnumContainer.Color c = Color.RED;
        Racer r = new Racer("yes",1000,200,c);
        System.out.println("Print: "+r.color);
    }

}

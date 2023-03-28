package game.racers;
import utilities.*;
import utilities.EnumContainer.Color;
import game.arenas.Arena;
import utilities.Fate;

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
        if(this.currentSpeed < this.maxSpeed){ //calcs racers new point
        this.currentSpeed += this.acceleration*friction;
        this.currentLocation.setX(this.currentLocation.getX()+this.currentSpeed);
        }

        if(hasMishap()==true){ //we check if there is a mishap
            if(this.mishap.getFixable() == true && this.mishap.getTurnsToFix()==0){//if true then we check if its fixable and has 0 turns
                this.mishap=null;//if true we changing mishap to null
            }
        }
        else{//else we dont have a mishap so we generate one if breakdown function returns true
            if(Fate.breakDown()==true){
                this.mishap=Fate.generateMishap();
            }
        }
        
        if(hasMishap()==true){ //we checks if we still have a mishap/new one generated
            this.acceleration *= this.mishap.getReductionFactor();//we reduce the acceleration
            this.mishap.setTurnsToFix(this.mishap.getTurnsToFix()-1);//we reduce the fix time
        }
        return this.currentLocation; //return new point
    }

    public abstract String describeSpecific(); //return number of wheels or horse type and stuff
        
    public String describeRacer(){
        return "Racer id: " + this.serialNumber + " Name: " + this.name + this.describeSpecific();
    }
    public void introduce(){
        System.out.println(this.className() + ": " + this.describeRacer());
    }
    public abstract String className(); //return the name of the class

    public boolean hasMishap() {//chrcks if there is a mishap
        if(this.mishap.getFixable()==true){
            return true;
        }
        return false;
    }
    //add setter and getter functions 

    public Point getCurrentLocation(){return this.currentLocation;} //getter for current location
}

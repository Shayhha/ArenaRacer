package game.racers;
import utilities.*;
import utilities.EnumContainer.Color;
import game.arenas.Arena;
import utilities.Fate;

public abstract class Racer {
    private static int instanceCounter=1; // we use this static field to initialize serialNumber for each instance of class 
    private int serialNumber;
    private String name;
    private Point currentLocation;
    private Point finish;
    private Arena arena;
    private double maxSpeed;
    private double acceleration;
    private double currentSpeed;
    private double failureProbability;
    private EnumContainer.Color color; 
    private Mishap mishap;

    public Racer(String name, double maxSpeed, double acceleration, Color color){ //? maybe here we need to use the setters?
        this.name = name;
        this.maxSpeed = maxSpeed;
        this.acceleration = acceleration;
        this.color = color;
        this.serialNumber = instanceCounter;
        instanceCounter++; //we increase the insatanceField for each instace of class
    }

    public void initRace(Arena arena, Point start, Point finish){
        this.currentLocation = start;//we initilaize currentLocation
        this.finish=finish; //initilaze finish
    }
    

    public Point move(double friction){ //method for racer to show his current location on track

        if(hasMishap()==true){ //we check if there is a mishap
            if(this.mishap.getFixable() == true && this.mishap.getTurnsToFix()==0){//if true then we check if its fixable and has 0 turns
                this.mishap=null;//if true we changing mishap to null
            }
            else{
                //this.mishap.toString();
            }
        }
        else{//else we dont have a mishap so we generate one if breakdown function returns true
            if(Fate.breakDown()==true){
                this.mishap=Fate.generateMishap();
            }
        }

        if(this.currentSpeed < this.maxSpeed){ //calcs racers new point
        this.currentSpeed += this.acceleration*friction;
        this.currentLocation.setX(this.currentLocation.getX()+this.currentSpeed);
        }

        if(hasMishap()==true){ //we checks if we still have a mishap/new one generated
            System.out.println(this.getName() + " has a mishap ! " + this.mishap.toString());
            this.acceleration += this.mishap.getReductionFactor();//we reduce the acceleration
            this.mishap.setTurnsToFix(this.mishap.getTurnsToFix()-1);//we reduce the fix time
        }
        return this.currentLocation; //return new point
    }

    public abstract String describeSpecific(); //return number of wheels or horse type and stuff
        
    public String describeRacer(){
        return "name: " + this.getName() + ", " +
        "SerialNumber: " + this.getSerialNumber() + ", " +
        "maxSpeed: " + this.getMaxSpeed() + ", " +
        "acceleration: " + this.getAcceleration() + ", " +
        "color: " + this.getColor() +  ", " +/* this line might give an error, we are trying to print an enum value */
        this.describeSpecific();
    }

    public void introduce(){
        System.out.println("[" +this.className()+ "] " + this.describeRacer());
    }

    public String className(){ //return the name of the class
        return this.getClass().getSimpleName();
    } 

    public boolean hasMishap() {//checks if there is a mishap
        if(this.mishap != null){
            return true;
        }
        return false;
    }

    //add setter and getter functions 

    public Point getCurrentLocation(){return this.currentLocation;} //getter for current location

    public boolean setCurrentLocation(Point newPoint) { //setter for current location
        if (this.currentLocation.setX(newPoint.getX()) && this.currentLocation.setY(newPoint.getY())) {
            return true;
        }
        return false;
    }


    public Arena getArena(){return this.arena;}

    public boolean setArena(Arena a) { 
        this.arena = a;
        return true;
    }

    public int getSerialNumber(){return this.serialNumber;}

    public boolean setSerialNumber(int number) {
        this.serialNumber = number;
        return true;
    }

    public String getName() { return this.name; }

    public boolean setName(String temp){
        this.name = temp;
        return true;
    }

    public Point getFinish(){return this.finish;} //getter for finish location

    public boolean setFinish(Point newPoint) { //setter for finish location
        if (this.finish.setX(newPoint.getX()) && this.finish.setY(newPoint.getY())) {
            return true;
        }
        return false;
    }

    public double getMaxSpeed() { return this.maxSpeed; }

    public boolean setMaxSpeed(double value) { this.maxSpeed = value; return true; }

    public double getAcceleration() { return this.acceleration; }

    public boolean setAcceleration(double value) { this.acceleration = value; return true; }

    public double getCurrentSpeed() { return this.currentSpeed; }

    public boolean setCurrentSpeed(double value) { this.currentSpeed = value; return true; }

    public double getFailureProbability() { return this.failureProbability; }

    public boolean setFailureProbability(double value) { this.failureProbability = value; return true; }

    public Mishap getMishap() { return this.mishap; }

    public boolean setMishap(Mishap newMishap) {
    /**
     * there is a small problem here, if one of the setters returns true and the next returns false,
     * then we will have a mishap with incorrect data because one field will change and the other wont,
     * is this a problem?
     */

        if (this.mishap.setFixable(newMishap.getFixable()) &&
            this.mishap.setReductionFactor(newMishap.getReductionFactor()) &&
            this.mishap.setTurnsToFix(newMishap.getTurnsToFix())) {
            return true;
        }
        return false;
    }

    public EnumContainer.Color getColor() { return this.color; }

    public boolean setColor(EnumContainer.Color newColor) { 
        this.color = newColor;
        return true;
    }

    public boolean equals(Object obj){ //! for testing 
        if(obj instanceof Racer){
            if(this.name == ((Racer)obj).name && this.serialNumber == ((Racer)obj).serialNumber){
                return true;
            }
        }
        return false;
    }

}

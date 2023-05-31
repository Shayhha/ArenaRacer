/**
 * Partners:
 * name: Shay Hahiashvili, ID: 206423840
 * name: Maxim Subotin, ID: 207695479
 */
package game.racers;
import utilities.*;
import utilities.EnumContainer.Color;
import GUI.MainWindow;
import factory.Observable;
import game.arenas.Arena;

/**
 * The Racers class is an abstract class that represents the avarage racer in our program.
 * The Racer has many private variables like name, serial number, current location, max speed, acceleration and more.
 * <p>The Racer also has a Constructor, and a few methods like move, introduce, hasMishap, className and more, 
 * and also some setter and getter methods.
 * <p>All of the methods have a purpose, how ever the method describeSpecific is an Abstract Method because we dont 
 * have enought information in the Racer class to describe its sub classes. 
 */
public abstract class Racer extends Observable implements Runnable, Cloneable {

    //------------------- Private Variables -------------------//
    private static int instanceCounter = 1; // we use this static field to initialize serialNumber for each instance of class 
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

    /**
     * A normal Constructor for class Racer, it gets 4 parameters and 
     * uses the setter functions to check the params and add them to the instance.
     * 
     * @param name the name of the racer
     * @param maxSpeed the max speed the racer can reach
     * @param acceleration the acceleration of the racer
     * @param color the color of the racer
     */
    public Racer(String name, double maxSpeed, double acceleration, Color color){ 
        this.setName(name);
        this.setMaxSpeed(maxSpeed);
        this.setAcceleration(acceleration);
        this.setColor(color);
        this.setSerialNumber(instanceCounter);
        instanceCounter++; //we increase the insatanceField for each instace of class
    }

    /**
     * this method ensures that the current racer is initialized correctly into the race, it sets the racer's starting
     * point and finish point. 
     * @param arena the arena reference that we add the racer into
     * @param start the start location represented by an instans of class Point
     * @param finish the finish location represented by an instans of class Point
     */
    public void initRace(Arena arena, Point start, Point finish){
        this.addObserver(arena);//adds arena to observer list
        this.currentLocation = start; //we initilaize currentLocation
        this.finish=finish; //initilaze finish
        this.arena = arena;
    }
    
    /**
     * The move method handels the move of each racer in every turn of the game.
     * It gets an argument of friction and calculates the new position of the racer based on
     * a few parameters like the existance of a mishap and the fixability of the mishap and more.
     * @param friction the amount by which the acceleration needs to be modified for this current move
     * @return an instans of Point that represents the new location of the racer after the move was made.
     */
    public Point move(double friction){ //method for racer to show his current location on track
        double newAcc = this.getAcceleration(); // getting the original acceleration of the racer for later use
        double newSpeed = this.getCurrentSpeed(); // getting the original currentSpeed of the racer for later use

        // if the racer has a mishap and it is fixable and the turns to fix is 0 then we regard it as if he does not have a mishap
        if(this.hasMishap() && this.mishap.getFixable() == true && this.mishap.getTurnsToFix()==0){
            this.mishap = null;
        }
        // if the racer does not have a mishap then we need to try to generate a new one using the methods of class Fate provided to us
        if(this.hasMishap() == false){ 
            if(Fate.breakDown()==true){ // if a mishap needs to be generate we generate a new one, else there is no mishap this turn
                this.mishap = Fate.generateMishap();
                System.out.println(this.getName() + " has a new mishap! " + this.mishap.toString()); // whenever a new mishap is generated we print it out
            }
        }

        //if racer has new/old mishap we reduce the turns to fix with nextTurn method and calculating the new reduced the acceleration
        if(this.hasMishap()){
            this.mishap.nextTurn(); 
            newAcc *=this.mishap.getReductionFactor(); 
        }

        // calculating the racers new current speed and then his new location
        if(this.currentSpeed < this.maxSpeed) {  
            newSpeed += newAcc*friction;
            if(newSpeed > this.maxSpeed) //check if racer surpassed his declared maxspeed
                this.currentSpeed=this.maxSpeed;//newSpeed = this.maxSpeed;
            else
                this.currentSpeed = newSpeed;
        }

        // # # --------- Part of Assignment 2 --------- # # //
        
        // moving the current racer's icon on the screen the exact amount that he needs to move based on his speed
        if (this.currentLocation.getX()+newSpeed > this.getArena().getLength()) { // checking if the racer is about to cross the finish line and making him stop exactly on the finish line
            // calculating exactly the distance left between the racer's location and the finish line, then adding exactly that amount to the racer's position making him stop exactly on top of the finish line
            MainWindow.moveRacer(this.getSerialNumber(), (int)this.getArena().getLength() - (int)this.currentLocation.getX(), 0); 
        }
        else // if the racer still go some way to go untill he reaches the finish line
            MainWindow.moveRacer(this.getSerialNumber(), (int)newSpeed, 0);

        // making the gui update every 30 milliseconds by adding this timer right here after the racers moved on screen
        try {
            Thread.sleep(30);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // # # ---------------------------------------- # # //

        this.currentLocation.setX((int)this.currentLocation.getX()+newSpeed); // setting the new position of the racer
        return this.currentLocation; //return new position
    }

    /**
     * an abstract function that us used to describe the specific traites of the racer, for example Car has 4 wheels
     * @return returns a string that describes the specific trait of the racer
     */
    public abstract String describeSpecific(); 
        
    /**
     * a general function that describes the data we have about the racer, that includes his name, serial number, 
     * max speed and more. This function also calls the describeSpecific function for each racer to return his specific information.
     * @return a string that represents the data of the racer
     */
    public String describeRacer(){
        return "name: " + this.getName() + ", " +
        "SerialNumber: " + this.getSerialNumber() + ", " +
        "maxSpeed: " + this.getMaxSpeed() + ", " +
        "acceleration: " + this.getAcceleration() + ", " +
        "color: " + this.getColor() +  ", " +/* this line might give an error, we are trying to print an enum value */
        this.describeSpecific();
    }

    /**
     * This funcion prints out ALL of the information about a given racer, from his name to the number of wheels. 
     * It uses the describeRacer function that uses the describeSpecific function.
     */
    public void introduce(){
        System.out.println("[" +this.className()+ "] " + this.describeRacer());
    }

    /**
     * @return a String that represents the name of the class of this racer.
     */
    public String className(){ //return the name of the class
        return this.getClass().getSimpleName();
    } 

    /**
     * @return a boolean value (true or false) that represents the existance of a mishap for the given racer. True if he has a mishap and False if not.
     */
    public boolean hasMishap() {//checks if there is a mishap
        if (this.mishap != null) {
            return true;
        }
        return false;
    }
    
    //!(volatile keyword can make a parameter visable to all threads in real time, e.g volatile int num)
    /**
     * run() method of thread racer, calls move() method for the racer until he finsihes the race.
     * in each iteration thread is sleeping for given peroid
     * when racer finsihes we call croosFinishLine() method to add racer to completedRacers and remove the racer from activeRacers list
     * <p>
     * we do synchronization for the following methods for thread safety:
     * @method void update(Observable)
     */
    public void run() { 
        while(this.currentLocation.getX() < this.arena.getLength()){
            this.move(this.arena.getFriction()); //calls move method for racer
            try { //makes thread to sleep every iteration by 100 miliseconds
                Thread.sleep(100);
            }
            catch (InterruptedException e){
                e.printStackTrace(); //prints error
            }
        }
        if(this.currentLocation.getX() >= this.arena.getLength()){ //if racer has finsihed the race we call notifyObservers method
            this.currentLocation.setX(this.arena.getLength()); //if racer finishes we give set final location to length of arena
            this.notifyObservers(this); //notifys arena that racer has finished the race
        }   
    }

    //------------------- setter and getter functions -------------------//

    /**
     * @return an instance of class Point that represents the current location of the racer.
     */
    public final Point getCurrentLocation(){return this.currentLocation;} //getter for current location

    /**
     * A set function for setting the current location of the racer.
     * @param newPoint is the new location you want to set to the racer, has an X and Y value
     * @return an boolean value that is true if the location was updated successfully and false if the update failed
     */
    public boolean setCurrentLocation(Point newPoint) { //setter for current location
        if (this.currentLocation.setX(newPoint.getX()) && this.currentLocation.setY(newPoint.getY())) {
            return true;
        }
        return false;
    }

    /**
     * @return an instance of class Arena that represents the current arena of the racer.
     */
    public final Arena getArena(){return this.arena;}

    /**
     * A set function for setting the arena of the racer.
     * @param a an instance of class Arena
     * @return an boolean value that is true if the arena was updated successfully and false if the update failed.
     */
    public boolean setArena(Arena a) { 
        this.arena = a;
        return true;
    }

    /**
     * @return an int value that represents the serial number of the racer.
     */
    public final int getSerialNumber(){return this.serialNumber;}

    /**
     * A set function for setting the serial number of the racer.
     * @param number an integer that will represent the serial number of the racer
     * @return an boolean value that is true if the serial number was updated successfully and false if the update failed.
     */
    public boolean setSerialNumber(int number) {
        this.serialNumber = number;
        return true;
    }

    //!!!!! add comments
    public static int getInstanceCounter() {return Racer.instanceCounter; }

    public static boolean setInstanceCounter() { Racer.instanceCounter++; return true; }


    /**
     * @return a String value that represents the name of the racer.
     */
    public final String getName() { return this.name; }

    /**
     * A set function for setting the name of the racer.
     * @param temp a String with the new name we want to give the racer
     * @return an boolean value that is true if the name was updated successfully and false if the update failed.
     */
    public boolean setName(String temp){
        this.name = temp;
        return true;
    }

    /**
     * @return an instans of class Point that represents the finish location of the racer.
     */
    public final Point getFinish(){return this.finish;} //getter for finish location

    /**
     * A set function for setting the finish location of the racer.
     * @param newPoint an instance of type Point that represents the finish location of the racer
     * @return an boolean value that is true if the finish location was updated successfully and false if the update failed.
     */
    public boolean setFinish(Point newPoint) { //setter for finish location
        if (this.finish.setX(newPoint.getX()) && this.finish.setY(newPoint.getY())) {
            return true;
        }
        return false;
    }

    /**
     * @return a double value that represents the max speed of the racer.
     */
    public final double getMaxSpeed() { return this.maxSpeed; }

    /**
     * A set function for setting the max speed of the racer.
     * @param value a double value that represents the new max speed of the racer
     * @return an boolean value that is true if the max speed was updated successfully and false if the update failed.
     */
    public boolean setMaxSpeed(double value) { this.maxSpeed = value; return true; }

    /**
     * @return a double value that represents the acceleration of the racer.
     */
    public final double getAcceleration() { return this.acceleration; }

    /**
     * A set function for setting the acceleration of the racer.
     * @param value a double value that represents the new acceleration of the racer
     * @return an boolean value that is true if the acceleration was updated successfully and false if the update failed.
     */
    public boolean setAcceleration(double value) { this.acceleration = value; return true; }

    /**
     * @return a double value that represents the current speed of the racer.
     */
    public final double getCurrentSpeed() { return this.currentSpeed; }

    /**
     * A set function for setting the current speed of the racer.
     * @param value a double value that represents the new current speed of the racer
     * @return an boolean value that is true if the current speed was updated successfully and false if the update failed.
     */
    public boolean setCurrentSpeed(double value) { this.currentSpeed = value; return true; }

    /**
     * @return a double value that represents the failure probability of the racer.
     */
    public final double getFailureProbability() { return this.failureProbability; }

    /**
     * A set function for setting the failure probability of the racer.
     * @param value a double value that represents the new failure probability of the racer
     * @return an boolean value that is true if the failure probability was updated successfully and false if the update failed.
     */
    public boolean setFailureProbability(double value) { this.failureProbability = value; return true; }

    /**
     * @return an instans of class Mishap that represents the existence, or lack there of, a mishap for the racer.
     */
    public final Mishap getMishap() { return this.mishap; }

    /**
     * A set function for setting the mishap of the racer.
     * @param newMishap an instance of class Mishap that will represent the new mishap of the racer
     * @return an boolean value that is true if the mishap was updated successfully and false if the update failed.
     */
    public boolean setMishap(Mishap newMishap) { //we need to check if all set methods return true value
        if (this.mishap.setFixable(newMishap.getFixable()) &&
            this.mishap.setReductionFactor(newMishap.getReductionFactor()) &&
            this.mishap.setTurnsToFix(newMishap.getTurnsToFix())) {
            return true;
        }
        return false;
    }

    /**
     * @return an enum value of type Color that represents the color of the racer.
     */
    public final EnumContainer.Color getColor() { return this.color; }

    /**
     * A set function for setting the color of the racer.
     * @param newColor an enum Color type value that represents the new color of the racer
     * @return an boolean value that is true if the color was updated successfully and false if the update failed.
     */
    public boolean setColor(EnumContainer.Color newColor) { 
        this.color = newColor;
        return true;
    }

    /**
     * This is the equals method that every class inherits from the main Object class, we use it later in the
     * code inorder to determin if two instances of type Racer are the same or different.
     * @param obj an instance that inherits from the main Object class that we want to eveluate against our current object.
     * @return a boolean value if the current racer (this) and the other racer (obj) are the exact same, meaning they have the same values in each field.
     */
    public boolean equals(Object obj){ //equals method for Racer class for our use later
        if(obj instanceof Racer){
            if(this.name == ((Racer)obj).name && 
            this.serialNumber == ((Racer)obj).serialNumber && 
            this.currentLocation.equals(((Racer)obj).currentLocation) && 
            this.finish.equals(((Racer)obj).finish) &&
            this.maxSpeed == ((Racer)obj).maxSpeed && 
            this.acceleration == ((Racer)obj).acceleration && 
            this.currentSpeed == ((Racer)obj).currentSpeed && 
            this.failureProbability == ((Racer)obj).failureProbability && 
            this.color == ((Racer)obj).color) {
                return true;
            } 
        } 
        return false;
    }

    public Object clone() {
        Object clone = null;
        try {
           clone = super.clone();
        } catch (CloneNotSupportedException e) {
           e.printStackTrace();
        }
        return clone;
    }
}

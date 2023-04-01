package game.arenas;
import java.util.ArrayList;
import java.util.List;
import game.racers.Racer;
import utilities.Point;
import game.arenas.exceptions.*;

/**
* Arena class represents an object of arena circuit
* includes constructor and methods for arena, with initRace that initilizes the current race and activates move method for each racer
* class includes getter and setter methods for the parameteres
* <p>
* 
* @param  activeRacers this represents list of active racers in the game
* @param  completedRacers this represents list of racers that complited the race
* @param  FRICTION represents friction of arena
* @param  MAX_RACERS represents maximun racers in a given race
* @param  MIN_Y_GAP represents the gap between each racer
* @param  length represents the length of the race
*/
public abstract class Arena {

    private List<Racer> activeRacers = new ArrayList<Racer>();
    private List<Racer> completedRacers = new ArrayList<Racer>();
    private final double FRICTION;
    private final int MAX_RACERS;
    private final static int MIN_Y_GAP = 10;
    private double length; // x value of finish line

    
    public Arena(double length, int maxRacers, double friction){ //ctor
        this.length = length;
        this.MAX_RACERS = maxRacers;
        this.FRICTION = friction;
    }
    /**
    *addRacer method checks if object type is for same instance if not throws RacerTypeException
    *also we check is we are at full capacity if so we throw RacerLimitException
    *we leave this method for subclasses to implement
    * <p>
    */    
    
    public abstract void addRacer(Racer newRacer) throws RacerLimitException, RacerTypeException;

    /**
    *initRace creates two points, start and end, 
    then for each racer it sets his gap in the race and activates initRace method for each racer
    *
    *
    * <p>
    */
    public void initRace(){
        Point start = new Point(); //starting point
        Point end = new Point(this.length,0); //ending point
        int i = 0;
        for (Racer r : activeRacers) { //foreach racer we set the values of X and Y with MIN_Y_GAP and we call InitRace method for the racer
            start.setY(i * MIN_Y_GAP);
            end.setY(i * MIN_Y_GAP);
            r.initRace(this, start, end);
            i++; // we use i to organize the Racers on the track with the currect Y gap
        }
    }

    /**
    * checks if list of activeRacers if its empty
    * returns true or flase 
    * 
    *
    * <p>
    */
    public boolean hasActiveRacers(){ //checks if racers array is empthy
        if(this.activeRacers.size()>0)
            return true;
        return false;
    }

    /**
    * playTurn methods aticvates move method in racer class for each racer in list 
    * if racer has finished the race he gets deleted by creating temp list and that way we copy all besides him
    * after that we call crossFinishLine method
    * 
    * <p>
    */
    public void playTurn() {
        if (this.activeRacers.size() != 0) {
            for (Racer r1: this.activeRacers) { //goes through all racers calls move method for each
                r1.move(this.FRICTION);
                //System.out.println(this.ActiveRacers.size());
                if(r1.getCurrentLocation().getX() >= this.length){ //if racer has finsihed the race we call crossFinishedLine method
                    List<Racer> temp = new ArrayList<Racer>(); //temp list
                    for (Racer r2 : activeRacers) { //deletes the obj from arrayList
                        if(r2.equals(r1)==false)
                            temp.add(r2);
                    }
                    this.activeRacers = temp;
                    crossFinishLine(r1);
                }
            }
        }
    }
    /**
    * crossFinishLine method 
    * gets a Racer instance and adds it to list of completedRacers
    *
    * <p>
    */
    public void crossFinishLine(Racer racer){ //gets a Racer and adds it to completeRacers
        this.completedRacers.add(racer);
    }

    /**
    * showResult method 
    * prints race results
    *
    * <p>
    */
    public void showResults() {
        int place = 0;
        for (Racer racer : completedRacers) {
            System.out.println("#" + place + " -> " + racer.describeRacer());
            place+=1;
        }
    }

    //get & set methods
    public double getFriction(){ return this.FRICTION;}
    public double getMIN_Y_GAP(){return MIN_Y_GAP;}
    public int getMAX_RACERS(){return this.MAX_RACERS;}
    public List<Racer> getActiveRacers(){return this.activeRacers;}
    public List<Racer> getCompletedRacers(){return this.completedRacers;}
    public double length(){return this.length;}
    public boolean setLength(double t){
        this.length=t;
        return true;
    }

}

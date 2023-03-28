package game.arenas;
import java.util.ArrayList;
import java.util.List;
import game.racers.Racer;
import utilities.Point;
import game.arenas.exceptions.*;


public class Arena {

    private List<Racer> ActiveRacers = new ArrayList<Racer>();
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

    public void addRacer(Racer newRacer){ //add racer
        try{
            if((newRacer instanceof Racer) == false){ //throws exception if given instance isnt "Racer"
                throw new RacerTypeException(newRacer);
            }
            else if(this.ActiveRacers.size()+1 > this.MAX_RACERS){ //throws exception if list is at max capacity
                throw new RacerTypeException(newRacer);
            }
            else{ //else we add a new racer 
                this.ActiveRacers.add(newRacer);
            }
        }
        catch(Exception e){ //catches the exceptions and prints them
            System.out.println(e.getMessage());
        }
    }

    public void initRace(){
        Point start = new Point(); //starting point
        Point end = new Point(this.length,0); //ending point
        int i = 0;
        for (Racer r : ActiveRacers) { //foreach racer we set the values of X and Y with MIN_Y_GAP and we call InitRace method for the racer
            start.setY(i * MIN_Y_GAP);
            end.setY(start.getY());
            r.initRace(this, start, end);
            i++; // we use i to organize the Racers on the track with the currect Y gap
        }
    }


    public boolean hasActiveRacers(){ //checks if racers array is empthy
        if(this.ActiveRacers.size()>0)
            return true;
        return false;
    }

    public void playTurn() {
        for (Racer r1: this.ActiveRacers) { //goes through all racers calls move method for each
            r1.move(this.FRICTION);
            if(r1.getCurrentLocation().getX() == this.length){ //if racer has finsihed the race we call crossFinishedLine method
                crossFinishLine(r1);
            }
        }
    }

    public void crossFinishLine(Racer racer){ //gets a Racer and removes it from activeRacers and adds it to completeRacers
        this.ActiveRacers.remove(racer);
        this.completedRacers.add(racer);
    }

    public void showResults() {
        int place = 0;
        for (Racer racer : completedRacers) {
            System.out.println("Place " + place + ":" + racer.describeRacer());
            place+=1;
        }
    }

    //get & set methods
    public double getFriction(){ return this.FRICTION;}
    public double getMIN_Y_GAP(){return MIN_Y_GAP;}
    public int getMAX_RACERS(){return this.MAX_RACERS;}
    public List<Racer> getActiveRacers(){return this.ActiveRacers;}
    public List<Racer> getCompletedRacers(){return this.completedRacers;}
    public double length(){return this.length;}
    public boolean setLength(double t){
        this.length=t;
        return true;
    }

}

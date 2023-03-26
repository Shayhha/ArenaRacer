package game.arenas;
import java.util.ArrayList;
import java.util.List;
import game.racers.Racer;

public abstract class Arena {

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
                throw new Exception("RacerTypeExeption");
            }
            else if(this.ActiveRacers.size()+1 > this.MAX_RACERS){ //throws exception if list is at max capacity
                throw new Exception("RacerLimitException");
            }
            else{ //else we add a new racer 
                this.ActiveRacers.add(newRacer);
            }
            
        }
        catch(Exception e){ //catches the exceptions and prints them
            System.out.println(e);
        }
    }

    public void initRace(){}
    public boolean hasActiveRacers(){
        if(this.ActiveRacers.size()>0)
            return true;
        return false;
    }
    public void playTurn(){}
    public void crossFinishLine(Racer racer){}
    public void showResults(){}

}

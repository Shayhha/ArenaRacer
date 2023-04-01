package game.arenas.land;
import game.arenas.Arena;
import game.racers.Racer;
import game.racers.land.LandRacer;
import game.arenas.exceptions.*;
import utilities.EnumContainer;
import utilities.EnumContainer.Coverage;
import utilities.EnumContainer.LandSurface;

public class LandArena extends Arena {
    /*
     * LandArena
     * represends Land 
     * has set and get methods for parameter
     * default ctor and regular ctor
     */

    private static double DEFAULT_FRICTION=0.5;
    private final static int DEFAULT_MAX_RACERS=8;
    private final static int DEFAULT_LENGTH=800;
    private EnumContainer.Coverage coverage = Coverage.GRASS;
    private EnumContainer.LandSurface surface = LandSurface.FLAT;

    public LandArena(){//default ctor
        super(DEFAULT_LENGTH,DEFAULT_MAX_RACERS,DEFAULT_LENGTH);
    }

    public LandArena(double length, int maxRacers){//ctor 
        super(length,maxRacers,DEFAULT_FRICTION);
    }
    
    /**
    *addRacer method checks if object type is for same instance if not throws RacerTypeException
    *also we check is we are at full capacity if so we throw RacerLimitException
    *if everything is ok we add the racer to list
    * <p>
    */   
    public void addRacer(Racer newRacer) throws RacerLimitException, RacerTypeException{ 
        newRacer.setArena(this); //calls setArena to set racers field
        if(!(newRacer instanceof LandRacer)){ //checks if racer is not from the desired type and throws exception 
            throw new RacerTypeException(newRacer);
        } 
        else if(this.getActiveRacers().size()+1 > this.getMAX_RACERS()){ //throws exception if list is at max capacity
            throw new RacerLimitException(newRacer);
        }
        else{ //else we add a new racer 
            this.getActiveRacers().add(newRacer);     
        }
    }

    //setter and getter methods
    public EnumContainer.Coverage getCoverage(){return this.coverage;}
    public EnumContainer.LandSurface getSurface(){return this.surface;}
    
    public boolean setCoverage(EnumContainer.Coverage temp){
        this.coverage = temp;
        return true;
    }
    public boolean setSurface(EnumContainer.LandSurface temp){
        this.surface = temp;
        return true;
    }
}
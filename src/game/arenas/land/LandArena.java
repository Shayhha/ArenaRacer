/**
 * Parters:
 * name: Shay Hahiashvili, ID: 206423840
 * name: Maxim Subotin, ID: 207695479
 */
package game.arenas.land;
import game.arenas.Arena;
import game.racers.Racer;
import game.racers.land.LandRacer;
import game.arenas.exceptions.*;
import utilities.EnumContainer;
import utilities.EnumContainer.Coverage;
import utilities.EnumContainer.LandSurface;

    /**
     * LandArena class
     * represents aerial races
     * includes ctor for class with super inplementation for superclass
     * methods to set parameters
     * methods to get parameters
     * <p>
     * 
     * @param  DEFAULT_FRICTION this represents default arena friction
     * @param  DEFAULT_MAX_RACERS represents max racers in the arena
     * @param  DEFAULT_LENGTH default length of the arena 
     * @param  covrage represents covrage of race
     * @param  surface represents the surface type
     */
public class LandArena extends Arena {

    //------------------- Private Variables -------------------//
    private static double DEFAULT_FRICTION=0.5;
    private final static int DEFAULT_MAX_RACERS=8;
    private final static int DEFAULT_LENGTH=800;
    private EnumContainer.Coverage coverage = Coverage.GRASS;
    private EnumContainer.LandSurface surface = LandSurface.FLAT;

    /**
    * A default constructs, creates a new LandArena object with default values for its DEFAULT_LENGTH, 
    * DEFAULT_MAX_RACERS and DEFAULT_FRICTION
    */
    public LandArena(){//default ctor
        super(DEFAULT_LENGTH,DEFAULT_MAX_RACERS,DEFAULT_FRICTION);
    }

    /**
    * A normal constructs, creates a new LandArena object with default values for its DEFAULT_LENGTH, 
    * DEFAULT_MAX_RACERS and DEFAULT_FRICTION
    */
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

    //------------------- setter and getter methods -------------------//
    public final EnumContainer.Coverage getCoverage(){return this.coverage;}
    public final EnumContainer.LandSurface getSurface(){return this.surface;}
    
    public boolean setCoverage(EnumContainer.Coverage temp){
        this.coverage = temp;
        return true;
    }
    public boolean setSurface(EnumContainer.LandSurface temp){
        this.surface = temp;
        return true;
    }
}

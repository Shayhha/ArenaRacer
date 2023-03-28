package game.arenas.land;
import game.arenas.Arena;
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

package game.arenas.naval;
import game.arenas.Arena;
import game.racers.Racer;
import game.racers.naval.NavalRacer;
import game.arenas.exceptions.*;
import utilities.EnumContainer;
import utilities.EnumContainer.Body;
import utilities.EnumContainer.Water;
import utilities.EnumContainer.WaterSurface;

public class NavalArena extends Arena{
    /*
     * NavelArena
     * represends navel race
     * has setter and getter for parameters
     * has default ctor and regular ctor
     */
    private static double DEFAULT_FRICTION=0.7;
    private final static int DEFAULT_MAX_RACERS=5;
    private final static int DEFAULT_LENGTH=1000;
    private EnumContainer.Water water = Water.SWEET;
    private EnumContainer.WaterSurface surface = WaterSurface.FLAT;
    private EnumContainer.Body body= Body.LAKE;

    public NavalArena(){
        super(DEFAULT_LENGTH,DEFAULT_MAX_RACERS,DEFAULT_LENGTH);
    }

    public NavalArena(double length, int maxRacers){
        super(length,maxRacers,DEFAULT_FRICTION);//calls super class with desired parameters
    }

    /**
    *addRacer method checks if object type is for same instance if not throws RacerTypeException
    *also we check is we are at full capacity if so we throw RacerLimitException
    *if everything is ok we add the racer to list
    * <p>
    */
    public void addRacer(Racer newRacer) throws RacerLimitException, RacerTypeException{ 
        newRacer.setArena(this); //calls setArena to set racers field
        if(!(newRacer instanceof NavalRacer)){ //checks if racer is not from the desired type and throws exception 
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
    public EnumContainer.Water getWater(){return this.water;}
    public EnumContainer.WaterSurface getSurface(){return this.surface;}
    public EnumContainer.Body getBody(){return this.body;}
    
    public boolean setWater(EnumContainer.Water temp){
        this.water = temp;
        return true;
    }
    public boolean setSurface(EnumContainer.WaterSurface temp){
        this.surface = temp;
        return true;
    }
    public boolean setBody(EnumContainer.Body temp){
        this.body = temp;
        return true;
    }

}
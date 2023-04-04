package game.arenas.air;
import game.arenas.Arena;
import game.racers.Racer;
import game.racers.air.AerialRacer;
import game.arenas.exceptions.*;
import utilities.EnumContainer;
import utilities.EnumContainer.Height;
import utilities.EnumContainer.Vision;
import utilities.EnumContainer.Weather;
import utilities.EnumContainer.Wind;

    /**
     * AerialArena class
     * represents aerial races
     * includes ctor for class with super inplementation for superclass
     * methods to set parameters
     * methods to get parameters
     * <p>
     * 
     * @param  DEFAULT_FRICTION this represents default arena friction
     * @param  DEFAULT_MAX_RACERS represents max racers in the arena
     * @param  DEFAULT_LENGTH default length of the arena 
     * @param  vison represents vision of race
     * @param  weather represents the weather condition
     * @param height represents how high the race is
     * @param wind represets the state of wind in race
     */
    
public class AerialArena extends Arena {
    private static double DEFAULT_FRICTION=0.4;
    private final static int DEFAULT_MAX_RACERS=6;
    private final static int DEFAULT_LENGTH=1500;
    private EnumContainer.Vision vision = Vision.SUNNY;
    private EnumContainer.Weather weather = Weather.DRY;
    private EnumContainer.Height height=Height.HIGH;
    private EnumContainer.Wind wind=Wind.HIGH;

    public AerialArena(){ //defult ctor
        super(DEFAULT_LENGTH,DEFAULT_MAX_RACERS,DEFAULT_FRICTION);
    }

    public AerialArena(double length, int maxRacers){ //ctor
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
        if(!(newRacer instanceof AerialRacer)){ //checks if racer is not from the desired type and throws exception 
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
    public final EnumContainer.Vision getVision(){return this.vision;}
    public final EnumContainer.Weather getWeather(){return this.weather;}
    public final EnumContainer.Height getHeight(){return this.height;}
    public final EnumContainer.Wind getWind(){return this.wind;}
    public boolean setVision(EnumContainer.Vision temp){
        this.vision = temp;
        return true;
    }
    public boolean setWeather(EnumContainer.Weather temp){
        this.weather = temp;
        return true;
    }
    public boolean setHeight(EnumContainer.Height temp){
        this.height = temp;
        return true;
    }
    public boolean setWind(EnumContainer.Wind temp){
        this.wind = temp;
        return true;
    }

}

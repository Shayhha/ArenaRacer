package game.arenas.exceptions;
import game.racers.Racer;

public class RacerLimitException extends Exception {
    private String message;

    public RacerLimitException(Racer r){
        this.message= "Arena is full! (" + r.getArena().getMAX_RACERS()+ " active racers exist). racer "+ r.getSerialNumber()+ " was not added";
    }

    public String getMessage(){
        return this.message;
    }
}


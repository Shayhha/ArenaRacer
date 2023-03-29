package game.arenas.exceptions;
import game.racers.*;

public class RacerTypeException extends Exception{
    private String message;

    public RacerTypeException(Racer r){
        this.message= "Invalid Racer of type \""+ r.className() +"\" for "+r.getArena().getClass().getSimpleName()+ ".";
    }

    public String getMessage(){
        return this.message;
    }
}

package game.arenas.exceptions;
import game.racers.Racer;

/**
*RacerLimitException class extendes Exception class
* includes constractor with our customised string 
* class includes getMassage that we use in program
* <p>
*@param message - represetns our customized message we want the exception to throw
*/
public class RacerLimitException extends Exception {
    private String message;

    public RacerLimitException(Racer r){ //ctor
        this.message= "Arena is full! (" + r.getArena().getMAX_RACERS()+ " active racers exist). racer #"+ r.getSerialNumber()+ " was not added";
    }

    /**
     * getMassage method
     * @return message parameter
     */
    public String getMessage(){
        return this.message;
    }
}


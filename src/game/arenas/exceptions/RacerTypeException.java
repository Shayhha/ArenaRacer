/**
 * Partners:
 * name: Shay Hahiashvili, ID: 206423840
 * name: Maxim Subotin, ID: 207695479
 */
package game.arenas.exceptions;
import game.racers.*;

/**
*RacerTypeException class extendes Exception class
* includes constractor with our customised string 
* class includes getMassage that we use in program
* <p>
*@param message - represetns our customized message we want the exception to throw
*/
public class RacerTypeException extends Exception{
    private String message;

    public RacerTypeException(Racer r){
        this.message= "Invalid Racer of type \""+ r.className() +"\" for "+r.getArena().getClass().getSimpleName()+ ".";
    }
     /**
     * getMassage method
     * @return message parameter
     */
    public final String getMessage(){
        return this.message;
    }
}

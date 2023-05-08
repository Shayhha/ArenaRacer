package factory;
import game.racers.Racer;

/**
* Observer interface 
*<p>
* Methods:
* <p>
* void update() - method for observer
* <p>
*/
public interface Observer { //Observer interface for Observer/Observable design pattern
    public void update(Racer racer); //update method 
}

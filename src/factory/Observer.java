package factory;

/**
* Observer interface 
*<p>
* Methods:
* <p>
* void update() - method for observer
* <p>
*/
public interface Observer { //Observer interface for Observer/Observable design pattern
    public void update(Observable obj); //update method 
    //public void RacerStateChanged(Observable obj); //state changed method for state design pattern
}


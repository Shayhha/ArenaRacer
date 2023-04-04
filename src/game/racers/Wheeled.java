package game.racers;

/**
* Wheeled class 
* includes constructor and methods
* class includes getter and setter methods for the parameteres
* <p>
* 
* @param  numOfWheels this represents number of wheels that racers vehicle has
*/
public class Wheeled {
    private int numOfWheels;

    public Wheeled() { //default ctor
        this.numOfWheels = 0;
    }

    public Wheeled(int numOfWheels) { //regular ctor
        setNumOfWheeles(numOfWheels);
    }

/**
 * describedSpecific method
 * @return String that represents number of wheeles
 */
    public String describeSpecific() {
        return "Number of Wheels: " + this.getNumOfWheeles();
    }

/**
 * getNumOfWheeles method
 * @return number of wheeles
 */
    public final int getNumOfWheeles() {
        return this.numOfWheels;
    }

/**
 * setNumOfWheeles method
 * recives an integer and sets it to numberOfWheels parameter
 * @return true or false
 */
    public boolean setNumOfWheeles(int numOfWheels) {
        if (numOfWheels >= 0) {
            this.numOfWheels = numOfWheels;
            return true;
        }
        this.numOfWheels = 0; // deafult value is 0, incase of a bad input
        return false;
    }
}

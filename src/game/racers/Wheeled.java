package game.racers;

public class Wheeled {
    private int numOfWheels;

    public Wheeled() {
        this.numOfWheels = 0;
    }

    public Wheeled(int numOfWheels) {
        setNumOfWheeles(numOfWheels);
    }

    public String describeSpecific() {
        return "Number of Wheels: " + this.getNumOfWheeles();
    }

    public int getNumOfWheeles() {
        return this.numOfWheels;
    }

    public boolean setNumOfWheeles(int numOfWheels) {
        if (numOfWheels >= 0) {
            this.numOfWheels = numOfWheels;
            return true;
        }
        this.numOfWheels = 0; // deafult value is 0, incase of a bad input
        return false;
    }
}

/**
 * Partners:
 * name: Shay Hahiashvili, ID: 206423840
 * name: Maxim Subotin, ID: 207695479
 */
package utilities;
import java.text.DecimalFormat;

/**
 * Class Mishap represents a specific mishap a racer can get during the race The mishap has 3 values,
 * fixable - determins if the mishap can be fix and the racer will only be subject to acceleration reduction, or
 * the mishap is not fixable in which case the racer would not be able to move for a few turns.
 * reductionFactor - determins by how much should the racers acceleration be reduced.
 * turnsToFix - determins after how many turns will the mishap go away.
 * <p>The class has a normal constructor and a  nextTurn method that reduced the turnsToFix by 1.
 */
public class Mishap {

    //------------------- Private Variables -------------------//
    private boolean fixable;
    private double reductionFactor;
    private int turnsToFix;

    /**
     * Constructs a new Mishap object with values for its fixable, turnsToFix and reductionFactor fields.
     * @param fixable determins if the mishap can be fix or not
     * @param turnsToFix determins after how many turns will the mishap go away
     * @param reductionFactor determins by how much should the racers acceleration be reduced
     */
    public Mishap(boolean fixable, int turnsToFix, double reductionFactor) {
        this.fixable = fixable;
        this.turnsToFix = turnsToFix;
        this.reductionFactor = reductionFactor;
    }

    /**
     * If the mishap is indeed fixable, this method will reduce the amount of turns to fix the mishap by 1.
     */
    public void nextTurn() { 
        if (fixable) {
            setTurnsToFix(this.getTurnsToFix() - 1);
        }
    }

    /**
     * This method retuns a String that represents the mishap and it looks like this: (false, 3, 0.44)
     */
    public String toString() {
        DecimalFormat formatter = new DecimalFormat("0.00");
        return "( " + this.getFixable() + ", " + this.getTurnsToFix() + ", " + formatter.format(this.getReductionFactor()) + " )";
    }

    //------------------- setter and getter methods -------------------//

    /**
     * Returns the boolean value of the fixable field.
     */
    public final boolean getFixable() {
        return this.fixable;
    }

    /**
     * Returns the boolean value of true if the fixable field was updated successfuly.
     * @param value a boolean value we want to set the fixable field to
     */
    public boolean setFixable(boolean value) {
        this.fixable = value;
        return true;
    }

    /**
     * Returns a double that is the value of the reductionFactor field in the mishap object.
     */
    public final double getReductionFactor() {
        return this.reductionFactor;
    }

    /**
     * Returns the boolean value of true if the reductionFactor field was updated successfuly, else returns false.
     * @param value a double value we want to set the reductionFactor field to
     */
    public boolean setReductionFactor(double value) {
        if (value >= 0) {
            this.reductionFactor = value;
            return true;
        }
        return false;
    }

    /**
     * Returns an int that is the value of the turnsToFix field in the mishap object.
     */
    public final int getTurnsToFix() {
        return this.turnsToFix;
    }

    /**
     * Returns the boolean value of true if the turnsToFix field was updated successfuly, else returns false.
     * @param value an int value we want to set the turnsToFix field to
     */
    public boolean setTurnsToFix(int value) {
        if (value >= 0) {
            this.turnsToFix = value;
            return true;
        }
        return false;
    }
}

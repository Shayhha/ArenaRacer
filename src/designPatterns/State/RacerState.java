/**
 * Partners:
 * name: Shay Hahiashvili, ID: 206423840
 * name: Maxim Subotin, ID: 207695479
 */
package designPatterns.State;
import game.racers.Racer;

/**
 * The State interface is our implementation of the State design pattern. It has one method that needs
 * to be implemented that will determine how the racer should react when a state is changed.
 */
public interface RacerState {
    /**
     * The action the racer needs to take when his state is changed, each state implements this method
     * in a different way.
     * @param racer the racer that his state was changed
     */
    public void action(Racer racer);
}

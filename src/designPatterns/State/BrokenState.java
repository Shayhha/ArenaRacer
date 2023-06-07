package designPatterns.State;
import game.racers.Racer;

/**
 *  This class represents the BROKEN state of a racer. It implements the RacerState interface by overriding the
 *  action method to print the time when the racer broke down.
 */
public class BrokenState implements RacerState {
    /**
     * Printing the time when the racer broke down from the start of the race.
     * @param racer the racer that changed his state to BROKEN
     */
    @Override
    public void action(Racer racer) {
        System.out.println("Racer " + (racer).getName() + " is broken at " + (racer.getBrokenTime())); //prints the broken time of racer
    }
}
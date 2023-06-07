package designPatterns.State;
import game.arenas.Arena;
import game.racers.Racer;

/**
 *  This class represents the DISABLED state of a racer. It implements the RacerState interface by overriding the
 *  action method to print that the racer has failed, and indicated to the arena that this racer is out of the race.
 */
public class DisabledState implements RacerState {
    /**
     * Print that the racer has failed, increment the number of inactive racers in the arena and remove the arena
     * from the list of the racer's observers.
     * @param racer the racer that changed his state to DISABLED
     */
    @Override
    public void action(Racer racer) {
        Arena a = racer.getArena(); //get arena instance
        System.out.println("Racer " + (racer).getName() + " has failed"); //prints that racer failed
        a.setNumOfInactiveRacers(a.getNumOfInactiveRacers() + 1); //increase the invactive number of racers
        racer.removeObserver(a); //remove the racer from observers 
    }
}

package designPatterns.State;
import game.arenas.Arena;
import game.racers.Racer;

/**
 *  This class represents the ACTIVE state of a racer. It implements the RacerState interface by overriding the
 *  action method to calculate and print the current location of the racer.
 */
public class ActiveState implements RacerState {
    /**
     * Calculating the racers position in the race compared to other racers
     * @param racer the racer that changed his state to ACTIVE
     */
    @Override
    public void action(Racer racer) {
        Arena a = racer.getArena(); //gets arena instance
        int rating = a.getOriginalNumOfRacers() - (a.getActiveRacers().size() - (a.CalculateRacerRating(racer)+1)); //gets current rank in race
        System.out.println("Racer " + (racer).getName() + " is currently ranked " + rating); //prints the current rank of racer
    }
}

package designPatterns.State;
import game.arenas.Arena;
import game.racers.Racer;

public class DisabledState implements RacerState {
    @Override
    public void action(Racer racer) {
        Arena a = racer.getArena(); //get arena instance
        System.out.println("Racer " + (racer).getName() + " has failed"); //prints that racer failed
        a.setNumOfInactiveRacers(a.getNumOfInactiveRacers() + 1); //increase the invactive number of racers
        racer.removeObserver(a); //remove the racer from observers 
    }
}

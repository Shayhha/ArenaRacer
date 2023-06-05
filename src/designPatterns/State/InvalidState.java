package designPatterns.State;
import game.arenas.Arena;
import game.racers.Racer;

public class InvalidState implements RacerState {
    @Override
    public void action(Racer racer) {
        Arena a = racer.getArena();
        System.out.println("Racer " + (racer).getName() + " has failed");
        a.setNumOfInactiveRacers(a.getNumOfInactiveRacers() + 1);
        racer.removeObserver(a); //++++
    }
}

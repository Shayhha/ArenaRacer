package designPatterns.State;
import game.arenas.Arena;
import game.racers.Racer;

public class CompletedState implements RacerState{
    @Override
    public void action(Racer racer) {
        racer.notifyObservers(racer);
//        Arena a = racer.getArena();
//        a.update(racer); //++++
        System.out.println("Racer " + (racer).getName() + " has finished the race");
    }
}

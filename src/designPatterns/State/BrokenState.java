package designPatterns.State;
import game.racers.Racer;

public class BrokenState implements RacerState{
    @Override
    public void action(Racer racer) {
        System.out.println("Racer " + (racer).getName() + " is broken at " + (racer.getBrokenTime()));
    }
}
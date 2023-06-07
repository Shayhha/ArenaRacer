package designPatterns.State;
import game.racers.Racer;

public class CompletedState implements RacerState{
    @Override
    public void action(Racer racer) {
        racer.notifyObservers(racer); //if racer finished we notify the arena 
        System.out.println("Racer " + (racer).getName() + " has finished the race"); //prints that racer finished
    }
}

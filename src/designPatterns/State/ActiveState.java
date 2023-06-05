package designPatterns.State;

import game.arenas.Arena;
import game.racers.Racer;

public class ActiveState implements RacerState {
    @Override
    public void action(Racer racer) {
        Arena a = racer.getArena();
        int rating = a.getOriginalNumOfRacers() - (a.getActiveRacers().size() - (a.CalculateRacerRating(racer)+1));
        System.out.println("Racer " + (racer).getName() + " is currently ranked " + rating);
    }
}

package designPatterns.State;
import java.util.ArrayList;
import java.util.List;

import game.arenas.Arena;
import game.racers.Racer;

public class CompletedState implements RacerState{
    @Override
    public void action(Racer racer) {
        Arena arena = racer.getArena();
        synchronized(arena) {
            arena.crossFinishLine((Racer)racer); //calls crossFinishedLine to add new racer to completedRacers list
            List<Racer> temp = new ArrayList<Racer>(); //temp list
            for (Racer r2 : arena.getActiveRacers()) { //deletes the obj from list
                if(r2.equals(racer)==false) //copys all elements excet deleted obj
                    temp.add(r2);
            }
            arena.setActiveRacers(temp); //gives activrRacers temp's reference
            racer.removeObserver(arena);//removes the arena from list of observers
        }
        System.out.println("Racer " + racer.getName() + " has finished the race"); //prints that racer finished
    }
}

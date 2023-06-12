/**
 * Partners:
 * name: Shay Hahiashvili, ID: 206423840
 * name: Maxim Subotin, ID: 207695479
 */
package designPatterns.State;
import java.util.ArrayList;
import java.util.List;
import game.arenas.Arena;
import game.racers.Racer;

/**
 *  This class represents the COMPLETED state of a racer. It implements the RacerState interface by overriding the
 *  action method to remove the racer from the completed racers list of the arena and print that the racer has finished.
 */
public class CompletedState implements RacerState {
    /**
     * Remove the current racer from the list of active racers in the arena and print that the racer has finished.
     * @param racer the racer that changed his state to COMPLETED
     */
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

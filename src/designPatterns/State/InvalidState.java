package designPatterns.State;
import game.arenas.Arena;
import game.racers.Racer;

import java.util.ArrayList;
import java.util.List;

public class InvalidState implements RacerState {
    @Override
    public void action(Racer racer) {
        Arena a = racer.getArena();
//        synchronized(a.getActiveRacers()){
//            List<Racer> temp = new ArrayList<Racer>(); //temp list
//            for (Racer r2 : a.getActiveRacers()) { //deletes the obj from arrayList
//                if(r2.equals(racer))
//                    temp.add(r2);
//            }
//            a.setActiveRacers(temp);
//            System.out.println("Racer " + (racer).getName() + " has failed");
//        }
        System.out.println("Racer " + (racer).getName() + " has failed");
        a.setNumOfInactiveRacers(a.getNumOfInactiveRacers() + 1);
        racer.removeObserver(a); //++++
        //racer.getCurrentLocation().setX(a.getLength()); //++++
    }
}

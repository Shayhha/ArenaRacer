package designPatterns;

import game.arenas.Arena;
import game.arenas.air.AerialArena;
import game.arenas.land.LandArena;
import game.arenas.naval.NavalArena;

public class Factory {
    
    public Factory(){} //default ctor for Factory class
    /**
     * Method that handels creation of new instance of arena class, based on classed parameters 
     * @param arenaName - string that represents arena name 
     */
    public Arena MakeArena(String arenaName, double length, int maxRacers){ 
        if (arenaName.equalsIgnoreCase("Land")) {
            return new LandArena(length, maxRacers);
        } 
        else if (arenaName.equalsIgnoreCase("Naval")) {
            return new NavalArena(length, maxRacers);
        } 
        else if (arenaName.equalsIgnoreCase("Aerial")) {
            return new AerialArena(length, maxRacers);
        } 
        else 
            return null;
    }
}

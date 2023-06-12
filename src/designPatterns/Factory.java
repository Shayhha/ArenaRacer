/**
 * Partners:
 * name: Shay Hahiashvili, ID: 206423840
 * name: Maxim Subotin, ID: 207695479
 */
package designPatterns;
import game.arenas.Arena;
import game.arenas.air.AerialArena;
import game.arenas.land.LandArena;
import game.arenas.naval.NavalArena;

/**
 * The Factory class that is used to build the arenas in our project.
 * This Factory class is implementing a design pattern called Factory and allows us to build all types
 * of arenas in our project by using the MakeArena method.
 */
public class Factory {
    /**
     * default ctor for Factory class
     */
    public Factory(){}

    /**
     * Method that handles creation of new instance of arena class, based on classed parameters
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

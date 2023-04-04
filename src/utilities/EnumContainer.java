/**
 * Parters:
 * name: Shay Hahiashvili, ID: 206423840
 * name: Maxim Subotin, ID: 207695479
 */
package utilities;

/**
 * Contains all Enums for the game.
 * 
 * To set a field type: EnumContainer.Vision vision; To set a value: this.vision
 * = EnumContainer.Vision.Sunny
 * 
 * @author מקסים סובוטין - 207695479
 * @author שי חחיאשוילי - 206423840
 *
 */
public class EnumContainer {

	// All of the below enums are pretty self explanatory, they keep values that our games supports,
	// we use enums to keep the values cunstant and to map all of the posible options in one place.
	// For example the enum Color represents the colors of the racers and can only have 5 values, our game
	// does not support other colors but the ones defined in the enum.

	public static enum Vision { 
		CLOUDS, SUNNY, FOG
	}

	public static enum Color {
		RED,GREEN,BLUE,BLACK,YELLOW
	}

	public static enum Engine{
		FOURSTROKE, VTYPE, STRAIGHT, BOXER, ROTARY
	}

	public static enum BicycleType{
		MOUNTAIN,HYBRID,CRUISER,ROAD
	}

	public static enum Breed{
		THOROUGHBRED,STANDARDBRED,MORGAN,FRIESIAN
	}

	public static enum BoatType{
		SKULLING,SWEEP
	}

	public static enum Team{
		SINGLE,DOUBLE,QUAD,EIGHT
	}

	public static enum LandSurface{
		FLAT,MOUNTAIN
	}

	public static enum Coverage{
		SAND,GRASS,MUD
	}

	public static enum Body{
		SEA,LAKE,RIVER,OCEAN
	}
	
	public static enum WaterSurface{
		FLAT,WAVY
	}

	public static enum Water{
		SALTED,SWEET
	}

	public static enum Height{
		LOW,MEDIUM,HIGH
	}

	public static enum Wind{
		LOW,MEDIUM,HIGH
	}

	public static enum Weather{
		DRY,RAIN,SNOW
	}

}

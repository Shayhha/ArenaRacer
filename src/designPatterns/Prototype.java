package designPatterns;
import game.racers.Racer;
import game.racers.air.Airplane;
import game.racers.air.Helicopter;
import game.racers.land.Bicycle;
import game.racers.land.Car;
import game.racers.land.Horse;
import game.racers.naval.RowBoat;
import game.racers.naval.SpeedBoat;
import utilities.EnumContainer.Color;
import java.util.Hashtable;

public class Prototype {
   private static Hashtable<String, Racer> racerMap = new Hashtable<String, Racer>();

   /**
    * This function is responsible for creating new clones of racer classes, give them their serial number
    * and their color. The function then return an instance of Racer that is a clone of an existing racer.
    * Note that the parameters that the function does not receive it gets by default from the Racer constructor.
    * @param racerClass the class of the Racer you want to clone, for example "Car" or "Airplane"
    * @param id the serial number of the next racer, use this: Racer.getInstanceCounter()
    * @param color the color of the racer, use the Color class from utilities.EnumContainer.Color
    * @return an instant of Racer based on the passed parameters, all other fields are default
    */
   public static Racer getRacerClone(String racerClass, int id, Color color) { // id is the next serial number
        Racer cachedRacer = racerMap.get(racerClass);
        cachedRacer = (Racer)cachedRacer.clone(); // cloning

        // setting serial number and color to the cloned racer
        cachedRacer.setSerialNumber(id);
        Racer.setInstanceCounter(); // after creating a new racer we increment the serial number by calling setInstanceCounter()
        cachedRacer.setColor(color);
        return cachedRacer; // returning the cloned racer
   }

   // for each shape run database query and create shape
   // shapeMap.put(shapeKey, shape);
   // for example, we are adding three shapes
   public static void loadRacerPrototypes() {
        Airplane airplane = new Airplane();
        racerMap.put(airplane.className(), airplane);
        Racer.resetInstaceCounter();

        Helicopter helicopter = new Helicopter();
        racerMap.put(helicopter.className(), helicopter);
        Racer.resetInstaceCounter();
        
        Bicycle bicycle = new Bicycle();
        racerMap.put(bicycle.className(), bicycle);
        Racer.resetInstaceCounter();

        Car car = new Car();
        racerMap.put(car.className(), car);
        Racer.resetInstaceCounter();

        Horse horse = new Horse();
        racerMap.put(horse.className(), horse);
        Racer.resetInstaceCounter();

        RowBoat rowBoat = new RowBoat();
        racerMap.put(rowBoat.className(), rowBoat);
        Racer.resetInstaceCounter();
        
        SpeedBoat speedBoat = new SpeedBoat();
        racerMap.put(speedBoat.className(), speedBoat);
        Racer.resetInstaceCounter();
   }
}
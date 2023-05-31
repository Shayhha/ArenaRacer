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

   public static Racer getRacerClone(String racerClass, int id, Color color) { // id is not needed, ask sofia
        Racer cachedRacer = racerMap.get(racerClass);
        cachedRacer = (Racer)cachedRacer.clone(); // cloning

        // setting serial number and color to the cloned racer
        cachedRacer.setSerialNumber(Racer.getInstanceCounter());
        Racer.setInstanceCounter();
        cachedRacer.setColor(color);
        return cachedRacer; // returning the cloned racer
   }

   // for each shape run database query and create shape
   // shapeMap.put(shapeKey, shape);
   // for example, we are adding three shapes
   public static void loadRacerPrototypes() {
        Airplane airplane = new Airplane();
        racerMap.put(airplane.className(), airplane);

        Helicopter helicopter = new Helicopter();
        racerMap.put(helicopter.className(), helicopter);

        Bicycle bicycle = new Bicycle();
        racerMap.put(bicycle.className(), bicycle);

        Car car = new Car();
        racerMap.put(car.className(), car);

        Horse horse = new Horse();
        racerMap.put(horse.className(), horse);

        RowBoat rowBoat = new RowBoat();
        racerMap.put(rowBoat.className(), rowBoat);

        SpeedBoat speedBoat = new SpeedBoat();
        racerMap.put(speedBoat.className(), speedBoat);
   }
}
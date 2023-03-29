package factory;
import game.arenas.Arena;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import game.racers.Racer;
import utilities.EnumContainer;

public class RaceBuilder {
    /*
     * builds a new arena and racer instances with given parameters using reflection
     * has singelton template for constructor of class BuildRacer
     * uses to impelemt a race
     */
    
    private static RaceBuilder instance=null;
    private ClassLoader classLoader;
    private Class<?> classObject;
    private Constructor<?> constructor;

    protected RaceBuilder(){} //ctor of class RaceBuilder

    public static RaceBuilder getInstance(){ //singleton template for class RaceBuilder
        if(instance == null){
            instance = new RaceBuilder();
        }
        return instance;
    }

    public Arena buildArena(String arenaType, double length, int maxRacers) 
        throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException
            ,IllegalAccessException, IllegalArgumentException, InvocationTargetException { //creates an area instance
        this.classLoader = ClassLoader.getSystemClassLoader();
        classObject = classLoader.loadClass(arenaType);
        this.constructor = classObject.getConstructor(double.class,int.class); //can throw an exception
        Arena arena = (Arena)constructor.newInstance(length, maxRacers);//calls ctor of arena
        return arena;
    }

    public Racer buildRacer(String racerType, String name, double maxSpeed, double acceleration, utilities.EnumContainer.Color color) 
        throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException
            ,IllegalAccessException, IllegalArgumentException, InvocationTargetException { //creats racer instance
        this.classLoader = ClassLoader.getSystemClassLoader();
        classObject = classLoader.loadClass(racerType);
        this.constructor = classObject.getConstructor(String.class,double.class,double.class,EnumContainer.Color.class);
        Racer racer = (Racer)constructor.newInstance(name,maxSpeed,acceleration,color);
        return racer;
    }

    public Racer buildWheeledRacer(String racerType, String name, double maxSpeed, double acceleration, utilities.EnumContainer.Color color, int numOfWheels) 
        throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException
            ,IllegalAccessException, IllegalArgumentException, InvocationTargetException { //creats wheeled racer instance
        classObject = classLoader.loadClass(racerType);
        this.classLoader = ClassLoader.getSystemClassLoader();
        this.constructor = classObject.getConstructor(String.class,double.class,double.class,EnumContainer.Color.class,int.class);
        Racer racer = (Racer)constructor.newInstance(name,maxSpeed,acceleration,color,numOfWheels);
        return racer;
    }
    
}

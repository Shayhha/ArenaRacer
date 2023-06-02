package factory;
import java.util.Vector;
import game.racers.Racer;

/**
* Observable class
*<p>
* Parameters:
*
* <p>
*@param //observers vector list of observers
*<p>
* Methods:
*<p>
* void addObserver(Observer) - adds Observer to vector array
* void removeObserver(Observer) - remove Observer from vector array
* void notifyObservers(Racer) - notifys all observers, calls update() method 
*/
public class Observable {
    private Vector<Observer> observers = new Vector<>(); //observer list

    /**
     * This function adds an observer to the list of observers on the current observable object
     * @param observer 
     */
    public void addObserver(Observer observer){ 
        this.observers.add(observer); //adds observer to list
    }

    /**
     * This function removes an observer from the list of observers on the current observable object
     * @param observer is the object that needs to be removed from the list, in our case it will be an Arena class
     */
    public synchronized void removeObserver(Observer observer){ //removes observer from list (must be synchronized)
        Vector<Observer> temp = new Vector<>(); //temp vector list
        for (Observer ob : observers) { //deletes the obj from arrayList
            if(ob.equals(observer)==false) //copys all elements except of removed element
                temp.add(ob);
        }
        observers = temp; //gives original list temp's reference
    }

    /**
     * This function notifies each observer in the list of observers on the current observabel object. 
     * This will call the update method defined in each observer, in our case Arena class has the update function.
     * @param obj an observable object that has a list of observers that needs to be notified, in our case a Racer class
     */
    public void notifyObservers(Observable obj){ //calls update() methods for all observers
        for (Observer observer : observers) {
            observer.RacerStateChanged(this);
            if(((Racer)obj).getCurrentLocation().getX() >= ((Racer)obj).getArena().getLength()) //checks if racer finished race, calls update method of arena
                observer.update(obj);
        }
    }

    
    public void setObservers(Vector<Observer> v) {
        observers = v;
    }
}

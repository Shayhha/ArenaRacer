package factory;
import java.util.Vector;
import game.racers.Racer;

/**
* Observable class
*<p>
* Parameters:
*
* <p>
*@param observers vector list of observers
*<p>
* Methods:
*<p>
* void addObserver(Observer) - adds Observer to vector array
* void removeObserver(Observer) - remove Observer from vector array
* void notifyObservers(Racer) - notifys all observers, calls update() method 
*/
public class Observable {
    private Vector<Observer> observers = new Vector<>(); //observer list

    public void addObserver(Observer observer){ //adds observer to list
        this.observers.add(observer);
    }

    public synchronized void removeObserver(Observer observer){ //removes observer from list (must be synchronized)
        Vector<Observer> temp = new Vector<>(); //temp vector list
        for (Observer ob : observers) { //deletes the obj from arrayList
            if(ob.equals(observer)==false) //copys all elements except of removed element
                temp.add(ob);
        }
        observers = temp; //gives original list temp's reference
    }

    public void notifyObservers(Racer racer){ //calls update() methods for all observers
        for (Observer observer : observers) {
            observer.update(racer);
        }
    }
}

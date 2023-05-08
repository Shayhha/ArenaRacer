package factory;
import java.util.Vector;
import game.racers.Racer;

public class Observable {
    private Vector<Observer> observers = new Vector<>();

    public void addObserver(Observer observer){
        this.observers.add(observer);
    }
    public void removeObserver(Observer observer){
        // int index = observers.indexOf(observer);
        // observers.set(index, observers.lastElement());
        // this.observers.remove(observers.size()-1);
        Vector<Observer> temp = new Vector<>();
        for (Observer ob : observers) { //deletes the obj from arrayList
            if(ob.equals(observer)==false)
                temp.add(ob);
        }
        observers = temp;
    }
    public void notifyObservers(Racer racer){
        for (Observer observer : observers) {
            observer.update(racer);
        }
    }
}

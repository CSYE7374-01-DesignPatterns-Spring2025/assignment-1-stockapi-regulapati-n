package edu.neu.csye7374;
import java.util.HashSet;
import java.util.Set;

public abstract class Publisher <K,V> {
    protected Set<Observer<K,V>> observerSet;

    public Publisher() {
        this.observerSet = new HashSet<>();
    }

    public void subscribe(Observer<K,V> observer) {
        observerSet.add(observer);
    }

    public void unSubscribe(Observer<K,V> observer) {
        observerSet.remove(observer);
    }

    public abstract void publishChange(K obj, V value);
}

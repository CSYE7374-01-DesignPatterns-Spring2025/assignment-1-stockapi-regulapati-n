package edu.neu.csye7374;

public interface Observer <K,V> {
    public void notifyChange(K key, V value);
}


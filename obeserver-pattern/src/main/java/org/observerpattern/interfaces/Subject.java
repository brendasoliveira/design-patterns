package org.observerpattern.interfaces;

public interface Subject<T> {
    void registerObserver(Observer<T> observer);
    void unRegisterObserver(Observer<T> observer);
    void notifyObservers(T event);
}

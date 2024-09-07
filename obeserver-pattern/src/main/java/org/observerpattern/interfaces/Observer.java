package org.observerpattern.interfaces;

public interface Observer<T> {
    void observer(T event);
}

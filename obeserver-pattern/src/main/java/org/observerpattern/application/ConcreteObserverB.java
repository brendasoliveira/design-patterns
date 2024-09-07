package org.observerpattern.application;

import org.observerpattern.interfaces.Observer;

public class ConcreteObserverB implements Observer<String> {
    @Override
    public void observer(String event) {
        System.out.println("Observer B: " + event);
    }
}

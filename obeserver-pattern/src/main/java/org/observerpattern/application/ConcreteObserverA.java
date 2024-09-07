package org.observerpattern.application;

import org.observerpattern.interfaces.Observer;

public class ConcreteObserverA implements Observer<String> {
    @Override
    public void observer(String event) {
        System.out.println("Observer A: " + event);
    }
}

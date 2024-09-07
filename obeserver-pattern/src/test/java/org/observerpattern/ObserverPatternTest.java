package org.observerpattern;

import org.junit.Test;
import org.mockito.Mockito;
import org.observerpattern.application.ConcreteObserverA;
import org.observerpattern.application.ConcreteObserverB;
import org.observerpattern.application.ConcreteSubject;
import org.observerpattern.interfaces.Observer;
import org.observerpattern.interfaces.Subject;

public class ObserverPatternTest {

    @Test
    public void observerHandleEventsFromSubject() {
        //given
        Subject<String> subject = new ConcreteSubject();
        Observer<String> observerA = Mockito.spy(new ConcreteObserverA());
        Observer<String> observerB = Mockito.spy(new ConcreteObserverB());

        //when
        subject.notifyObservers("No listeners");

        subject.registerObserver(observerA);
        subject.notifyObservers("Message for A");

        subject.registerObserver(observerB);
        subject.notifyObservers("Message for A & B");

        subject.unRegisterObserver(observerA);
        subject.notifyObservers("Message for B");

        subject.unRegisterObserver(observerB);
        subject.notifyObservers("No listeners");

        //then
        Mockito.verify(observerA, Mockito.times(1)).observer("Message for A");
        Mockito.verify(observerA, Mockito.times(1)).observer("Message for A & B");
        Mockito.verifyNoMoreInteractions(observerA);

        Mockito.verify(observerB, Mockito.times(1)).observer("Message for A & B");
        Mockito.verify(observerB, Mockito.times(1)).observer("Message for B");
        Mockito.verifyNoMoreInteractions(observerB);
    }
}

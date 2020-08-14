package com.peigen.test.dp.observer.my.inf;

import com.peigen.test.dp.observer.my.inf.Observer;

public interface Subject {


    void registerObserver(Observer o);

    void removeObserver(Observer o);

    void notifyObserver();

}

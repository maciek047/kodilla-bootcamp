package com.kodilla.patterns2.observer.homework;

import com.kodilla.patterns2.observer.forum.Observer;

public interface ObservableStudent {
    void registerObserver(HomeworkObserver observer);
    void notifyObservers();
    void removeObserver(HomeworkObserver observer);
}

package com.kodilla.patterns2.observer.homework;

import java.util.ArrayList;
import java.util.List;

public class Student implements ObservableStudent {
    private final String name;
    private final List<HomeworkAssignment> assignments;
    private final List<HomeworkObserver> observers;

    public Student(String name) {
        this.name = name;
        assignments = new ArrayList<>();
        observers = new ArrayList<>();
    }

    public void addAssignment (HomeworkAssignment assignment) {
        assignments.add(assignment);
        notifyObservers();
    }

    @Override
    public void registerObserver(HomeworkObserver observer) {
        observers.add(observer);
    }

    @Override
    public void notifyObservers() {
        for(HomeworkObserver observer : observers) {
            observer.update(this);
        }
    }

    @Override
    public void removeObserver(HomeworkObserver observer) {
        observers.remove(observer);
    }

    public String getName() {
        return name;
    }

    public List<HomeworkAssignment> getAssignments() {
        return assignments;
    }
}

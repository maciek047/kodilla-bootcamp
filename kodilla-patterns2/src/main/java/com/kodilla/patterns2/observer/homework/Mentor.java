package com.kodilla.patterns2.observer.homework;

public class Mentor implements HomeworkObserver {
    private final String name;
    private int updateCount;

    public Mentor(String name) {
        this.name = name;
    }

    @Override
    public void update(Student student) {
        System.out.println(name + ": New tasks submitted by " + student.    getName() + "\n" +
                " (total: " + student.getAssignments().size() + " assignments to check.)");
        updateCount++;
    }

    public String getName() {
        return name;
    }

    public int getUpdateCount() {
        return updateCount;
    }
}

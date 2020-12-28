package com.kodilla.patterns.factory.tasks;

public class TaskFactory {
    public static final String DRIVING = "DRIVING";
    public static final String PAINTING = "PAINTING";
    public static final String SHOPPING = "SHOPPING";

    public final Task assignTask(final String taskClass) {
        switch (taskClass) {
            case DRIVING:
                return new DrivingTask("The driving task ","Berlin","truck");
            case PAINTING:
                return new PaintingTask("The painting task ","blue","whale");
            case SHOPPING:
                return new ShoppingTask("The shopping task ","video game",9);
            default:
                return null;
        }
    }
}

package com.kodilla.patterns.factory.tasks;

public class DrivingTask implements Task {
    final String taskName;
    final String where;
    final String using;
    private Boolean isExecuted;

    public DrivingTask(String taskName, String where, String using) {
        this.taskName = taskName;
        this.where = where;
        this.using = using;
        this.isExecuted = false;
    }

    public void executeTask(){
        System.out.println("Executing task: " +this.taskName);
        this.isExecuted = true;
    }

    @Override
    public String getTaskName() {
        return this.taskName;
    }

    public Boolean isTaskExecuted() {
        return this.isExecuted;
    }
}

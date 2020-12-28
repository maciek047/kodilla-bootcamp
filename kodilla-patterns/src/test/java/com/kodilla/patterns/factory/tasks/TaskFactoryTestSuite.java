package com.kodilla.patterns.factory.tasks;

import org.junit.Assert;
import org.junit.Test;

public class TaskFactoryTestSuite {
    @Test
    public void testDrivingTask() {
        //Given
        TaskFactory factory = new TaskFactory();
        //When
        Task driving = factory.assignTask(TaskFactory.DRIVING);
        driving.executeTask();
        //Then
        Assert.assertTrue(driving.isTaskExecuted());
        Assert.assertEquals("The driving task ", driving.getTaskName());
    }

    @Test
    public void testPaintingTask() {
        //Given
        TaskFactory factory = new TaskFactory();
        //When
        Task painting = factory.assignTask(TaskFactory.PAINTING);
        painting.executeTask();
        //Then
        Assert.assertTrue(painting.isTaskExecuted());
        Assert.assertEquals("The painting task ", painting.getTaskName());
    }

    @Test
    public void testShoppingTask() {
        //Given
        TaskFactory factory = new TaskFactory();
        //When
        Task shopping = factory.assignTask(TaskFactory.SHOPPING);
        shopping.executeTask();
        //Then
        Assert.assertTrue(shopping.isTaskExecuted());
        Assert.assertEquals("The shopping task ", shopping.getTaskName());
    }
}
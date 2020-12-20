package com.kodilla.spring.portfolio;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BoardTestSuite {
    @Test
    public void testTaskAdd() {
        //Given
        ApplicationContext context = new AnnotationConfigApplicationContext(BoardConfig.class);
        Board board = context.getBean(Board.class);
        //When
        board.toDoList.addTask("task to do");
        board.doneList.addTask("task done");
        board.inProgressList.addTask("task in progress");
        //Then
        Assert.assertEquals(board.toDoList.tasks.get(0),"task to do");
        Assert.assertEquals(board.doneList.tasks.get(0),"task done");
        Assert.assertEquals(board.inProgressList.tasks.get(0),"task in progress");
    }
}

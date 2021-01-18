package com.kodilla.hibernate.tasklist.dao;

import com.kodilla.hibernate.task.dao.TaskDao;
import com.kodilla.hibernate.tasklist.TaskList;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TaskListDaoTestSuite {
    @Autowired
    private TaskListDao taskListDao;
    private static final String LISTNAME = "first taskList";
    private static final String DESCRIPTION = "My Tested Description 17.2";

    @Test
    public void testTaskDaoFindByDuration() {
        //Given
        TaskList taskList = new TaskList(LISTNAME, DESCRIPTION);
        taskListDao.save(taskList);

        //When
        List<TaskList> readTaskLists = taskListDao.findByListName(LISTNAME);

        //Then
        Assert.assertEquals(1, readTaskLists.size());

        //CleanUp
        int id = readTaskLists.get(0).getId();
            taskListDao.deleteById(id);
        }
}

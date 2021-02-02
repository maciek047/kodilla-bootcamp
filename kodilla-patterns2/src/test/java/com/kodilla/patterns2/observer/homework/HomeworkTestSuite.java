package com.kodilla.patterns2.observer.homework;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class HomeworkTestSuite {
    @Test
    public void testHomeworkAssignments() {
        //Given
        Student johnnySilverhand = new Student("Johnny Silverhand");
        Student tonyMontana = new Student("Tony Montana");
        Student vincentVega = new Student("Vincent Vega");

        Mentor elonMusk = new Mentor("Elon Musk");
        Mentor rickSanchez = new Mentor("Rick Sanchez");

        johnnySilverhand.registerObserver(elonMusk);
        tonyMontana.registerObserver(rickSanchez);
        vincentVega.registerObserver(elonMusk);
        vincentVega.registerObserver(rickSanchez);
        //When
        johnnySilverhand.addAssignment(new HomeworkAssignment("21.4","spring intro"));
        johnnySilverhand.addAssignment(new HomeworkAssignment("22.3","hibernate"));

        tonyMontana.addAssignment(new HomeworkAssignment("2.9", "hashmap"));
        tonyMontana.addAssignment(new HomeworkAssignment("3.1", "fifo queues"));
        tonyMontana.addAssignment(new HomeworkAssignment("3.2", "lifo queues"));

        vincentVega.addAssignment(new HomeworkAssignment("8.3","stream assignment"));
        //Then
        assertEquals(3, elonMusk.getUpdateCount());
        assertEquals(4, rickSanchez.getUpdateCount());
    }
}

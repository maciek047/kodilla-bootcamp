package com.kodilla.stream.array;
import org.junit.Assert;
import org.junit.Test;
import static com.kodilla.stream.array.ArrayOperations.getAverage;

public class ArrayOperationsTestSuite {
    @Test
    public void testGetAverage() {
        //Given
        int[] myArray = {1, 2, 5, 8, 11, 15, 17, 20};
        //When
        double result = getAverage(myArray);
        //Then
        Assert.assertEquals(result,9.875,0.001);
    }
    @Test
    public void emptyArray() {
        //Given
        int[] myArray ={};
        //When
        double result = getAverage(myArray);
        //Then
        Assert.assertEquals(result,-1,0.001);
    }
}

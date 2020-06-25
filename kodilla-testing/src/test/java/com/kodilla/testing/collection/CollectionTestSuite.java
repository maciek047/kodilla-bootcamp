package com.kodilla.testing.collection;
import org.junit.*;
import java.util.ArrayList;

public class CollectionTestSuite {
    @Before
    public void before(){
        System.out.println("Test Case: begin");
    }
    @After
    public void after(){
        System.out.println("Test Case: end");
    }
    @BeforeClass
    public static void beforeClass() {
        System.out.println("Test Suite: begin");
    }
    @AfterClass
    public static void afterClass() {
        System.out.println("Test Suite: end");
    }
    @Test
    public void testOddNumbersExterminatorEmptyList(){
        //Given
        ArrayList<Integer> emptyList = new ArrayList<Integer>();
        OddNumbersExterminator emptyTest = new OddNumbersExterminator();
        System.out.println("Input data: " + emptyList);
        //When
        ArrayList<Integer> result = emptyTest.exterminate(emptyList);
        System.out.println("Testing " + result);
        //Then
        Assert.assertEquals(0, result.size());
    }
    @Test
    public void testOddNumbersExterminatorNormalList (){
        //Given
        ArrayList<Integer> normalList = new ArrayList<Integer>();
        normalList.add(1);
        normalList.add(3);
        normalList.add(5);
        normalList.add(7);
        normalList.add(8);
        normalList.add(9);
        OddNumbersExterminator normalTest = new OddNumbersExterminator();
        System.out.println("Input data: " + normalList);
        //When
        ArrayList<Integer> result = normalTest.exterminate(normalList);
        System.out.println("Testing " + result);
        //Then
        Assert.assertTrue((1 == result.size())&& (result.get(0) == 8));
    }
}

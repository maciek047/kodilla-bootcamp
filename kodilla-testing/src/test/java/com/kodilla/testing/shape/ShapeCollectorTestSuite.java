package com.kodilla.testing.shape;
import org.junit.*;

public class ShapeCollectorTestSuite {
    private static int testCounter = 0;

    @BeforeClass
    public static void beforeAllTests() {
        System.out.println("This is the beginning of tests.");
    }

    @AfterClass
    public static void afterAllTests() {
        System.out.println("All tests are finished.");
    }

    @Before
    public void beforeEveryTest() {
        testCounter++;
        System.out.println("Preparing to execute test #" + testCounter);
    }


    @Test
    public void testAddFigure() {
        //Given
        ShapeCollector collector = new ShapeCollector();
        Square square = new Square(2);
        //When
        boolean result = collector.addFigure((Shape) square);
        //Then
        Assert.assertTrue(result);
        Assert.assertTrue(collector.getFiguresQuantity()==1);
    }

    @Test
    public void testRemoveFigure() {
        //Given
        ShapeCollector collector = new ShapeCollector();
        Circle circle = new Circle(2);
        collector.addFigure((Shape) circle);
        //When
        boolean result = collector.removeFigure((Shape) circle);
        //Then
        Assert.assertTrue(result);
        Assert.assertTrue(collector.getFiguresQuantity()==0);
    }

    @Test
    public void testGetFigure() {
        //Given
        ShapeCollector collector = new ShapeCollector();
        Triangle triangle = new Triangle(2,1.5);
        collector.addFigure((Shape) triangle);
        //When
        Shape shape = collector.getFigure(0);
        //Then
        Assert.assertTrue(shape!=null);
        Assert.assertEquals(shape, triangle);
    }

    @Test
    public void testShowFigures() {
        //Given
        ShapeCollector collector = new ShapeCollector();
        Triangle triangle = new Triangle(2,1.5);
        Square square = new Square(2);
        Circle circle = new Circle(2);
        collector.addFigure((Shape) triangle);
        collector.addFigure((Shape) square);
        collector.addFigure((Shape) circle);
        //When
        boolean result = collector.showFigures();
        //Then
        Assert.assertTrue(result);
    }

    @Test
    public void testFieldCalculation() {
        //Given
        Triangle triangle = new Triangle(2,1.5);
        Square square = new Square(2);
        Circle circle = new Circle(2);
        //When
        boolean result = (triangle.getField()==1.5 && square.getField()==4.0 && circle.getField()==12.56);
        //Then
        Assert.assertTrue(result);
    }
}

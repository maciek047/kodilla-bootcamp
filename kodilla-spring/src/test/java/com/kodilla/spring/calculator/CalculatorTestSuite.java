package com.kodilla.spring.calculator;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CalculatorTestSuite {
    @Test
    public void testCalculations() {
        //Given
        ApplicationContext context =
                new AnnotationConfigApplicationContext("com.kodilla.spring");
        Calculator calculator = context.getBean(Calculator.class);
        //When
        double addition = calculator.add(2,2);
        double subtraction = calculator.sub(8,2);
        double multiplication = calculator.mul(4,2);
        double division = calculator.div(20,2);
        //Then
        Assert.assertEquals(addition,4,0.1);
        Assert.assertEquals(subtraction,6,0.1);
        Assert.assertEquals(multiplication,8,0.1);
        Assert.assertEquals(division,10,0.1);
    }
}
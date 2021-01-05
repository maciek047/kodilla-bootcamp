package com.kodilla.patterns.builder.bigmac;

import com.kodilla.patterns.builder.pizza.Pizza;
import org.junit.Assert;
import org.junit.Test;

public class BigmacTestSuite {
    @Test
    public void testBigmacNew() {
        //Given
        BigMac bigMac = new BigMac.BigmacBuilder()
                .bun("sesame")
                .sauce("ketchup+mayo")
                .burgers(2)
                .ingredient(BigMac.BigmacBuilder.CHILLI)
                .ingredient(BigMac.BigmacBuilder.CHEESE)
                .ingredient(BigMac.BigmacBuilder.BACON)
                .build();
        System.out.println(bigMac);
        //When
        int howManyIngredients = bigMac.getIngredients().size();
        //Then
        Assert.assertEquals(3, howManyIngredients);
    }
}

package com.kodilla.stream.world;
import org.junit.Assert;
import org.junit.Test;
import java.math.BigDecimal;

public class WorldTestSuite {
    @Test
    public void testGetPeopleQuantity() {
        //Given
        Continent continent1 = new Continent("Europe");
        Continent continent2 = new Continent("Asia");
        Continent continent3 = new Continent("America");

        continent1.addCountry(new Country("Poland","39234365"));
        continent1.addCountry(new Country("France","77345987"));
        continent1.addCountry(new Country("United Kingdom","84234678"));

        continent2.addCountry(new Country("China","1024483954"));
        continent2.addCountry(new Country("Japan","54847093"));

        continent3.addCountry(new Country("USA","150362949"));
        continent3.addCountry(new Country("Canada","13958039"));
        continent3.addCountry(new Country("Mexico","24094827"));

        World Earth = new World("Earth");
        Earth.addContinent(continent1);
        Earth.addContinent(continent2);
        Earth.addContinent(continent3);

        //When
        BigDecimal totalPeople = Earth.getPeopleQuantity();

        //Then
        BigDecimal expectedPeople = new BigDecimal("1468561892");
        Assert.assertEquals(expectedPeople, totalPeople);
    }
}

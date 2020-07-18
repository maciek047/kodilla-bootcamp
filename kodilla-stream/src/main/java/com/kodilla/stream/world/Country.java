package com.kodilla.stream.world;

import java.math.BigDecimal;

public class Country {
    final private String countryName;
    final private BigDecimal countryPeopleQuantity;

    public Country(final String name, final String quantity) {
        this.countryName = name;
        this.countryPeopleQuantity = new BigDecimal(quantity);
    }

    public BigDecimal getPeopleQuantity(){
        return countryPeopleQuantity;
    }

    public String getCountryName() {
        return countryName;
    }

    @Override
    public String toString() {
        return "Country{" +
                "countryName='" + countryName + '\'' +
                ", countryPeopleQuantity=" + countryPeopleQuantity +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Country)) return false;

        Country country = (Country) o;

        if (getCountryName() != null ? !getCountryName().equals(country.getCountryName()) : country.getCountryName() != null)
            return false;
        return countryPeopleQuantity != null ? countryPeopleQuantity.equals(country.countryPeopleQuantity) : country.countryPeopleQuantity == null;
    }

    @Override
    public int hashCode() {
        int result = getCountryName() != null ? getCountryName().hashCode() : 0;
        result = 31 * result + (countryPeopleQuantity != null ? countryPeopleQuantity.hashCode() : 0);
        return result;
    }
}

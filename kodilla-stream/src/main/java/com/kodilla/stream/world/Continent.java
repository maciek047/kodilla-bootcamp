package com.kodilla.stream.world;

import java.util.HashSet;
import java.util.Set;

public class Continent {
    final private String continentName;
    final private Set<Country> continentCountries;

    public Continent(final String continentName) {
        this.continentName = continentName;
        this.continentCountries = new HashSet<Country>();
    }

    public void addCountry(Country country){
        continentCountries.add(country);
    }

    public String getCountryName() {
        return continentName;
    }

    public Set<Country> getContinentCountries() {
        return continentCountries;
    }

    @Override
    public String toString() {
        return "Continent{" +
                "countryName='" + continentName + '\'' +
                ", continentCountries=" + continentCountries +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Continent)) return false;

        Continent continent = (Continent) o;

        if (continentName != null ? !continentName.equals(continent.continentName) : continent.continentName != null)
            return false;
        return continentCountries != null ? continentCountries.equals(continent.continentCountries) : continent.continentCountries == null;
    }

    @Override
    public int hashCode() {
        int result = continentName != null ? continentName.hashCode() : 0;
        result = 31 * result + (continentCountries != null ? continentCountries.hashCode() : 0);
        return result;
    }
}

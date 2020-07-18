package com.kodilla.stream.world;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

public class World {
    final private String worldName;
    final private Set<Continent> worldContinents;

    public World(final String worldName) {
        this.worldName = worldName;
        this.worldContinents = new HashSet<Continent>();
    }

    public BigDecimal getPeopleQuantity(){
        BigDecimal result = this.worldContinents.stream()
                .flatMap(continent -> continent.getContinentCountries().stream())
                .map(Country::getPeopleQuantity)
                .reduce(BigDecimal.ZERO,(sum, current) -> sum = sum.add(current));
        return result;
    }

    public void addContinent(Continent continent){
        worldContinents.add(continent);
    }

    public String getWorldName() {
        return worldName;
    }

    public Set<Continent> getWorldContinents() {
        return worldContinents;
    }

}

package com.kodilla.patterns.builder.bigmac;

import java.util.ArrayList;
import java.util.List;

public final class BigMac {
    private final String bun;
    private final String sauce;
    private final int burgers;
    private final List<String> ingredients;

    public static class BigmacBuilder {
        private String bun;
        private String sauce;
        private int burgers;
        private List<String> ingredients = new ArrayList<>();

        public static final String LETTUCE = "LETTUCE";
        public static final String ONION = "ONION";
        public static final String BACON = "BACON";
        public static final String CHILLI = "CHILLI";
        public static final String MUSHROOMS = "MUSHROOMS";
        public static final String SHRIMPS = "SHRIMPS";
        public static final String CHEESE = "CHEESE";

        public BigmacBuilder bun(String bun) {
            this.bun = bun;
            return this;
        }

        public BigmacBuilder sauce(String sauce) {
            this.sauce = sauce;
            return this;
        }

        public BigmacBuilder burgers(int burgers) {
            this.burgers = burgers;
            return this;
        }

        public BigmacBuilder ingredient(String i) {
            if (i==LETTUCE||i==ONION||i==BACON||i==CHILLI||i==MUSHROOMS||i==SHRIMPS||i==CHEESE) {
                ingredients.add(i);
            } else {
                throw new IllegalStateException("Specified ingredient is not available: " + i);
            }
            return this;
        }

        public BigMac build() {
            if (bun.length() == 0) {
                throw new IllegalStateException("There is no bun specified!");
            }
            if (sauce.length() == 0) {
                throw new IllegalStateException("There is no sauce specified!");
            }
            if (burgers < 1 || burgers > 4){
                throw new IllegalStateException("Wrong number of burgers, must be within range 1 - 4");
            }
            return new BigMac(bun, sauce, burgers, ingredients);
        }
    }

    private BigMac(final String bun, final String sauce, int burgers, List<String> ingredients) {
        this.bun = bun;
        this.sauce = sauce;
        this.burgers = burgers;
        this.ingredients = new ArrayList<>(ingredients);
    }

    public String getBun() {
        return bun;
    }

    public String getSauce() {
        return sauce;
    }

    public int getBurgers() {
        return burgers;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    @Override
    public String toString() {
        return "BigMac{" +
                "bun='" + bun + '\'' +
                ", sauce='" + sauce + '\'' +
                ", no. of burgers='" + burgers + '\'' +
                ", ingredients=" + ingredients +
                '}';
    }
}
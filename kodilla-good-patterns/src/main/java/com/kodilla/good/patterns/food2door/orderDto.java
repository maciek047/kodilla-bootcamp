package com.kodilla.good.patterns.food2door;

public class orderDto {

    private boolean result;
    private double amount;

    public orderDto(boolean result, double amount) {
        this.result = result;
        this.amount = amount;
    }

    public boolean getResult() { return result; }
    public double getAmount() {
        return amount;
    }
}

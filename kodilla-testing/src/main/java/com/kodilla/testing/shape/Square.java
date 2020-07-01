package com.kodilla.testing.shape;

public class Square implements Shape{
    private double sideLength;

    public Square(double sideLength) {
        this.sideLength = sideLength;
    }

    public String getShapeName(){
        return "Square";
    }

    public double getField(){
        return this.sideLength*this.sideLength;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Square)) return false;

        Square square = (Square) o;

        return Double.compare(square.sideLength, sideLength) == 0;
    }

    @Override
    public int hashCode() {
        long temp = Double.doubleToLongBits(sideLength);
        return (int) (temp ^ (temp >>> 32));
    }

    @Override
    public String toString() {
        return "Square{" +
                "sideLength=" + sideLength +
                '}';
    }
}

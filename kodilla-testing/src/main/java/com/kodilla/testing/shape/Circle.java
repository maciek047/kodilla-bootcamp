package com.kodilla.testing.shape;

public class Circle implements Shape{
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public String getShapeName(){
        return "Circle";
    }

    public double getField(){
        return 3.14*this.radius*this.radius;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Circle)) return false;

        Circle circle = (Circle) o;

        return Double.compare(circle.radius, radius) == 0;
    }

    @Override
    public int hashCode() {
        long temp = Double.doubleToLongBits(radius);
        return (int) (temp ^ (temp >>> 32));
    }

    @Override
    public String toString() {
        return "Circle{" +
                "radius=" + radius +
                '}';
    }
}

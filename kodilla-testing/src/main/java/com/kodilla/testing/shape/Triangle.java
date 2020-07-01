package com.kodilla.testing.shape;

public class Triangle implements Shape{
    private double height;
    private double basis;

    public Triangle(double height, double basis) {
        this.height = height;
        this.basis = basis;
    }

    public String getShapeName(){
        return "Triangle";
    }

    public double getField(){
        return 0.5*this.height*this.basis;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Triangle)) return false;

        Triangle triangle = (Triangle) o;

        if (Double.compare(triangle.height, height) != 0) return false;
        return Double.compare(triangle.basis, basis) == 0;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(height);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(basis);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "height=" + height +
                ", basis=" + basis +
                '}';
    }
}

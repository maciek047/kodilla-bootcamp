package com.kodilla.spring.intro.shape;

public class Drawer {
    final Shape shape;

    public Drawer(final Shape shape) {
        this.shape = shape;
    }
//Dependency Injection - DI lub inaczej inwersja kontroli (ang. Inversion of Control)
    public String doDrawing() {
        return shape.draw();
    }
}
package com.kodilla.spring.intro.shape;

public class Triangle implements Shape {
    @Override
    public String draw() {
        System.out.println("This is a triangle");
        return "This is a triangle";
    }
}
//POJO, czyli Plain Old Java Object (pol. zwykły, stary obiekt Javy).
//wzorzec Bean:
//    bezparametrowy konstruktor
//    zestaw getterów
//    zestaw setterów

//    Bean to dowolny obiekt, którego cyklem życia
//    (tworzeniem, wstrzykiwaniem zależności, wstrzykiwaniem jego jako zależność itd.)
//    zarządza framework bazujący na Dependency Injection, w szczególności framework Spring.
//
//    Czyli mówiąc prosto - jeżeli Spring utworzy obiekt w oparciu o nasze klasy, to przez sam ten fakt staje się on Beanem :)

/*
* Programy napisane z użyciem Spring dzielą się więc na dwie części
* - 1) zestaw obiektów w Kontenerze oraz 2) Twoje lokalne obiekty, które czasem będziesz tworzył poza Kontenerem
*   -te nie będą widoczne dla Springa. Oprócz tego oczywiście klasy, czyli definicje obiektów (Twoich lokalnych, jak i Beanów).
*
* */
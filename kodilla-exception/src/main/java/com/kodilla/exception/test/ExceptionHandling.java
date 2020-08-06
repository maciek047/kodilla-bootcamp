package com.kodilla.exception.test;

public class ExceptionHandling {
    public static void main(String[] args) {
        SecondChallenge secondChallenge = new SecondChallenge();
        try {
            secondChallenge.probablyIWillThrowException(0.5,1.7);
        } catch (Exception e) {
            System.out.println("Second challenge threw an exception!");
        }
    }
}

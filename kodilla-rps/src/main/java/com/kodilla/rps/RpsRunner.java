package com.kodilla.rps;

import java.util.Scanner;

public class RpsRunner {
    public static void main(String[] args) {
        System.out.println("Welcome to Rock-Paper-Scissors!\n***");
        System.out.println("Please type your name: ");
        String username = "";


        boolean correctUsername = false;
        while(!correctUsername){
            username = new Scanner(System.in).next();
            if (username.trim() != ""){
                correctUsername = true;
            }else{
                System.out.println("The name cannot be empty");
            }
        }

        System.out.println("Specify number of rounds: ");
        int rounds = 0;
        boolean correctRoundsNo = false;
        while(!correctRoundsNo){
            rounds = new Scanner(System.in).nextInt();
            if (rounds > 0){
                correctRoundsNo = true;
            }else{
                System.out.println("Number of rounds has to be higher than zero!");
            }
        }

        System.out.println("Your name: " + username + ". Rounds to be played: " + rounds + "...");
        System.out.println("'1' - STONE'");
        System.out.println("'2' - PAPER '");
        System.out.println("'3' - SCISSORS'");
        System.out.println("'x' - EXIT GAME'");
        System.out.println("'n' - NEW GAME'");

        boolean end = false;
        while(!end){
            System.out.println("Your move...");
            String command = new Scanner(System.in).next();
            //while to check if command is correct

            // objectify! -- GAME object & subobjects {later}


        }

    }
}


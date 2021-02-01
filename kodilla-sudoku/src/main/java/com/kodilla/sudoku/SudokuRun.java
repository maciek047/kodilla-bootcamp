package com.kodilla.sudoku;

import java.util.Scanner;

public class SudokuRun {
    public static void main(String[] args) throws Exception {
        boolean continuePlay = true;
        SudokuGame newGame = new SudokuGame.SudokuBoardBuilder().build();
        System.out.println(newGame.getSudokuBoard());
        while(continuePlay) {


            newGame.start();

//       TEST INPUT
//            newGame.userInput(0, 0, 6);
//            newGame.userInput(0, 1, 2);
//            newGame.userInput(1, 0, 3);
//            newGame.userInput(1, 1, 7);
//            newGame.userInput(2, 1, 5);
//            newGame.userInput(1, 2, 4);
//
//            newGame.userInput(3, 1, 1);
//            newGame.userInput(4, 2, 6);
//
//            newGame.userInput(8, 0, 7);
//            newGame.userInput(8, 1, 9);
//            newGame.userInput(8, 2, 1);
//            newGame.userInput(7, 2, 3);
//
//            newGame.userInput(8, 4, 8);
//            newGame.userInput(7, 5, 5);
//
//            newGame.userInput(7, 6, 6);
//            newGame.userInput(7, 7, 7);
//            newGame.userInput(7, 8, 8);
//            newGame.userInput(8, 6, 2);
//
//            newGame.userInput(3, 3, 7);
//            newGame.userInput(4, 3, 1);
//            newGame.userInput(4, 4, 3);
//            newGame.userInput(5, 4, 9);
//            newGame.userInput(3, 5, 4);
//
//            newGame.userInput(0, 5, 1);
//            newGame.userInput(1, 4, 5);
//            newGame.userInput(1, 5, 6);
//            newGame.userInput(2, 4, 4);
//
//            newGame.userInput(0, 6, 3);
//            newGame.userInput(0, 7, 5);
//            newGame.userInput(2, 8, 2);

            ProgressBarRotating pb1 = new ProgressBarRotating();
            pb1.start();
            boolean result = newGame.resolveSudoku();
            System.out.println("\n");
            pb1.showProgress = false;
            System.out.println(newGame.getSudokuBoard());
            if (result) {
                System.out.println("Sudoku solved!");
            } else {
                System.out.println("SUDOKU not solvable...");
            }
            System.out.println("Type SUDOKU if you want to try again, type any key and ENTER to quit...");
            Scanner userInput = new Scanner(System.in);
            String input = userInput.nextLine();
            if(input.toLowerCase().contains("sudoku")){
                continuePlay = true;
            } else {
                continuePlay = false;
            }
        }
    }
}

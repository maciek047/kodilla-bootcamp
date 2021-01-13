package com.kodilla.sudoku;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class SudokuGame {

    private boolean gameFinished;
    private SudokuBoard sudokuBoard;
    private final List<Backtrack> backtrack;

    private SudokuGame(SudokuBoard sudokuBoard) {
        this.sudokuBoard = sudokuBoard;
        this.gameFinished = false;
        this.backtrack = new ArrayList<>();
    }

    public SudokuBoard getSudokuBoard() {
        return sudokuBoard;
    }

    public void setSudokuBoard(SudokuBoard sudokuBoard) {
        this.sudokuBoard = sudokuBoard;
    }

    public static class SudokuBoardBuilder {

        public SudokuGame build() {
            SudokuBoard board = new SudokuBoard();
            for(int i = 0; i<9; i++){
                SudokuRow tempRow = new SudokuRow();
                for(int j = 0; j<9; j++){
                    tempRow.addElement(new SudokuElement());
                }
                board.addRow(tempRow);
            }
            return new SudokuGame(board);
        }
    }

    public boolean userInput(int x, int y, int v) {
        if(v >= 0 && v <= 9){
            this.sudokuBoard.getRowsList().get(x).getElementsList().get(y).setValue(v);
        } else {
            return false;
        }
        return true;
    }

    public void start(){
        System.out.println("Starting new sudoku...");
        System.out.println("Please enter row number, column number and value (1-9) split by comma [,]:");
        System.out.println("Example: 1,4,0");
        boolean inputNext = true;
        boolean inputValid;

        while(inputNext){
            Scanner myObj = new Scanner(System.in);
            inputValid = false;
            String input = myObj.nextLine();
            if (input.toUpperCase().contains("SUDOKU")){
                return;
            }
            try {
                String[] tempInput = input.split(",");
                if(tempInput.length!=3){
                    System.out.println("You must enter 3 values (row, column, value)");
                } else {
                    for(int i = 0; i<3; i++){
                        if(!isNumeric(tempInput[i])){
                            System.out.println("You must enter 3 numerical values split by comma [,]");
                        } else {
                            inputValid = true;
                        }
                    }
                }

                if(inputValid){
                    boolean result = userInput(Integer.parseInt(tempInput[0])-1,Integer.parseInt(tempInput[1])-1, Integer.parseInt(tempInput[2]));
                    if(result){System.out.println(getSudokuBoard());}
                }

            } catch (Exception e) {
                System.out.println("You must enter 3 numerical values split by comma [,]");
                System.out.println("Values must be within 1-9 range");
                System.out.println("wrong input: " +e);
            }
                System.out.println("Enter another value or type SUDOKU to continue");
        }
    }

    public boolean resolveSudoku () throws Exception {
        int tempRowOffset;
        int tempColOffset;
        ArrayList<Integer> tempPossibleValues;
        boolean possibleDigitFound;
        boolean existingDigitFound;
        boolean operationPerformed;

        while (!gameFinished){

            gameFinished = true;
            operationPerformed = false;

            try {
                for (int i = 0; i < 9; i++) {
                    for (int j = 0; j < 9; j++) {

                        int tempValue = getSudokuBoard().getRowsList().get(i).getElementsList().get(j).getValue();
                        tempPossibleValues = (ArrayList<Integer>) getSudokuBoard().getRowsList().get(i).getElementsList().get(j).getPossibleValues().clone();

                        if (tempValue == -1) {
                            gameFinished = false;
                            if (i > 5) {
                                tempRowOffset = 6;
                            } else if (i > 2) {
                                tempRowOffset = 3;
                            } else {
                                tempRowOffset = 0;
                            }

                            if (j > 5) {
                                tempColOffset = 6;
                            } else if (j > 2) {
                                tempColOffset = 3;
                            } else {
                                tempColOffset = 0;
                            }

                            for (int tValue : tempPossibleValues) {
                                existingDigitFound = false;
                                possibleDigitFound = false;

                                for (int k = 0; k < 9; k++) {
                                    if (tValue == getSudokuBoard().getRowsList().get(i).getElementsList().get(k).getValue()) {
                                        existingDigitFound = true;
                                    }
                                    if (k != j) {
                                        for (int potentialValue : getSudokuBoard().getRowsList().get(i).getElementsList().get(k).getPossibleValues()) {
                                            if (tValue == potentialValue) {
                                                possibleDigitFound = true;
                                                break;
                                            }
                                        }
                                    }

                                    if (tValue == getSudokuBoard().getRowsList().get(k).getElementsList().get(j).getValue()) {
                                        existingDigitFound = true;
                                    }
                                    if (k != i) {
                                        for (int potentialValue : getSudokuBoard().getRowsList().get(k).getElementsList().get(j).getPossibleValues()) {
                                            if (tValue == potentialValue) {
                                                possibleDigitFound = true;
                                                break;
                                            }
                                        }
                                    }
                                }

                                for (int m = tempRowOffset; m < (tempRowOffset + 3); m++) {
                                    for (int n = tempColOffset; n < (tempColOffset + 3); n++) {
                                        if (tValue == getSudokuBoard().getRowsList().get(m).getElementsList().get(n).getValue()) {
                                            existingDigitFound = true;
                                        }
                                        if(!(m==i && n==j)) {
                                            for (int potentialValue : getSudokuBoard().getRowsList().get(m).getElementsList().get(n).getPossibleValues()) {
                                                if (tValue == potentialValue) {
                                                    possibleDigitFound = true;
                                                    break;
                                                }
                                            }
                                        }
                                    }
                                }

                                if (!existingDigitFound && !possibleDigitFound) {
                                    getSudokuBoard().getRowsList().get(i).getElementsList().get(j).setValue(tValue);
                                    operationPerformed = true;
                                    break;
                                }

                                if (existingDigitFound) {
                                    getSudokuBoard().getRowsList().get(i).getElementsList().get(j).getPossibleValues().remove(Integer.valueOf(tValue));
                                    operationPerformed = true;
                                }

                                if (getSudokuBoard().getRowsList().get(i).getElementsList().get(j).getPossibleValues().size() == 1 && !existingDigitFound) {
                                    getSudokuBoard().getRowsList().get(i).getElementsList().get(j).setValue(tValue);
                                    operationPerformed = true;
                                    break;
                                } else if (getSudokuBoard().getRowsList().get(i).getElementsList().get(j).getPossibleValues().size() == 1 && existingDigitFound) {
                                    if(!operationPerformed) {
                                        throw new Exception("Sudoku not solvable!");
                                    }
                                }
                            }
                        }
                    }
                }

                if(gameFinished){
                    return true;
                }

                if(!operationPerformed){
                    Random rnd = new Random();
                    int rndRow;
                    int rndCol;
                    int rndValue;
                    int tempPossibleValuesSize;
                    Integer[][] emptyElements = new Integer[81][2];
                    int loopCounter1 = 0;
                    for(int i = 0; i<9;i++){
                        for(int j = 0; j<9; j++){
                            if(getSudokuBoard().getRowsList().get(i).getElementsList().get(j).getValue()==-1
                                    && getSudokuBoard().getRowsList().get(i).getElementsList().get(j).getPossibleValues().size()>1 ){
                                emptyElements[loopCounter1][0] = i;
                                emptyElements[loopCounter1][1] = j;
                                loopCounter1++;
                            }
                        }
                    }

                    if(loopCounter1>0){
                        rndValue = rnd.nextInt(loopCounter1);
                        rndRow = emptyElements[rndValue][0];
                        rndCol = emptyElements[rndValue][1];

                        tempPossibleValuesSize = getSudokuBoard().getRowsList().get(rndRow).getElementsList().get(rndCol).getPossibleValues().size();
                        rndValue = getSudokuBoard().getRowsList().get(rndRow).getElementsList().get(rndCol).getPossibleValues().get(rnd.nextInt(tempPossibleValuesSize));

                        this.backtrack.add(new Backtrack(getSudokuBoard().deepCopy(),rndValue,rndRow,rndCol));
                        getSudokuBoard().getRowsList().get(rndRow).getElementsList().get(rndCol).setValue(rndValue);
                    } else {
                        throw new Exception("Sudoku not solvable!");
                    }
                }
            } catch (Exception e) {
                if(backtrack.size()!=0) {
                    int xPosition = backtrack.get(backtrack.size()-1).getGuessCoordinates()[0];
                    int yPosition = backtrack.get(backtrack.size()-1).getGuessCoordinates()[1];
                    int guessedValue = backtrack.get(backtrack.size()-1).getGuessedValue();
                    setSudokuBoard(backtrack.get(backtrack.size()-1).getBacktrackBoard().deepCopy());
                    getSudokuBoard().getRowsList().get(xPosition).getElementsList().get(yPosition).getPossibleValues().remove(Integer.valueOf(guessedValue));
                    backtrack.remove(backtrack.size()-1);
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
}

package com.kodilla.sudoku;

public class Backtrack {

    private final SudokuBoard backtrackBoard;
    private final int guessedValue;
    private final Integer[] guessCoordinates;

    public Backtrack(SudokuBoard backtrackBoard, int guessedValue, int xCoordinate, int yCoordinate) {
        this.backtrackBoard = backtrackBoard;
        this.guessedValue = guessedValue;
        this.guessCoordinates = new Integer[2];
        this.guessCoordinates[0] = xCoordinate;
        this.guessCoordinates[1] = yCoordinate;
    }

    public SudokuBoard getBacktrackBoard() {
        return backtrackBoard;
    }

    public int getGuessedValue() {
        return guessedValue;
    }

    public Integer[] getGuessCoordinates() {
        return guessCoordinates;
    }
}

package com.kodilla.sudoku;

import java.util.ArrayList;

public class SudokuElement extends Prototype {
    public static int EMPTY = -1;
    private int value;
    private ArrayList<Integer> possibleValues;

    public SudokuElement() {
        this.value = EMPTY;
        this.possibleValues = new ArrayList<>();
        for(int i = 1; i<10; i++){
            this.possibleValues.add(i);
        }
    }

    public int getValue() {
        return value;
    }

    public ArrayList<Integer> getPossibleValues() {
        return possibleValues;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void setPossibleValues(ArrayList<Integer> possibleValues) {
        this.possibleValues = possibleValues;
    }
}

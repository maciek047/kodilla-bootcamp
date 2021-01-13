package com.kodilla.sudoku;

import java.util.ArrayList;
import java.util.List;

public class SudokuRow {
    List<SudokuElement> elementsList;

    public SudokuRow() {
        this.elementsList = new ArrayList<>();
    }

    public void addElement(SudokuElement element){
        this.elementsList.add(element);
    }

    public List<SudokuElement> getElementsList() {
        return elementsList;
    }
}

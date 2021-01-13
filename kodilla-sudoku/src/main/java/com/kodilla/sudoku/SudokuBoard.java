package com.kodilla.sudoku;

import java.util.ArrayList;
import java.util.List;

public class SudokuBoard extends Prototype {
    List<SudokuRow> rowsList;

    public SudokuBoard() {
        this.rowsList = new ArrayList<>();
    }

    public void addRow(SudokuRow row){
        this.rowsList.add(row);
    }

    public List<SudokuRow> getRowsList() {
        return rowsList;
    }

    public String toString() {
        String result = "";
        for(int n = 0; n <= 8; n++) {
            result += "|";
            for(int k = 0; k <= 8; k++) {
                if(rowsList.get(n).getElementsList().get(k) == null || rowsList.get(n).getElementsList().get(k).getValue()==-1) {
                    result += " _ ";
                } else {
                    result += " " + (rowsList.get(n).getElementsList().get(k)).getValue() + " ";
                }
                result += "|";
            }
            result += "\n";
        }
        return result;
    }

    public SudokuBoard deepCopy() throws CloneNotSupportedException {
        SudokuBoard clonedBoard = (SudokuBoard)super.clone();
        clonedBoard.rowsList = new ArrayList<>();
        for(SudokuRow row : getRowsList()) {
            SudokuRow clonedRow = new SudokuRow();
            for(SudokuElement element : row.getElementsList()) {
                SudokuElement clonedElement = new SudokuElement();
                clonedElement.setValue(element.getValue());
                clonedElement.setPossibleValues(new ArrayList<>());
                for(Integer value : element.getPossibleValues()){
                    clonedElement.getPossibleValues().add(value);
                }
                clonedRow.elementsList.add(clonedElement);
            }
            clonedBoard.rowsList.add(clonedRow);
        }
        return clonedBoard;
    }
}

package com.kodilla.testing.shape;
import java.util.ArrayList;

public class ShapeCollector {
    private ArrayList<Shape> figures = new ArrayList<Shape>();

    public boolean addFigure(Shape shape){
        if (shape!=null){
            figures.add(shape);
            return true;
        } else return false;
    }

    public boolean removeFigure(Shape shape){
        boolean result = false;
        if (figures.contains(shape)){
            figures.remove(shape);
            result = true;
        }
        return result;
    }

    public Shape getFigure(int figureNumber){
        Shape shape = null;
        if (figureNumber >= 0 && figureNumber < figures.size()){
            shape = figures.get(figureNumber);
        }
        return shape;
    }

    public boolean showFigures(){
        if (figures.size() > 0){
            for(Shape figure : figures){
                System.out.println(figure);
            }
            return true;
        }else return false;
    }

    public int getFiguresQuantity(){
        return figures.size();
    }

}

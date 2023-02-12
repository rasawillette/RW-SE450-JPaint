package model.shapes;

import model.interfaces.IShape;
import java.util.ArrayList;

public class ShapeList {
    public ArrayList<IShape> shapeList;
    public ArrayList<IShape> selectedList;

    public ShapeList(){
        shapeList = new ArrayList<IShape>();;
        selectedList = new ArrayList<IShape>();
    }

    public void addShape(IShape shape){
        shapeList.add(shape);
    }
    public void removeShape(IShape shape){
        shapeList.remove(shape);
    }

    public ArrayList<IShape> getShapeList(IShape shape) {
        return shapeList;
    }

    public void addSelectedShape(IShape shape) {
        selectedList.add(shape);
        System.out.println("added to selected shape list");
    }

    public void removeSelectedShape(IShape shape){
        selectedList.remove(shape);
    }
    public void removeAllSelectedShapes(){
        selectedList.clear();
        System.out.println("cleared selected shape list");
    }

    public ArrayList<IShape> getSelectedList(){
        return selectedList;
    }
}

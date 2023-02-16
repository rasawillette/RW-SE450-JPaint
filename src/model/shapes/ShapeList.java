package model.shapes;

import model.interfaces.IShape;
import java.util.ArrayList;

public class ShapeList {
    public ArrayList<IShape> shapeList;
    public ArrayList<IShape> selectedList;
    public ArrayList<IShape> copiedList;

    public ShapeList(){
        shapeList = new ArrayList<IShape>();
        selectedList = new ArrayList<IShape>();
        copiedList = new ArrayList<IShape>();
    }

    public void addShape(IShape shape){
        shapeList.add(shape);
    }

    public void removeShape(IShape shape){
        shapeList.remove(shape);
    }

    public ArrayList<IShape> getShapeList() {
        return shapeList;
    }

    public void addSelectedShape(IShape shape) {
        selectedList.add(shape);
        System.out.println("added to selected shape list");
    }

//    public void removeSelectedShape(IShape shape){
//        selectedList.remove(shape);
//    }
//    public void removeAllSelectedShapes(){
//        selectedList.clear();
//        System.out.println("cleared selected shape list");
//    }

    public ArrayList<IShape> getSelectedList(){
        return selectedList;
    }

//    public boolean contains(IShape shape) {
//        return  shapeList.contains(shape);
//    }

    public void addCopiedShape(IShape shape){
        copiedList.add(shape);
    }

    public ArrayList<IShape> getCopiedList(){
        return copiedList;
    }

}

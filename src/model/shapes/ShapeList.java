package model.shapes;

import model.interfaces.IShape;

import java.util.ArrayList;

public abstract class ShapeList implements IShape {
    public ArrayList<IShape> shapeList;

    public ShapeList(ArrayList<IShape> shapeList){
        this.shapeList = shapeList;
    }

    public void addShape(IShape shape){
        shapeList.add(shape);
    }
    public void removeShape(IShape shape){
        shapeList.remove(shape);
    }
}

package model;

import model.interfaces.IDraw;

import java.util.ArrayList;

public class ShapesList  {
    private ArrayList<IDraw> arrayList;

    public ShapesList(){
        arrayList = new ArrayList<IDraw>();
    }

    public void addShapes(IDraw shape){
        arrayList.add(shape);
    }
    public void removeShapes(IDraw shape){
        arrayList.remove(shape);
    }
}

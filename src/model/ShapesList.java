package model;

import controller.ClickPoint;

import java.util.ArrayList;

public class ShapesList {
    private ArrayList<ClickPoint> arrayList;

    public ShapesList(){
        arrayList = new ArrayList<ClickPoint>();
    }

    public void addShapes(ClickPoint shape){
        arrayList.add(shape);
    }
    public void removeShapes(ClickPoint shape){
        arrayList.remove(shape);
    }
}

package controller;

import model.shapes.ExtraCredit;
import model.shapes.ShapeColor;
import model.shapes.ShapeShadingType;
import model.shapes.ShapeType;

public class Component {

    //static public IShape;
    static public ShapeType activeShapeType;
    static public ShapeColor activePrimaryColor;
    static public ShapeColor activeSecondaryColor;
    static public ShapeShadingType activeShapeShadingType;
    static  public ExtraCredit activeExtraCredit;

    static public int startX;
    static public int startY;
    static public int height;
    static public int width;
}

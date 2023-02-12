package model.interfaces;

import model.persistence.ApplicationState;
import model.shapes.Point;
import model.shapes.ShapeColor;
import model.shapes.ShapeShadingType;
import model.shapes.ShapeType;

import java.awt.*;

public interface IShape {
    void draw(Graphics2D g);

    void selectDraw(Graphics2D g);

    // if not overriding all methods in the shape class files, then remove from interface

    void setStartPoint(int x, int y);
    void setEndPoint(int x, int y);

    void setShapeShadingType(ShapeShadingType shapeShadingType);
    void setPrimaryColor(ShapeColor color);
    void setSecondaryColor(ShapeColor color);

    public ApplicationState getApplicationState() ;
    public void setApplicationState(ApplicationState applicationState) ;

    int getHeight();
    int getWidth();

    // interfaces don't have functions

    Point getStartPoint();
    Point getEndPoint();

    void setSelected(boolean bool);

    ShapeType getShape();
    ShapeColor getPrimaryColor();
    ShapeColor getSecondaryColor();
    ShapeShadingType getShapeShadingType();

    boolean containsPoint(int x, int y);
}

package model.interfaces;

import model.persistence.ApplicationState;
import model.shapes.*;
import model.shapes.Point;

import java.awt.*;

public interface IShape {
    void draw(Graphics2D g);

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

    Boolean checkCoordinates(Point startPoint,Point endPoint);

    void updateMove(int deltaX, int deltaY);

    void selectOutline(Graphics2D g);

    ShapeParams getShapeParams();
}

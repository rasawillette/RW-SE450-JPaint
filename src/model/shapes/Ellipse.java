package model.shapes;

import model.interfaces.IShape;
import model.persistence.ApplicationState;

import java.awt.*;

public class Ellipse implements IShape {

    Point startPoint;
    Point endPoint;
    ApplicationState applicationState;

    public Ellipse(Point startPoint, Point endPoint, ApplicationState applicationState) {
        this.startPoint = startPoint;
        this.endPoint = endPoint;
        this.applicationState = applicationState;
    }

    @Override
    public void setStartPoint(int x, int y) {
        this.startPoint.x = x;
        this.startPoint.y = y;
    }

    @Override
    public void setEndPoint(int x, int y) {
        this.endPoint.x = x;
        this.endPoint.y = y;
    }

    @Override
    public void setShapeShadingType(ShapeShadingType shapeShadingType) {
        //this.applicationState.setActiveShadingType() = shapeShadingType;
    }

    // confirm ^ that application state should be passed into Ellipse constructor as parameter

    @Override
    public void setPrimaryColor(ShapeColor color) {

    }

    @Override
    public void setSecondaryColor(ShapeColor color) {

    }

    @Override
    public ApplicationState getApplicationState() {
        return null;
    }

    @Override
    public void setApplicationState(ApplicationState applicationState) {

    }

    @Override
    public int getHeight() {
        return (applicationState.getStop().y - applicationState.getStart().y);
    }

    @Override
    public int getWidth() {
        return (applicationState.getStop().x - applicationState.getStart().x);
    }

    @Override
    public Point getStartPoint() {
        return startPoint;
    }

    @Override
    public Point getEndPoint() {
        return endPoint;
    }

    @Override
    public void setSelected(boolean bool) {

    }

    @Override
    public BoundingBox getBoundingBox() {
        return null;
    }

    @Override
    public void drawBoundingBox(Graphics2D g) {

    }

    @Override
    public ShapeType getShape() {
        return (applicationState.getActiveShapeType());
    }

    @Override
    public ShapeColor getPrimaryColor() {
        return null;
    }

    @Override
    public ShapeColor getSecondaryColor() {
        return null;
    }

    @Override
    public ShapeShadingType getShapeShadingType() {
        return null;
    }

    @Override
    public boolean containsPoint(int x, int y) {
        return false;
    }
}

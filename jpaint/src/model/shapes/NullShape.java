package model.shapes;

import model.interfaces.IShape;
import model.persistence.ApplicationState;

import java.awt.*;

public class NullShape implements IShape {
    @Override
    public void draw(Graphics2D g) {}

    @Override
    public void setStartPoint(int x, int y) {

    }

    @Override
    public void setEndPoint(int x, int y) {

    }

    @Override
    public void setShapeShadingType(ShapeShadingType shapeShadingType) {

    }

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
        return 0;
    }

    @Override
    public int getWidth() {
        return 0;
    }

    @Override
    public Point getStartPoint() {
        return null;
    }

    @Override
    public Point getEndPoint() {
        return null;
    }

    @Override
    public void setSelected(boolean bool) {

    }

    @Override
    public ShapeType getShape() {
        return null;
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
    public Boolean checkCoordinates(Point startPoint, Point endPoint) {
        return null;
    }

    @Override
    public void updateMove(int deltaX, int deltaY) {

    }

    @Override
    public void selectOutline(Graphics2D g) {

    }

    @Override
    public ShapeParams getShapeParams() {
        return null;
    }
}

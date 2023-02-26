package model.shapes;

import model.interfaces.IShape;
import model.persistence.ApplicationState;
import model.proxy.ShapeOutlineProxy;

import java.awt.*;

public class Ellipse implements IShape {

    ShapeParams shapeParams;
    Point startPoint;
    Point endPoint;
    ApplicationState applicationState;
    Graphics2D graphics2d;

    int minX,minY,maxX,maxY;

    public Ellipse(ShapeParams shapeParams) {
        this.shapeParams = shapeParams;
        this.startPoint = shapeParams.getStartPoint();
        this.endPoint = shapeParams.getEndPoint();

        minX = Math.min(startPoint.getX(), endPoint.getX());
        minY = Math.min(startPoint.getY(), endPoint.getY());
        maxX = Math.max(startPoint.getX(), endPoint.getX());
        maxY = Math.max(startPoint.getY(), endPoint.getY());
    }

    public Color getColor(ShapeColor shapeColor) {
        switch (shapeColor) {
            case BLACK: return Color.black;
            case BLUE: return Color.blue;
            case CYAN: return Color.cyan;
            case DARK_GRAY: return Color.darkGray;
            case GRAY: return Color.gray;
            case GREEN: return Color.green;
            case LIGHT_GRAY: return Color.lightGray;
            case MAGENTA: return Color.magenta;
            case ORANGE: return Color.orange;
            case PINK: return Color.pink;
            case RED: return Color.red;
            case WHITE: return Color.white;
            case YELLOW: return Color.yellow;
            default: return Color.black;
        }
    }

    @Override
    public void draw(Graphics2D graphics2D) {
        shapeParams.getPrimaryColor();
        graphics2D.setColor(getColor(shapeParams.getPrimaryColor()));

        int width = shapeParams.endPoint.x - shapeParams.startPoint.x;
        int height = shapeParams.endPoint.y - shapeParams.startPoint.y;

        shapeParams.getShadingType();

        // outline
        if (shapeParams.getShadingType() == ShapeShadingType.OUTLINE) {
            graphics2D.drawOval(startPoint.x, startPoint.y, width, height);
        }

        // filled in
        if (shapeParams.getShadingType() == ShapeShadingType.FILLED_IN) {
            graphics2D.fillOval(startPoint.x, startPoint.y, width, height);
        }

        // outline and filled in
        if (shapeParams.getShadingType() == ShapeShadingType.OUTLINE_AND_FILLED_IN) {
            graphics2D.fillOval(startPoint.x, startPoint.y, width, height);
            graphics2D.setColor(getColor(shapeParams.getSecondaryColor()));
            graphics2D.drawOval(startPoint.x, startPoint.y, width, height);
        }
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
    public void setShapeShadingType(ShapeShadingType shapeShadingType) {}

    @Override
    public void setPrimaryColor(ShapeColor color) {}

    @Override
    public void setSecondaryColor(ShapeColor color) {}

    @Override
    public ApplicationState getApplicationState() {
        return null;
    }

    @Override
    public void setApplicationState(ApplicationState applicationState) {}

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
    public void setSelected(boolean bool) {}

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
    public Boolean checkCoordinates(Point start,Point end ) {
        int minX_bool = Math.min(startPoint.getX(), endPoint.getX());
        int minY_bool = Math.min(startPoint.getY(), endPoint.getY());
        int maxX_bool = Math.max(startPoint.getX(), endPoint.getX());
        int maxY_bool = Math.max(startPoint.getY(), endPoint.getY());

        //return ((minX < maxX_bool) && (maxX > minX_bool ) && (minY < maxY_bool) && (maxY > minY_bool));

        return minX_bool < end.getX() && maxX_bool > start.getX() && minY_bool < end.getY() && maxY_bool > start.getY();
//		rect1.x < rect2.x + rect2.w &&
//				rect1.x + rect1.w > rect2.x &&
//				rect1.y < rect2.y + rect2.h &&
//				rect1.h + rect1.y > rect2.y
    }

    @Override
    public void updateMove(int deltaX, int deltaY){
        minX = minX + deltaX;
        minY = minY + deltaY;
        maxX = maxX + deltaX;
        maxY = maxY + deltaY;

        startPoint.setX(minX);
        startPoint.setY(minY);
        endPoint.setX(maxX);
        endPoint.setY(maxY);

        shapeParams.setStartPoint(startPoint);
        shapeParams.setEndPoint(endPoint);
    }

    @Override
    public void selectOutline(Graphics2D g) {
        ShapeOutlineProxy shapeOutlineProxy = new ShapeOutlineProxy(shapeParams,g);
        shapeOutlineProxy.drawOutline();
    }

    @Override
    public ShapeParams getShapeParams() {
        return shapeParams;
    }
}

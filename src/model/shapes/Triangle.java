package model.shapes;


import model.interfaces.IShape;
import model.persistence.ApplicationState;

import java.awt.*;

public class Triangle implements IShape {

    ShapeParams shapeParams;
    Point startPoint;
    Point endPoint;
    ApplicationState applicationState;

    int minX,minY,maxX,maxY;

    public Triangle(ShapeParams shapeParams) {
        //this.startPoint = startPoint;
        //this.endPoint = endPoint;
        //this.applicationState = applicationState;
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

    public ShapeShadingType getShading(ShapeShadingType shapeShadingType) {
        switch (shapeShadingType) {
            case OUTLINE: return ShapeShadingType.OUTLINE;
            case FILLED_IN: return ShapeShadingType.FILLED_IN;
            case OUTLINE_AND_FILLED_IN: return ShapeShadingType.OUTLINE_AND_FILLED_IN;
            default: return ShapeShadingType.FILLED_IN;
        }
    }

    @Override
    public void draw(Graphics2D graphics2d) {

        System.out.println("draw triangle " + shapeParams.getStartPoint() + shapeParams.getEndPoint());

        //if (applicationState.getStart() != null && applicationState.getStop() != null) {
        shapeParams.getPrimaryColor();
        graphics2d.setColor(getColor(shapeParams.getPrimaryColor()));

        //int width = applicationState.getStop().x - applicationState.getStart().x;
        //int height = applicationState.getStop().y - applicationState.getStart().y;

        int width = shapeParams.endPoint.x - shapeParams.startPoint.x;
        int height = shapeParams.endPoint.y - shapeParams.startPoint.y;

        shapeParams.getShadingType();

        int[] xPoints = {startPoint.x, endPoint.x, startPoint.x};
        int[] yPoints = {startPoint.y, endPoint.y, endPoint.y};
        int nPoints = 3;

        // outline
        if (shapeParams.getShadingType() == ShapeShadingType.OUTLINE) {
            System.out.println("shading type is outline");
            graphics2d.drawPolygon(xPoints, yPoints, nPoints);
        }

        // filled in
        if (shapeParams.getShadingType() == ShapeShadingType.FILLED_IN) {
            System.out.println("shading type is filled in");
            graphics2d.fillPolygon(xPoints, yPoints, nPoints);
        }

        // outline and filled in
        if (shapeParams.getShadingType() == ShapeShadingType.OUTLINE_AND_FILLED_IN) {
            System.out.println("shading type is outlined and filled in");
            graphics2d.fillPolygon(xPoints, yPoints, nPoints);
            graphics2d.setColor(getColor(shapeParams.getSecondaryColor()));
            graphics2d.drawPolygon(xPoints, yPoints, nPoints);
        }
        //}

    }


    public void selectDraw(Graphics2D g) {
        Stroke stroke = new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 1, new float[]{9}, 0);
        g.setStroke(stroke);
        g.setColor(Color.BLACK);
        int width = applicationState.getStop().x - applicationState.getStart().x;
        int height = applicationState.getStop().y - applicationState.getStart().y;
        g.drawRect(applicationState.getStart().x, applicationState.getStart().y, width, height);
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
    public Boolean checkCoordinates(Point S_point,Point E_point ) {
        int min_x_b = Math.min(startPoint.getX(), endPoint.getX());
        int min_y_b = Math.min(startPoint.getY(), endPoint.getY());
        int max_x_b = Math.max(startPoint.getX(), endPoint.getX());
        int max_y_b = Math.max(startPoint.getY(), endPoint.getY());

        return ((minX < max_x_b) && (maxX > min_x_b ) && (minY < max_y_b) && (maxY > min_y_b));
    }

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
}

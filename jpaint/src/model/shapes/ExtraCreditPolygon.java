package model.shapes;

import model.commands.GroupCommand;
import model.interfaces.IShape;
import model.persistence.ApplicationState;
import model.proxy.ShapeOutlineProxy;

import java.awt.*;
import java.util.ArrayList;

public class ExtraCreditPolygon implements IShape {

    ShapeParams shapeParams;
    Point startPoint;
    Point endPoint;
    ApplicationState applicationState;
    Graphics2D graphics2D;

    Color finalColorPrimary;
    Color finalColorSecondary;
    ShapeColor primaryColor;
    ShapeColor secondaryColor;

    int minX,minY,maxX,maxY;

    public ExtraCreditPolygon(ShapeParams shapeParams) {
        this.shapeParams = shapeParams;
        this.startPoint = shapeParams.getStartPoint();
        this.endPoint = shapeParams.getEndPoint();

        minX = Math.min(startPoint.getX(), endPoint.getX());
        minY = Math.min(startPoint.getY(), endPoint.getY());
        maxX = Math.max(startPoint.getX(), endPoint.getX());
        maxY = Math.max(startPoint.getY(), endPoint.getY());

        // implement singleton color design pattern
        this.finalColorPrimary = SingletonColor.getColor(primaryColor);
        this.finalColorSecondary = SingletonColor.getColor(secondaryColor);
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
    public void draw(Graphics2D g) {
        shapeParams.getPrimaryColor();
        graphics2D.setColor(getColor(shapeParams.getPrimaryColor()));

        int width = shapeParams.endPoint.x - shapeParams.startPoint.x;
        int height = shapeParams.endPoint.y - shapeParams.startPoint.y;

        shapeParams.getShadingType();

        int[] xPoints = {startPoint.x, endPoint.x, startPoint.x/(1/3), startPoint.x/(2/3), startPoint.x/(1/2)};
        int[] yPoints = {startPoint.y, endPoint.y, endPoint.y, endPoint.y/(1/3), endPoint.y/(2/3), endPoint.y/(1/2)};
        int nPoints = 5;

        // outline
        if (shapeParams.getShadingType() == ShapeShadingType.OUTLINE) {
            System.out.println("shading type is outline");
            graphics2D.drawPolygon(xPoints, yPoints, nPoints);
        }

        // filled in
        if (shapeParams.getShadingType() == ShapeShadingType.FILLED_IN) {
            System.out.println("shading type is filled in");
            graphics2D.fillPolygon(xPoints, yPoints, nPoints);
        }

        // outline and filled in
        if (shapeParams.getShadingType() == ShapeShadingType.OUTLINE_AND_FILLED_IN) {
            System.out.println("shading type is outlined and filled in");
            graphics2D.fillPolygon(xPoints, yPoints, nPoints);
            graphics2D.setColor(getColor(shapeParams.getSecondaryColor()));
            graphics2D.drawPolygon(xPoints, yPoints, nPoints);
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
        return shapeParams.endPoint.y - shapeParams.startPoint.y;
    }

    @Override
    public int getWidth() {
        return shapeParams.endPoint.x - shapeParams.startPoint.x;
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
    public Boolean checkCoordinates(Point start,Point end) {
        int minX_bool = Math.min(startPoint.getX(), endPoint.getX());
        int minY_bool = Math.min(startPoint.getY(), endPoint.getY());
        int maxX_bool = Math.max(startPoint.getX(), endPoint.getX());
        int maxY_bool = Math.max(startPoint.getY(), endPoint.getY());

        return minX_bool < end.getX() && maxX_bool > start.getX() && minY_bool < end.getY() && maxY_bool > start.getY();
    }

    @Override
    public void updateMove(int deltaX, int deltaY) {
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

    ArrayList<GroupCommand> groupCommandArrayList = new ArrayList<>();

    @Override
    public void addGroupShape(GroupCommand groupCommand) {
        groupCommandArrayList.add(groupCommand);
    }

    @Override
    public ArrayList<GroupCommand> getShapeGroup() {
        return groupCommandArrayList;
    }

    @Override
    public void removeGroupShape() {
        groupCommandArrayList.remove(groupCommandArrayList.size() -1);
    }
}

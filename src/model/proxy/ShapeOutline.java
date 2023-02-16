package model.proxy;

import model.interfaces.IProxyOutline;
import model.shapes.ShapeParams;
import model.shapes.ShapeType;

import java.awt.*;

public class ShapeOutline implements IProxyOutline {

    ShapeParams shapeParams;
    RectangleOutline rectangleOutline = new RectangleOutline();
    EllipseOutline ellipseOutline = new EllipseOutline();;
    TriangleOutline triangleOutline = new TriangleOutline();
    Graphics2D graphics2D;

    public ShapeOutline(ShapeParams shapeParams,Graphics2D graphics2D){
        this.graphics2D = graphics2D;
        this.shapeParams = shapeParams;
    }


    @Override
    public void drawOutline() {

        if(shapeParams.getShapeType().equals(ShapeType.RECTANGLE)){
            rectangleOutline.draw(shapeParams,graphics2D);
        }

        if(shapeParams.getShapeType().equals(ShapeType.TRIANGLE)){
            triangleOutline.draw(shapeParams,graphics2D);
        }

        if(shapeParams.getShapeType().equals(ShapeType.ELLIPSE)){
            ellipseOutline.draw(shapeParams,graphics2D);
        }

    }
}

package model.proxy;

import model.shapes.ShapeParams;

import java.awt.*;

public class TriangleOutline {


    public void draw(ShapeParams shapeParams, Graphics2D graphics2D) {
        Stroke stroke = new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 1, new float[]{9}, 0);
        graphics2D.setStroke(stroke);
        graphics2D.setColor(Color.BLACK);

        int[] x = {shapeParams.startPoint.getX()-5, shapeParams.endPoint.getX()+5, shapeParams.startPoint.getX()-5};
        int[] y = {shapeParams.startPoint.getY()-5, shapeParams.endPoint.getY()+5, shapeParams.endPoint.getY()+5};
        graphics2D.drawPolygon(x,y,3);
    }
}

package model.proxy;

import model.shapes.ShapeParams;

import java.awt.*;

public class RectangleOutline {

    public void draw(ShapeParams shapeParams, Graphics2D graphics2D){
        Stroke stroke = new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 1, new float[]{9}, 0);
        graphics2D.setStroke(stroke);
        graphics2D.setColor(Color.BLACK);

        graphics2D.drawRect(shapeParams.startPoint.getX()-5 , shapeParams.startPoint.getY()-5,
                shapeParams.getWidth()+10, shapeParams.getHeight() + 10);
    }

}

package model.proxy;

import model.interfaces.IProxyOutline;
import model.shapes.ShapeParams;

import java.awt.*;

public class ShapeOutlineProxy implements IProxyOutline {

    ShapeOutline shapeOutline;
    ShapeParams shapeParams;
    Graphics2D graphics2D;

    public ShapeOutlineProxy(ShapeParams shapeParams, Graphics2D graphics2D) {
        this.shapeParams = shapeParams;
        this.graphics2D = graphics2D;

        shapeOutline = new ShapeOutline(shapeParams,graphics2D);
    }


    @Override
    public void drawOutline() {
        shapeOutline.drawOutline();
    }
}

package model.proxy;

import model.interfaces.IProxyOutline;
import model.shapes.ShapeParams;

import java.awt.*;

public class ShapeOutlineProxy implements IProxyOutline {

    ShapeOutline shapeOutline;
    ShapeParams shapeParams;
    Graphics2D graphics2d;

    public ShapeOutlineProxy(ShapeParams shapeParams, Graphics2D graphics2d) {
        this.shapeParams = shapeParams;
        this.graphics2d = graphics2d;
        shapeOutline = new ShapeOutline(shapeParams,graphics2d);
    }

    @Override
    public void drawOutline() {
        shapeOutline.drawOutline();
    }
}

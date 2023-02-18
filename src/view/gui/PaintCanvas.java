package view.gui;

import model.interfaces.IShape;
import model.persistence.ApplicationState;
import model.shapes.ShapeList;
import model.shapes.ShapeParams;
import view.interfaces.IPaintCanvas;

import javax.swing.*;
import java.awt.*;

public class PaintCanvas extends JComponent implements IPaintCanvas {


    ApplicationState applicationState;
    ShapeList shapeList;
    ShapeParams shapeParams;
    Graphics2D graphics2D;

    public PaintCanvas(ShapeList shapeList) {
        this.shapeList = shapeList;
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D graphics2d = (Graphics2D) g;

        for (IShape shape : shapeList.getShapeList()) {
            shape.draw(graphics2d);
            System.out.println("something");

            if (shapeList.getSelectedList().contains(shape)) {
                shape.selectOutline(graphics2d);
            }
        }
    }

    public void update(){
        System.out.println("update in paint canvas");
        repaint();
    }

    public void addState(ApplicationState applicationState) {
        this.applicationState = applicationState;
    }

    @Override
    public Graphics2D getGraphics2D() {
        return (Graphics2D)getGraphics();
    }
}

package model.persistence;

import model.interfaces.IMouseState;
import model.shapes.Point;
import model.shapes.ShapeList;
import view.gui.PaintCanvas;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

// override 2 methods
public class MouseHandler implements MouseListener {

    public Point startPoint;
    public Point endPoint;

    //IGuiWindow guiWindow;
    ApplicationState applicationState;
    PaintCanvas paintCanvas;
    ShapeList shapeList;
    IMouseState mouseState;

    public MouseHandler(ApplicationState applicationState,PaintCanvas paintCanvas,ShapeList shapeList){
        this.applicationState = applicationState;
        this.paintCanvas = paintCanvas;
        this.shapeList = shapeList;
    }

    @Override
    public void mouseClicked(MouseEvent e) {}

    // mouse pressed
    @Override
    public void mousePressed(MouseEvent e) {
        startPoint = new Point();
        startPoint.x = e.getX();
        startPoint.y = e.getY();
        applicationState.setStart(startPoint);
        System.out.println("mouse pressed" + startPoint.x + " " + startPoint.y);
    }

    // mouse released
    @Override
    public void mouseReleased(MouseEvent e) {

        endPoint = new Point();
        endPoint.x = e.getX();
        endPoint.y = e.getY();
        applicationState.setStop(endPoint);

        // calculate height
        int height = (int) Math.abs(endPoint.y- startPoint.y);
        // calculate width
        int width = (int) Math.abs(endPoint.x- startPoint.x);

        System.out.println("mouse released" + height + " " + width);
        e.getComponent().repaint();
    }

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}

    public void addState(ApplicationState applicationState) {
        this.applicationState = applicationState;
    }

}

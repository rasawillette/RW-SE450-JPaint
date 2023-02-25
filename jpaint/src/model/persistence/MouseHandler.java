package model.persistence;

import model.MouseMode;
import model.interfaces.IMouseState;
import model.shapes.Point;
import model.shapes.ShapeList;
import model.shapes.ShapeParams;
import view.gui.PaintCanvas;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

// override 2 methods
public class MouseHandler implements MouseListener {

    public Point startPoint;
    public Point endPoint;

    //IGuiWindow guiWindow;
    ShapeParams shapeParams;
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
        shapeParams = new ShapeParams();
        startPoint = new Point(e.getX(),e.getY());
        //startPoint.x = e.getX();
        //startPoint.y = e.getY();
        shapeParams.setStartPoint(startPoint);
        //applicationState.setStart(startPoint);
        System.out.println("mouse pressed" + startPoint.x + " " + startPoint.y);
    }

    // mouse released
    @Override
    public void mouseReleased(MouseEvent e) {

        endPoint = new Point(e.getX(),e.getY());

        shapeParams.setEndPoint(endPoint);
        shapeParams.setPrimaryColor(applicationState.getActivePrimaryColor());
        shapeParams.setSecondaryColor(applicationState.getActiveSecondaryColor());
        shapeParams.setShadingType(applicationState.getActiveShapeShadingType());
        shapeParams.setShapeType(applicationState.getActiveShapeType());

        e.getComponent().repaint();

        if (applicationState.getActiveMouseMode().equals(MouseMode.DRAW)) {
            mouseState = new DrawMouseState();
            mouseState.execute(shapeParams,paintCanvas,shapeList);
        }

        if (applicationState.getActiveMouseMode().equals(MouseMode.SELECT)) {
            mouseState = new SelectMouseState();
            mouseState.execute(shapeParams,paintCanvas,shapeList);
        }

        if(applicationState.getActiveMouseMode().equals(MouseMode.MOVE)){
            mouseState = new MoveMouseState();
            mouseState.execute(shapeParams,paintCanvas,shapeList);
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}

    public void addState(ApplicationState applicationState) {
        this.applicationState = applicationState;
    }

}

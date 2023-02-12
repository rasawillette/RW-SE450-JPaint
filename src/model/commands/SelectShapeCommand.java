package model.commands;

import model.interfaces.IShape;
import model.persistence.ApplicationState;
import model.shapes.Point;
import model.shapes.ShapeList;
import view.gui.PaintCanvas;

import java.awt.*;

public class SelectShapeCommand implements ICommand,IUndoable {

    ApplicationState applicationState;
    IShape newShape;
    ShapeList shapeList;
    PaintCanvas paintCanvas;

    Point startPoint;
    Point endPoint;

    public SelectShapeCommand(Point startPoint, Point endPoint, ApplicationState applicationState, PaintCanvas paintCanvas) {
        this.startPoint = startPoint;
        this.endPoint = endPoint;
        this.applicationState = applicationState;
        this.paintCanvas = paintCanvas;
    }

    @Override
    public void execute() {

        for (IShape shape : shapeList.getShapeList(newShape)) {
            paintCanvas.update();
            System.out.println("selected command " + newShape.getStartPoint() + newShape.getEndPoint());

            Graphics2D g = paintCanvas.getGraphics2D();

            // if there is one click
            if (startPoint != null || endPoint != null ) {
                System.out.println("1 click select");
            }

            // if there are 2 clicks
            else if (startPoint != null && endPoint != null){
                System.out.println("2 clicks select");
            }

        }

    }

    @Override
    public void undo() {
        // nothing
    }

    @Override
    public void redo() {
        // nothing
    }
}

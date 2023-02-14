package model.commands;

import model.interfaces.IShape;
import model.persistence.ApplicationState;
import model.shapes.Point;
import model.shapes.ShapeList;
import model.shapes.ShapeType;
import view.gui.PaintCanvas;

import java.awt.*;

public class MoveShapeCommand implements ICommand,IUndoable {

    Graphics2D graphics2d;
    ApplicationState applicationState;
    IShape newShape;
    ShapeList shapeList;
    ShapeType shape;
    PaintCanvas paintCanvas;

    Point startPoint;
    Point endPoint;

    int delta_x;
    int delta_y;


    public MoveShapeCommand(Point startPoint, Point endPoint, ApplicationState applicationState,
                            PaintCanvas paintCanvas, ShapeList shapeList) {
        this.startPoint = startPoint;
        this.endPoint = endPoint;
        this.applicationState = applicationState;
        this.paintCanvas = paintCanvas;
        this.shapeList = shapeList;
    }

    @Override
    public void execute() {
        delta_x = endPoint.x - startPoint.x;
        delta_y = endPoint.y - startPoint.y;

    }

    @Override
    public void undo() {
        shapeList.removeShape(newShape);
        paintCanvas.update();
    }

    @Override
    public void redo() {
        shapeList.addShape(newShape);
        paintCanvas.update();
    }
}

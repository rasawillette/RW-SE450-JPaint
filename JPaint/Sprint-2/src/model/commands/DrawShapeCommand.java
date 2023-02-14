package model.commands;

import model.interfaces.IShape;
import model.persistence.ApplicationState;
import model.shapes.Point;
import model.shapes.ShapeFactory;
import model.shapes.ShapeList;
import model.shapes.ShapeType;
import view.gui.PaintCanvas;

import java.awt.*;

public class DrawShapeCommand implements ICommand, IUndoable {

    Graphics2D graphics2d;
    ApplicationState applicationState;
    IShape newShape;
    ShapeList shapeList;
    ShapeType shape;
    PaintCanvas paintCanvas;

    Point startPoint;
    Point endPoint;

    public DrawShapeCommand(Point startPoint, Point endPoint, ApplicationState applicationState, PaintCanvas paintCanvas){
        this.startPoint = startPoint;
        this.endPoint = endPoint;
        this.applicationState = applicationState;
        this.paintCanvas = paintCanvas;
    }

    @Override
    public void execute() {
        shape = applicationState.getActiveShapeType();
        newShape = ShapeFactory.getShape(startPoint, endPoint, applicationState);
        paintCanvas.update();
        CommandHistory.add(this);
        newShape.draw(graphics2d);
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

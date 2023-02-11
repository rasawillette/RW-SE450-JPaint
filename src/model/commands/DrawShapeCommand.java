package model.commands;

import model.interfaces.IShape;
import model.persistence.ApplicationState;
import model.shapes.Point;
import model.shapes.ShapeFactory;
import model.shapes.ShapeList;
import view.gui.PaintCanvas;

public class DrawShapeCommand implements ICommand, IUndoable {

    ApplicationState applicationState;
    IShape newShape;
    ShapeList shapeList;
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
        newShape = ShapeFactory.getShape(startPoint, endPoint, applicationState);
        this.shapeList.addShape(newShape);
        paintCanvas.update();
        CommandHistory.add(this);
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

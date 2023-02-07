package model.commands;

import model.interfaces.IShape;
import model.persistence.ApplicationState;
import model.shapes.Point;
import model.shapes.ShapeFactory;
import model.shapes.ShapeList;
import view.gui.PaintCanvas;

public class DrawShapeCommand implements ICommand, IUndoable {

    private PaintCanvas paintCanvas;
    private ShapeList shapeList;
    private ApplicationState applicationState;

    Point startPoint;
    Point endPoint;
    IShape newShape;

    public DrawShapeCommand(Point startPoint, Point endPoint, ApplicationState applicationState){
        this.startPoint = startPoint;
        this.endPoint = endPoint;
        this.applicationState = applicationState;
        newShape = ShapeFactory.getShape(startPoint, endPoint, applicationState);
    }


    @Override
    public void execute() {
        CommandHistory.add(this);
    }

    @Override
    public void undo() {

    }

    @Override
    public void redo() {

    }
}

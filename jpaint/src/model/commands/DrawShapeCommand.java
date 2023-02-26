package model.commands;

import model.interfaces.IShape;
import model.persistence.ApplicationState;
import model.shapes.*;
import model.shapes.Point;
import view.gui.PaintCanvas;

import java.awt.*;

public class DrawShapeCommand implements ICommand, IUndoable {

    Graphics2D graphics2d;
    ShapeParams shapeParams;
    ApplicationState applicationState;
    IShape newShape;
    ShapeList shapeList;
    ShapeType shape;
    PaintCanvas paintCanvas;
    ShapeFactory shapeFactory;

    Point startPoint;
    Point endPoint;

    public DrawShapeCommand(ShapeParams shapeParams, PaintCanvas paintCanvas,ShapeList shapeList){
        this.shapeParams = shapeParams;
        this.paintCanvas = paintCanvas;
        this.shapeList = shapeList;
    }

    @Override
    public void execute() {
        shapeFactory = new ShapeFactory();
        newShape = ShapeFactory.getShape(shapeParams);
        CommandHistory.add(this);
        shapeList.addShape(newShape);
        paintCanvas.update();
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

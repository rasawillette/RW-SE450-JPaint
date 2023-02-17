package model.commands;

import model.interfaces.IShape;
import model.persistence.ApplicationState;
import model.shapes.Point;
import model.shapes.ShapeList;
import model.shapes.ShapeParams;
import model.shapes.ShapeType;
import view.gui.PaintCanvas;

import java.awt.*;
import java.util.ArrayList;

public class MoveShapeCommand implements ICommand,IUndoable {

    Graphics2D graphics2d;
    ShapeParams shapeParams;
    ApplicationState applicationState;
    IShape newShape;
    ShapeList shapeList;
    ShapeType shape;
    PaintCanvas paintCanvas;

    Point startPoint;
    Point endPoint;

    int deltaX, deltaY, deltaX_move, deltaY_move;

    ArrayList<IShape> tempShapeMoveList;


    public MoveShapeCommand(ShapeParams shapeParams, PaintCanvas paintCanvas, ShapeList shapeList) {
        this.shapeParams = shapeParams;
        this.paintCanvas = paintCanvas;
        this.shapeList = shapeList;
        this.startPoint = shapeParams.getStartPoint();
        this.endPoint = shapeParams.getEndPoint();

        deltaX = endPoint.getX() - startPoint.getX();
        deltaY = endPoint.getY() - startPoint.getY();
        deltaX_move = (deltaX * (-1));
        deltaY_move = (deltaY * (-1));

        tempShapeMoveList = new ArrayList<IShape>();
    }

    @Override
    public void execute() {

        for (IShape shape : shapeList.getSelectedList()) {

            if(shapeList.getShapeList().contains(shape)) {
                shapeList.removeShape(shape);
                shape.updateMove(deltaX, deltaY);
                shapeList.addShape(shape);
                tempShapeMoveList.add(shape);
            }
        }
        paintCanvas.update();
        CommandHistory.add(this);
    }

    @Override
    public void undo() {
        System.out.println("undo move");
        for(IShape shape: tempShapeMoveList){
            shapeList.removeShape(shape);
            shape.updateMove(deltaX_move, deltaY_move);
            shapeList.addShape(shape);
        }
        paintCanvas.update();
    }

    @Override
    public void redo() {
        System.out.println("redo move");
        for (IShape shape : tempShapeMoveList) {
            shapeList.removeShape(shape);
            shape.updateMove(deltaX, deltaY);
            shapeList.addShape(shape);
        }
        paintCanvas.update();
    }
}

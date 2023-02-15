package model.persistence;

import model.commands.MoveShapeCommand;
import model.interfaces.IMouseState;
import model.shapes.Point;
import model.shapes.ShapeList;
import model.shapes.ShapeParams;
import view.gui.PaintCanvas;

public class MoveMouseState implements IMouseState {


    @Override
    public void execute(ShapeParams shapeParams, PaintCanvas paintCanvas, ShapeList shapeList) {

        MoveShapeCommand moveShapeCommand = new MoveShapeCommand(shapeParams, paintCanvas, shapeList);

        moveShapeCommand.execute();
    }
}

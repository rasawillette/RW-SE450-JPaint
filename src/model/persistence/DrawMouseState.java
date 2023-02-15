package model.persistence;

import model.commands.DrawShapeCommand;
import model.interfaces.IMouseState;
import model.shapes.ShapeList;
import model.shapes.ShapeParams;
import view.gui.PaintCanvas;

public class DrawMouseState implements IMouseState {

    @Override
    public void execute(ShapeParams shapeParams, PaintCanvas paintCanvas, ShapeList shapeList) {


        DrawShapeCommand drawShapeCommand = new DrawShapeCommand(shapeParams, paintCanvas, shapeList);

        drawShapeCommand.execute();
    }
}

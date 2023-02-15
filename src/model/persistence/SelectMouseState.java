package model.persistence;

import model.commands.SelectShapeCommand;
import model.interfaces.IMouseState;
import model.shapes.Point;
import model.shapes.ShapeList;
import model.shapes.ShapeParams;
import view.gui.PaintCanvas;

import java.awt.*;

public class SelectMouseState implements IMouseState {
    @Override
    public void execute(ShapeParams shapeParams, PaintCanvas paintCanvas, ShapeList shapeList) {

        SelectShapeCommand selectShapeCommand = new SelectShapeCommand(shapeParams, paintCanvas, shapeList);

        selectShapeCommand.execute();
    }
}

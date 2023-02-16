package model.persistence;

import model.commands.SelectShapeCommand;
import model.interfaces.IMouseState;
import model.shapes.ShapeList;
import model.shapes.ShapeParams;
import view.gui.PaintCanvas;

public class SelectMouseState implements IMouseState {
    @Override
    public void execute(ShapeParams shapeParams, PaintCanvas paintCanvas, ShapeList shapeList) {

        SelectShapeCommand selectShapeCommand = new SelectShapeCommand(shapeParams, paintCanvas, shapeList);
        System.out.println("print calling select shape command execute");
        selectShapeCommand.execute();
    }
}

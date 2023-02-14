package model.persistence;

import model.commands.SelectShapeCommand;
import model.interfaces.IMouseState;
import model.shapes.Point;
import model.shapes.ShapeList;
import view.gui.PaintCanvas;

public class SelectMouseState implements IMouseState {
    @Override
    public void execute(Point startPoint, Point endPoint, ApplicationState applicationState,
                        PaintCanvas paintCanvas, ShapeList shapeList) {

        SelectShapeCommand selectShapeCommand = new SelectShapeCommand(startPoint, endPoint, applicationState,
                paintCanvas, shapeList);

        selectShapeCommand.execute();
    }
}

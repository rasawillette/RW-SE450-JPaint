package model.persistence;

import model.commands.MoveShapeCommand;
import model.interfaces.IMouseState;
import model.shapes.Point;
import model.shapes.ShapeList;
import view.gui.PaintCanvas;

public class MoveMouseState implements IMouseState {


    @Override
    public void execute(Point startPoint, Point endPoint, ApplicationState applicationState,
                        PaintCanvas paintCanvas, ShapeList shapeList) {

        MoveShapeCommand moveShapeCommand = new MoveShapeCommand(startPoint, endPoint, applicationState,
                paintCanvas, shapeList);

        moveShapeCommand.execute();
    }
}

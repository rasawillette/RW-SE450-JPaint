package model.persistence;

import model.commands.DrawShapeCommand;
import model.interfaces.IMouseState;
import model.shapes.Point;
import model.shapes.ShapeList;
import view.gui.PaintCanvas;

public class DrawMouseState implements IMouseState {

    @Override
    public void execute(Point startPoint, Point endPoint, ApplicationState applicationState, PaintCanvas paintCanvas, ShapeList shapeList) {
        //shapeList.removeAllSelectedShapes();
        DrawShapeCommand drawShapeCommand = new DrawShapeCommand(startPoint, endPoint, applicationState, paintCanvas, shapeList);
        drawShapeCommand.execute();
    }
}

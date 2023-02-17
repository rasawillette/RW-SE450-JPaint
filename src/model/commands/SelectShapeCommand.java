package model.commands;

import model.interfaces.IShape;
import model.persistence.ApplicationState;
import model.shapes.Point;
import model.shapes.ShapeList;
import model.shapes.ShapeParams;
import view.gui.PaintCanvas;

public class SelectShapeCommand implements ICommand {

    ApplicationState applicationState;
    ShapeParams shapeParams;
    IShape newShape;
    ShapeList shapeList;
    ShapeList selectedList;
    PaintCanvas paintCanvas;
    Point startPoint;
    Point endPoint;

    int minX, minY;

    public SelectShapeCommand(ShapeParams shapeParams, PaintCanvas paintCanvas, ShapeList shapeList) {
        this.shapeParams = shapeParams;
        this.paintCanvas = paintCanvas;
        this.shapeList = shapeList;
        this.startPoint = shapeParams.getStartPoint();
        this.endPoint = shapeParams.getEndPoint();
    }

    @Override
    public void execute() {
        shapeList.removeAllSelectedShapes();

        for (IShape shape : shapeList.getShapeList()) {
            paintCanvas.update();

            if (shape.checkCoordinates(startPoint, endPoint)) {
                shapeList.addSelectedShape(shape);
            }
            paintCanvas.update();
            System.out.println("2 clicks select");
        }
    }
}

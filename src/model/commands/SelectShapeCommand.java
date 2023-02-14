package model.commands;

import model.interfaces.IShape;
import model.persistence.ApplicationState;
import model.shapes.Point;
import model.shapes.ShapeList;
import view.gui.PaintCanvas;

public class SelectShapeCommand implements ICommand,IUndoable {

    ApplicationState applicationState;
    IShape newShape;
    ShapeList shapeList;
    PaintCanvas paintCanvas;

    Point startPoint;
    Point endPoint;

    public SelectShapeCommand(Point startPoint, Point endPoint, ApplicationState applicationState,
                              PaintCanvas paintCanvas, ShapeList shapeList) {
        this.startPoint = startPoint;
        this.endPoint = endPoint;
        this.applicationState = applicationState;
        this.paintCanvas = paintCanvas;
        this.shapeList = shapeList;
    }

//    @Override
    public void execute() {
//
//        for (IShape shape : shapeList.getShapeList(newShape)) {
//            paintCanvas.update();
//            System.out.println("selected command " + newShape.getStartPoint() + newShape.getEndPoint());
//
//            //Graphics2D g = paintCanvas.getGraphics2D();
//
//            // if there is one click
//            if (startPoint != null) {
//                System.out.println("1 click select");
//
//                // if the click contains a shape
//                if (shape.containsPoint(startPoint.x, startPoint.y)) {
//                    shapeList.addSelectedShape(shape);
//                }
//            }
//
//            // if there are 2 clicks
//            else if (!startPoint.equals(endPoint)){
//                System.out.println("2 clicks select");
//
//                // if the bounding box contains any shapes
//                if (shape.containsPoint(startPoint.x, startPoint.y) || shape.containsPoint(endPoint.x, endPoint.y)) {
//                    shapeList.addSelectedShape(shape);
//                }
//            }
//            return;
//        }
//        shapeList.getSelectedList();
    }

    @Override
    public void undo() {
        // nothing
    }

    @Override
    public void redo() {
        // nothing
    }
}

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
        //this.startPoint = startPoint;
        //this.endPoint = endPoint;
        //this.applicationState = applicationState;
        this.shapeParams = shapeParams;
        this.paintCanvas = paintCanvas;
        this.shapeList = shapeList;
    }

    @Override
    public void execute() {
        //shapeList.removeAllSelectedShapes();
        System.out.println("print 1");

        for (IShape shape : shapeList.getShapeList()) {
            paintCanvas.update();
            // define X and Y for shape i
            //start = shape.getStartPoint();
            //stop = shape.getEndPoint();

            //System.out.println("selected shape list : " + shapeList.getShapeList());
            System.out.println("print for loop");
            // System.out.println("selected command " + newShape.getStartPoint() + newShape.getEndPoint());

            if (shape.checkCoordinates(startPoint, endPoint)) {
                System.out.println("print if 1");
                shapeList.addSelectedShape(shape);

//                if(!shapeList.getSelectedList().contains(shape)){
//                    System.out.println("print if 2");
//                    //shapeList.addSelectedShape(shape);
//                }
            }
            paintCanvas.update();
            System.out.println("selected shape list : " + selectedList.getSelectedList());
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
    }
}

package model.commands;

import model.interfaces.IShape;
import model.persistence.ApplicationState;
import model.shapes.Point;
import model.shapes.ShapeList;
import model.shapes.ShapeParams;
import view.gui.PaintCanvas;

import java.util.ArrayList;

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

                if(!shape.getShapeGroup().isEmpty()){
                    groupSelectedShape(shapeList.getShapeList(),shape);
                }

            }
            paintCanvas.update();
            //System.out.println("selected shape list : " + shapeList.getSelectedList());
        }
    }

    private void groupSelectedShape(ArrayList<IShape> arrayList, IShape shape){
        GroupCommand groupCommand = shape.getShapeGroup().get(shape.getShapeGroup().size()-1);

        for(IShape shape1: arrayList){

            if(!shape1.getShapeGroup().isEmpty()){
                GroupCommand groupCommand1 = shape1.getShapeGroup().get(shape1.getShapeGroup().size()-1);

                if(groupCommand1.equals(groupCommand)){

                    if(!shapeList.getSelectedList().contains(shape1)){
                        shapeList.addSelectedShape(shape1);
                    }

                }
            }
        }
    }
}

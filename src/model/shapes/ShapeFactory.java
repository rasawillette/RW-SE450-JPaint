package model.shapes;

import model.interfaces.IShape;
import model.persistence.ApplicationState;


public class ShapeFactory {

    ApplicationState applicationState;
    ShapeType shape;
    private ShapeFactory(){};

    //use getShape to get the object
    public static IShape getShape(ShapeParams shapeParams) {

        IShape shape = null;
        ShapeType shapeType = shapeParams.getShapeType();
        System.out.println("print shape type: " + shapeType);

        if (shapeType == null) {
            return null;
        }

        if (shapeParams.getShapeType().equals(ShapeType.RECTANGLE)) {
            shape = new Rectangle(shapeParams);
        }

        if (shapeParams.getShapeType().equals(ShapeType.TRIANGLE)) {
            shape = new Triangle(shapeParams);
        }

        if (shapeParams.getShapeType().equals(ShapeType.ELLIPSE)) {
            shape = new Ellipse(shapeParams);
        }

        return shape;

//
//            switch (shapeType){
//
//                case RECTANGLE:
//                    shape = new Rectangle(shapeParams, applicationState);
//                    return shape;
//
//                case ELLIPSE:
//                    shape = new Ellipse(startPoint, endPoint, applicationState);
//                    return shape;
//
//                case TRIANGLE:
//                    shape = new Triangle(startPoint, endPoint, applicationState);
//                    return shape;
//            }
    //
        // }
        /*
        switch (shapeType){

            case RECTANGLE:
                shape = new Rectangle(startPoint, endPoint, applicationState);
                return shape;

            case ELLIPSE:
                shape = new Ellipse(startPoint, endPoint, applicationState);
                return shape;

            case TRIANGLE:
                shape = new Triangle(startPoint, endPoint, applicationState);
                return shape;
        }
        */

        //return shape;
    //}




    /*
    private IShape createShape(Graphics2D graphics2d){

        if (applicationState.getActiveShapeType() == ShapeType.RECTANGLE) {
            System.out.println("draw triangle " + applicationState.getStart() + applicationState.getStop());
            shape = new Rectangle(Graphics2D graphics2d);
        }

        else if (applicationState.getActiveShapeType() == ShapeType.TRIANGLE){
            shape = new Ellipses(Graphics2D graphics2d);
        }

        else if (applicationState.getActiveShapeType() == ShapeType.ELLIPSE) {
            shape = new Triangle(Graphics2D graphics2d);
        }

        return shape;
    }

     */
    }
}


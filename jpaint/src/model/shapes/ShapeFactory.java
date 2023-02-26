package model.shapes;

import model.interfaces.IShape;
import model.persistence.ApplicationState;


public class ShapeFactory {

    ApplicationState applicationState;
    ShapeType shape;
    public ShapeFactory(){};

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
    }
}


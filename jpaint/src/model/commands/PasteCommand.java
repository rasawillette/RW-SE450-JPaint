package model.commands;

import model.interfaces.IApplicationState;
import model.interfaces.IShape;
import model.shapes.ShapeFactory;
import model.shapes.ShapeList;
import model.shapes.ShapeParams;
import view.gui.PaintCanvas;

import java.util.ArrayList;

public class PasteCommand implements ICommand, IUndoable{

    ShapeList shapeList;
    PaintCanvas paintCanvas;
    IApplicationState  applicationState;

    IShape temp_shape;
    ArrayList<IShape> tempShapeList;
    IShape new_shape;
    ShapeParams pastedShape;
    ShapeParams temp_params;


    public PasteCommand(ShapeList shapeList, PaintCanvas paintCanvas, IApplicationState applicationState) {
        this.shapeList = shapeList;
        this.paintCanvas = paintCanvas;
        this.applicationState = applicationState;
        tempShapeList = new ArrayList<IShape>();
    }

    @Override
    public void execute() {

        for (IShape shape: shapeList.getCopiedList()) {
            temp_shape = shape;
            temp_params = shape.getShapeParams();
            pastedShape = new ShapeParams();

            // set all same parameters to the pasted shape
            pastedShape.setStartPoint(temp_params.getStartPoint());
            pastedShape.setEndPoint(temp_params.getEndPoint());

            pastedShape.setHeight(temp_params.getHeight());
            pastedShape.setWidth(temp_params.getWidth());

            pastedShape.setShapeType(temp_params.getShapeType());
            pastedShape.setShadingType(temp_params.getShadingType());

            pastedShape.setPrimaryColor(temp_params.getPrimaryColor());
            pastedShape.setSecondaryColor(temp_params.getSecondaryColor());

            // draw pasted shape with an offset from the one before it
            pastedShape.pasteWithOffset();

            DrawShapeCommand drawShapeCommand = new DrawShapeCommand(pastedShape, paintCanvas, shapeList);
            IShape new_shape = drawShapeCommand.shapeFactory.getShape(pastedShape);

            tempShapeList.add(new_shape);
        }

        for (IShape shape: tempShapeList) {
            shapeList.addShape(shape);
        }

        CommandHistory.add(this);
        paintCanvas.update();
    }

    @Override
    public void undo() {
        for (IShape shape: tempShapeList) {
            shapeList.removeShape(shape);
            shape.getShapeParams().declineX();
        }
        paintCanvas.update();
    }

    @Override
    public void redo() {
        for (IShape shape: tempShapeList) {
            shapeList.addShape(shape);
            shape.getShapeParams().inclineX();
        }
        paintCanvas.update();

    }
}

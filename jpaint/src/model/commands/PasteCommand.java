package model.commands;

import model.interfaces.IApplicationState;
import model.shapes.ShapeList;
import view.gui.PaintCanvas;

public class PasteCommand implements ICommand{

    ShapeList shapeList;
    PaintCanvas paintCanvas;
    IApplicationState  applicationState;

    public PasteCommand(ShapeList shapeList, PaintCanvas paintCanvas, IApplicationState applicationState) {
        this.shapeList = shapeList;
        this.paintCanvas = paintCanvas;
        this.applicationState = applicationState;
    }

    @Override
    public void execute() {

    }
}

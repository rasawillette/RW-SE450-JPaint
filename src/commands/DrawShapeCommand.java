package commands;

import model.ShapesList;
import model.interfaces.IApplicationState;
import view.gui.PaintCanvas;

public abstract class DrawShapeCommand implements ICommand, IUndoable {

    private PaintCanvas paintCanvas;
    private ShapesList shapesList;
    private IApplicationState applicationState;
}

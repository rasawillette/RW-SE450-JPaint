package model.interfaces;

import model.shapes.ShapeList;
import model.shapes.ShapeParams;
import view.gui.PaintCanvas;

public interface IMouseState {

    void execute(PaintCanvas paintCanvas, ShapeParams shapeParameters,  ShapeList shapeList);
}

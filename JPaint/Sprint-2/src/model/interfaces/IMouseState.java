package model.interfaces;

import model.persistence.ApplicationState;
import model.shapes.Point;
import model.shapes.ShapeList;
import view.gui.PaintCanvas;

public interface IMouseState {

    void execute(Point startPoint, Point endPoint, ApplicationState applicationState, PaintCanvas paintCanvas, ShapeList shapeList);
}

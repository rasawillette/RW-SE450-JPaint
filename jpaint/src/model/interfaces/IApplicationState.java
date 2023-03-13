package model.interfaces;

import model.shapes.*;
import model.MouseMode;

public interface IApplicationState {
    void setActiveShape();

    void setActivePrimaryColor();

    void setActiveSecondaryColor();

    void setActiveShadingType();

    void setActiveStartAndEndPointMode();

    ShapeType getActiveShapeType();

    ShapeColor getActivePrimaryColor();

    ShapeColor getActiveSecondaryColor();

    ShapeShadingType getActiveShapeShadingType();

    MouseMode getActiveMouseMode();

    void setStart(Point start);
    void setStop(Point stop);
    Point getStart();
    Point getStop();

    void setActiveExtraCredit();

    ExtraCredit getActiveExtraCredit();
}

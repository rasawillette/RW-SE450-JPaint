package model.persistence;

import model.shapes.*;
import controller.Component;
import model.MouseMode;
import model.dialogs.DialogProvider;
import model.interfaces.IApplicationState;
import model.interfaces.IDialogProvider;
import view.interfaces.IUiModule;

public class ApplicationState implements IApplicationState {
    //instance variables
    private final IUiModule uiModule;
    private final IDialogProvider dialogProvider;

    private ShapeType activeShapeType;
    private ShapeColor activePrimaryColor;
    private ShapeColor activeSecondaryColor;
    private ShapeShadingType activeShapeShadingType;
    private MouseMode activeMouseMode;

    private Point start;
    private Point stop;

    private ExtraCredit activeExtraCredit;

    //constructor
    public ApplicationState(IUiModule uiModule) {
        this.uiModule = uiModule;
        this.dialogProvider = new DialogProvider(this);
        setDefaults();
    }

    //member functions
    @Override
    public void setActiveShape() {
        activeShapeType = uiModule.getDialogResponse(dialogProvider.getChooseShapeDialog());
        System.out.println("application state " + activeShapeType );
        Component.activeShapeType = activeShapeType;
    }

    @Override
    public void setActivePrimaryColor() {
        activePrimaryColor = uiModule.getDialogResponse(dialogProvider.getChoosePrimaryColorDialog());
        Component.activePrimaryColor = activePrimaryColor;
    }

    @Override
    public void setActiveSecondaryColor() {
        activeSecondaryColor = uiModule.getDialogResponse(dialogProvider.getChooseSecondaryColorDialog());
        Component.activeSecondaryColor = activeSecondaryColor;
    }

    @Override
    public void setActiveShadingType() {
        activeShapeShadingType = uiModule.getDialogResponse(dialogProvider.getChooseShadingTypeDialog());
        Component.activeShapeShadingType = activeShapeShadingType;
    }

    @Override
    public void setActiveStartAndEndPointMode() {
        System.out.println("set active start and end point mode");
        activeMouseMode = uiModule.getDialogResponse(dialogProvider.getChooseStartAndEndPointModeDialog());
    }

    @Override
    public ShapeType getActiveShapeType() {
        return activeShapeType;
    }

    @Override
    public ShapeColor getActivePrimaryColor() {
        return activePrimaryColor;
    }

    @Override
    public ShapeColor getActiveSecondaryColor() {
        return activeSecondaryColor;
    }

    @Override
    public ShapeShadingType getActiveShapeShadingType() {
        return activeShapeShadingType;
    }

    @Override
    public MouseMode getActiveMouseMode() {
        return activeMouseMode;
    }

    private void setDefaults() {
        activeShapeType = ShapeType.RECTANGLE;
        activePrimaryColor = ShapeColor.BLUE;
        activeSecondaryColor = ShapeColor.GREEN;
        activeShapeShadingType = ShapeShadingType.FILLED_IN;
        activeMouseMode = MouseMode.DRAW;
    }

    @Override
    public void setStart(Point start) {
        this.start = start;
    }
    @Override
    public void setStop(Point stop) {
        this.stop = stop;
    }
    @Override
    public Point getStart() {
        return start;
    }
    @Override
    public Point getStop() {
        return stop;
    }

    @Override
    public void setActiveExtraCredit() {
        activeExtraCredit = uiModule.getDialogResponse(dialogProvider.getChooseExtraCredit());
        Component.activeExtraCredit = activeExtraCredit;
    }

    @Override
    public ExtraCredit getActiveExtraCredit() {
        return activeExtraCredit;
    }
}

package controller;

import model.commands.*;
import model.interfaces.IApplicationState;
import model.shapes.ShapeList;
import view.EventName;
import view.gui.PaintCanvas;
import view.interfaces.IUiModule;

import javax.swing.*;


public class JPaintController implements IJPaintController {
    //instance variables
    private final IUiModule uiModule; //view
    private final IApplicationState applicationState; //model

    ShapeList shapeList;
    PaintCanvas paintCanvas;

    //constructor
    public JPaintController(IUiModule uiModule, IApplicationState applicationState,ShapeList shapeList, PaintCanvas paintCanvas) {
        this.uiModule = uiModule;
        this.applicationState = applicationState;
        this.shapeList = shapeList;
        this.paintCanvas = paintCanvas;
    }

    @Override
    public void setup() {
        setupEvents();
    }

    private void setupEvents() {
        uiModule.addEvent(EventName.CHOOSE_SHAPE, () -> applicationState.setActiveShape());
        uiModule.addEvent(EventName.CHOOSE_PRIMARY_COLOR, () -> applicationState.setActivePrimaryColor());
        uiModule.addEvent(EventName.CHOOSE_SECONDARY_COLOR, () -> applicationState.setActiveSecondaryColor());
        uiModule.addEvent(EventName.CHOOSE_SHADING_TYPE, () -> applicationState.setActiveShadingType());
        uiModule.addEvent(EventName.CHOOSE_MOUSE_MODE, () -> applicationState.setActiveStartAndEndPointMode());

        uiModule.addEvent(EventName.UNDO, () -> new UndoCommand().execute());
        uiModule.addEvent(EventName.REDO, () -> new RedoCommand().execute());

        uiModule.addEvent(EventName.COPY, () -> new CopyCommand(shapeList).execute());
        uiModule.addEvent(EventName.PASTE, () -> new PasteCommand(shapeList, paintCanvas, applicationState).execute());
        uiModule.addEvent(EventName.DELETE, () -> new DeleteCommand(shapeList, paintCanvas).execute());

        uiModule.addEvent(EventName.GROUP, () -> new GroupCommand(shapeList,paintCanvas));
        uiModule.addEvent(EventName.UNGROUP, () -> new UngroupCommand(shapeList,paintCanvas));
    }
}

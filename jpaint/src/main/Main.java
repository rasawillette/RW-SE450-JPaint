package main;

import controller.IJPaintController;
import controller.JPaintController;
import model.persistence.ApplicationState;
import model.persistence.MouseHandler;
import model.shapes.ShapeList;
import view.gui.Gui;
import view.gui.GuiWindow;
import view.gui.PaintCanvas;
import view.interfaces.IGuiWindow;
import view.interfaces.IUiModule;


public class Main {
    public static void main(String[] args){

        ShapeList shapeList = new ShapeList();
        PaintCanvas paintCanvas = new PaintCanvas(shapeList);
        IGuiWindow guiWindow = new GuiWindow(paintCanvas);
        IUiModule uiModule = new Gui(guiWindow);

        ApplicationState applicationState = new ApplicationState(uiModule);

        MouseHandler mouseHandler = new MouseHandler(applicationState, paintCanvas, shapeList);
        paintCanvas.addMouseListener(mouseHandler);

        paintCanvas.addState(applicationState);
        mouseHandler.addState(applicationState);
        IJPaintController controller = new JPaintController(uiModule, applicationState);

        controller.setup();
    }
}

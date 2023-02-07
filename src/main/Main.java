package main;

import controller.IJPaintController;
import controller.JPaintController;
import model.persistence.ApplicationState;
import model.persistence.MouseHandler;
import view.gui.Gui;
import view.gui.GuiWindow;
import view.gui.PaintCanvas;
import view.interfaces.IGuiWindow;
import view.interfaces.IUiModule;


public class Main {
    public static void main(String[] args){
        PaintCanvas paintCanvas = new PaintCanvas();
        MouseHandler mouseHandler = new MouseHandler();
        paintCanvas.addMouseListener(mouseHandler);
        //ShapeList shapeList = new ShapeList();

        IGuiWindow guiWindow = new GuiWindow(paintCanvas);
        IUiModule uiModule = new Gui(guiWindow);

        ApplicationState appState = new ApplicationState(uiModule);
        paintCanvas.addState(appState);
        mouseHandler.addState(appState);
        IJPaintController controller = new JPaintController(uiModule, appState);

        controller.setup();
    }
}

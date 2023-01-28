package main;

import controller.ClickHandler;
import controller.IJPaintController;
import controller.JPaintController;
import model.persistence.ApplicationState;
import view.gui.Gui;
import view.gui.GuiWindow;
import view.gui.PaintCanvas;
import view.interfaces.IGuiWindow;
import view.interfaces.IUiModule;

public class Main {
    public static void main(String[] args){
        PaintCanvas paintCanvas = new PaintCanvas();
        ClickHandler clickHandler = new ClickHandler();
        paintCanvas.addMouseListener(clickHandler);

        IGuiWindow guiWindow = new GuiWindow(paintCanvas);
        IUiModule uiModule = new Gui(guiWindow);

        ApplicationState appState = new ApplicationState(uiModule);
        paintCanvas.addState(appState);
        clickHandler.addState(appState);
        IJPaintController controller = new JPaintController(uiModule, appState);

        controller.setup();
    }
}

package view.gui;

import model.interfaces.IShape;
import model.persistence.ApplicationState;
import view.interfaces.IPaintCanvas;

import javax.swing.*;
import java.awt.*;

public class PaintCanvas extends JComponent implements IPaintCanvas {

    IShape shape;
    @Override
    public void paint(Graphics g) {
        Graphics2D graphics2d = (Graphics2D) g;
    }

    public Graphics2D getGraphics2D() {
        return (Graphics2D)getGraphics();
    }

    ApplicationState applicationState;

    public void addState(ApplicationState applicationState) {
        this.applicationState = applicationState;
    }

    public void update(){
        System.out.println("update in paint canvas");
        repaint();
    }

}

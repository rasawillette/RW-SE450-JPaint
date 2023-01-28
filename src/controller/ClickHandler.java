package controller;

import model.interfaces.IApplicationState;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

// override 2 methods
public class ClickHandler implements MouseListener {

    public ClickPoint startClickPoint;
    public ClickPoint endClickPoint;

    //IGuiWindow guiWindow;
    IApplicationState applicationState;


    @Override
    public void mouseClicked(MouseEvent e) {

    }

    // mouse pressed
    @Override
    public void mousePressed(MouseEvent e) {
        startClickPoint = new ClickPoint();
        startClickPoint.x = e.getX();
        startClickPoint.y = e.getY();
        applicationState.setStart(startClickPoint);
        System.out.println("mouse pressed" + startClickPoint.x + " " + startClickPoint.y);
    }

    // mouse released
    @Override
    public void mouseReleased(MouseEvent e) {

        endClickPoint = new ClickPoint();
        endClickPoint.x = e.getX();
        endClickPoint.y = e.getY();
        applicationState.setStop(endClickPoint);

        // calculate height
        int height = endClickPoint.y- startClickPoint.y;
        // calculate width
        int width = endClickPoint.x- startClickPoint.x;

        System.out.println("mouse pressed" + height + " " + width);
        e.getComponent().repaint();
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    public void addState(IApplicationState applicationState) {
        this.applicationState = applicationState;
    }
}


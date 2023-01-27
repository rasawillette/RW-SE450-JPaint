package controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

// override 2 methods
public class ClickHandler extends MouseAdapter {

    Point startPoint;
    Point endPoint;

    // mouse pressed
    private void MousePressed(MouseEvent e) {
        startPoint = new Point();
        startPoint.x = e.getX();
        startPoint.y = e.getY();

    }

    // mouse released
    private void MouseReleased(MouseEvent e) {

        endPoint = new Point();
        endPoint.x = e.getX();
        endPoint.y = e.getY();

        // calculate height
        int height = endPoint.y-startPoint.y;
        // calculate width
        int width = endPoint.x- startPoint.x;

    }

}

class Point {
    public int x;
    public int y;
}
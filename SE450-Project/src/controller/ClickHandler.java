package controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

// override 2 methods
public class ClickHandler extends MouseAdapter {

    Point startPoint;

    // mouse pressed
    private void MousePressed(MouseEvent e) {
        startPoint = new Point();
        startPoint.x = e.getX();
        startPoint.y = e.getY();

        // create own point class with integers

    }

    // mouse released
    private void MouseReleased(MouseEvent e) {

        // calculate height

        // calculate width

    }

}

class Point {
    public int x;
    public int y;
}
package model.shapes;

import model.interfaces.IShape;

public class BoundingBox {
    int startX;
    int endX;

    int startY;
    int endY;

    int width;
    int height;

    Point start;
    Point end;

    ShapeList shapeList;
    IShape shape;

    public BoundingBox(Point start, Point end, int width, int height) {
        this.startX = start.x;
        this.startY = start.y;

        this.endX = end.x;
        this.endY = end.y;

        this.width = width;
        this.height = height;

        this.start = start;
        this.end = end;
    }

    // using this tutorial for reference for collision detection
    // https://happycoding.io/tutorials/processing/collision-detection
    public void selectContains() {

            // if there is one click
            if (start.equals(end)) {
                System.out.println("1 click select");

                // if the click point is inside the rectangle
                if(start.x > startX && end.x < endX + width && start.y > startY && end.y < endY + height){

                    // add shape to selected shapes list
                    shapeList.addSelectedShape(shape);
                }
            }

            // if there are 2 clicks
            if (!start.equals(end)){
                System.out.println("2 clicks select");

                // if the bounding box contains any shapes
                //if (shape.containsPoint(startPoint.x, startPoint.y) || shape.containsPoint(endPoint.x, endPoint.y)) {
                //    shapeList.addSelectedShape(shape);
                //}

                // evaluates to true if rectOne and rectTwo are colliding
                // if (rectOneRight > rectTwoLeft && rectOneLeft < rectTwoRight && rectOneBottom > rectTwoTop && rectOneTop < rectTwoBottom){
            }

    }

}

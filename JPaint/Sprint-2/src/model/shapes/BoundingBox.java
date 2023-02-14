package model.shapes;

public class BoundingBox {
    Point start;
    Point end;

    int width;
    int height;

    public BoundingBox(Point start, Point end, int width, int height) {
        this.start.x = start.x;
        this.start.y = start.y;

        this.end.x = end.x;
        this.end.y = end.y;

        this.width = width;
        this.height = height;
    }

}

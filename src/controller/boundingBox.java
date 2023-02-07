package controller;

public class boundingBox {
    int x;
    int y;

    int width;
    int height;

    public boundingBox(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public boolean isColliding(boundingBox other) {
        return (x < other.x + other.width && x + width > other.x &&
                y < other.y + other.height && y + height > other.y);
    }
}

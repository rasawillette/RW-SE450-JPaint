package model.shapes;

public class ShapeParams {

    int height,width;

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public Point startPoint;
    public Point endPoint;

    public Point getStartPoint() {
        return startPoint;
    }

    public void setStartPoint(Point startPoint) {
        this.startPoint = startPoint;
    }

    public Point getEndPoint() {
        return endPoint;
    }

    public void setEndPoint(Point endPoint) {
        this.endPoint = endPoint;
    }

    ShapeColor primaryColor;

    public ShapeColor getPrimaryColor() {
        return primaryColor;
    }

    public void setPrimaryColor(ShapeColor primaryColor) {
        this.primaryColor = primaryColor;
    }

    ShapeColor secondaryColor;

    public ShapeColor getSecondaryColor() {
        return secondaryColor;
    }

    public void setSecondaryColor(ShapeColor secondaryColor) {
        this.secondaryColor = secondaryColor;
    }

    ShapeType shapeType;

    public ShapeType getShapeType(){
        return shapeType;
    }

    public void setShapeType(ShapeType shapeType){
        this.shapeType = shapeType;
    }

    ShapeShadingType shadingType;

    public ShapeShadingType getShadingType() {
        return shadingType;
    }

    public void setShadingType(ShapeShadingType shadingType) {
        this.shadingType = shadingType;
    }


    // for pasting undo and redo
    int x = 1;

    public void inclineX(){
        x = x+1;
    }

    public void declineX(){
        x = x-1;
    }


    public void pasteWithOffset(){
        startPoint.setX(startPoint.getX()+(x*50));
        startPoint.setY(startPoint.getY()+(x*50));
        endPoint.setY(endPoint.getY()+(x*50));
        endPoint.setX(endPoint.getX()+(x*50));
        x = x+1;
    }

}

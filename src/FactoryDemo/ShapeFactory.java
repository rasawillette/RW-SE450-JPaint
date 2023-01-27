package FactoryDemo;

public class ShapeFactory {
    private ShapeFactory(){}

    public static IShape createCircle(String name){
        return new Circle(1, name);
    }

    public static IShape createTriangle(){
        return new Triangle(3, true);
    }

    public static IShape createRectangle(){
        return new Rectangle(4);
    }

    public static IShape createSquare(){
        return new Rectangle(4);
    }
}

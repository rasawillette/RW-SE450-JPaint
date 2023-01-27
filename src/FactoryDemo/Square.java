package FactoryDemo;

public class Square extends Shape{
    public Square(int numSides) {
        super(numSides);
    }

    @Override
    public String getString() {
        return "Square";
    }
}

package view.gui;

import FactoryDemo.Shape;

class Triangle extends Shape {

    private boolean isEquilateral;
    public Triangle(int numSides, boolean isEquilateral){
        super(numSides);
        this.isEquilateral = isEquilateral;
    }

    @Override
    public String getString() {
        return "Triangle";
    }
}

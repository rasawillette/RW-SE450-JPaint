package view.gui;

import FactoryDemo.Shape;

class Ellipses extends Shape {
	String name;
	public Ellipses(int numSides, String name) {
		super(numSides);
		this.name = name;
	}

	public String getString(){
		return "Circle";	
	}
}

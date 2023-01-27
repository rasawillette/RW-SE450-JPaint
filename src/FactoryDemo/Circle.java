package FactoryDemo;

class Circle extends Shape {
	String name;
	public Circle(int numSides, String name) {
		super(numSides);
		this.name = name;
	}

	public String getString(){
		return "Circle";	
	}
}

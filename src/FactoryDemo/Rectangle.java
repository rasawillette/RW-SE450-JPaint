package FactoryDemo;

class Rectangle extends Shape {
	public Rectangle(int numSides) {
		super(numSides);
	}

	public String getString(){
		return "Rectangle";	
	}
}

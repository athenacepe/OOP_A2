package q3;

public class Rectangle extends Shape {
	private double height;
	private double width;
	
	public Rectangle(String colour, double height, double width) {
		super(colour);
		this.setHeight(height);
		this.setWidth(width);
	}
// -----------------------------------------------------------	
	@Override 
	public String getShapeName() {
		return "I'm a Rectangle \n";
	}
	
	public double getPerimeter() {
		double perimeter = 2 * (height + width);
		return perimeter;
	}
	
// ----------------------------------------------------------	
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	public double getWidth() {
		return width;
	}
	public void setWidth(double width) {
		this.width = width;
	}
	
}
package q3;

public class Shape {
	private String colour;

public Shape(String colour) {
		this.setColour(colour);
	}
	
	public String getShapeName() {
		return "I'm a Shape \n";
	}

	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}
}
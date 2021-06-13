/**
 * Name: Athena Cepe
 * Student ID: 18470716
 * Pledge of honour: I pledge by honour that this program is solely my own work.
 */
package q3;

import java.util.*;
import static java.lang.System.out;
import q3.Shape;

public class Main {

	public static void main(String[] args) {
		List<Shape> shapes = new LinkedList<>();
		 shapes.add(new Shape("white"));
		 shapes.add(new Rectangle("red", 10, 6));
		 shapes.add(new Rectangle("black", 20, 9));
		 shapes.add(new Shape("orange"));
		 showShapeNames(shapes);//produces output part 1

		 Rectangle[] rectangleArray1 = {
		 new Rectangle("white", 4, 3),
		 new Rectangle("red", 9, 5),
		 new Rectangle("purple", 3, 6),
		 new Rectangle("orange", 15, 10),
		 new Rectangle("black", 4, 14),
		 };
		 Rectangle[] rectangleArray2 = {
		 new Rectangle("pink", 3, 4),
		 new Rectangle("red", 10, 2),
		 new Rectangle("white", 8, 5),
		 new Rectangle("blue", 14, 4),
		 new Rectangle("bindle", 10, 15),
		 };
		 //produces output part 2
		 countOverlapRectangles(rectangleArray1, rectangleArray2);
	 }
	

	public static void showShapeNames(List<Shape> shapes){
		for(Shape sh : shapes) {
			out.printf(sh.getShapeName());
		}
	 }
	
	public static void countOverlapRectangles(Rectangle[] group1, Rectangle[] group2) {
		
		int count1 = 0;
		for(Rectangle col1 : group1) { 
			for(Rectangle col2 : group2) {
				if(col1.getColour().equalsIgnoreCase(col2.getColour())) { 
					//retrieve colors of both arrays and compare each other if they are the same
					//for every same colour this will be added to count1
					count1++;	
				}
			}
		}
		out.printf("There are %d Rectangle objects with overlapping colour between the two arrays. \n", count1);
		 
		int count2 = 0;
		for(Rectangle per1 : group1) { 
			for(Rectangle per2 : group2) {
				//retrieve perimeters of both arrays and compare each other if they are the same
				//for every same perimeter this will be added to count2
				if(per1.getPerimeter() == per2.getPerimeter()) {
					count2++;	
				}
			}
		}
		out.printf("There are %d Rectangle objects with overlapping perimeter between the two arrays. \n", count2);
}
}
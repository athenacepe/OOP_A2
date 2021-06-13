/**
 * Name: Athena Cepe
 * Student ID: 18470716
 * Pledge of honour: I pledge by honour that this program is solely my own work.
 */
package q5;
import static java.lang.System.out;

import java.io.IOException;
import java.util.List;
public class Main {

	public static void main(String[] args) {
		String txtfile = "data/data.txt";
		try {
			SalaryApp salaryapp = new SalaryApp(txtfile);
			salaryapp.printAll();
			out.println();
			out.printf("Max salary: %.2f\n", salaryapp.getMaxSalary());
			out.printf("Min salary employee ID: %s\n", salaryapp.getMinSalaryID());
			salaryapp.promoteSalary();
			out.println("\n=======After salary promotion=====\n");
			salaryapp.printAll();
			out.println();
			double total = recursiveTotalSalary(salaryapp.getPeople(), 0);
			out.printf("Total salary: %.2f\n", total);
		}catch(IOException ioe) {
			out.printf("Perhaps missing text file: %s/%s? \n\n", new Main().getClass().getPackage().getName(), txtfile);
		}
	}
	
	public static double recursiveTotalSalary(List<Employee> list, double accum) {
		if(list != null && list.size() > 0) { //checks if the list empty
			List<Employee> subList = list.subList(1, list.size()); // creates a sublist without the first object
			return recursiveTotalSalary(subList, accum + list.get(0).getSalary()); //calls itself(recursion) and adds the 1st object Salary to the accumulator
		}
		else {
			return accum;
		}
	}
}//End of class Main
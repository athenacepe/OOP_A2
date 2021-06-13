package q5;
import static java.lang.System.*;

public class Employee {
	private String id;
	private double salary;

	public Employee(String ID, double salary) {
		this.setId(ID);
		this.setSalary(salary);
	}
	
	public void displayEmployee() {
		out.printf("ID: %s, /n Salary: %.2f", id, salary);
	}
	
	
// GETTERS AND SETTERS FOR ID AND SALARY
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
}
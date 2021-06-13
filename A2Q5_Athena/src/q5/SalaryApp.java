package q5;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import static java.lang.System.out;

public class SalaryApp{

	private List<Employee> people;

	public List<Employee> getPeople() {
		return people; 
	}

	public SalaryApp(String filename) throws IOException {
		people = new LinkedList<>();
		readData(filename);
	}

	public void readData(String fn) throws IOException {
		Path path = new File(fn).toPath();
		List<String> content = Files.readAllLines(path); //reads all lines in the file

		//for loop to retrieve the content of the file
		for(String line : content) {
			String[] items = line.split(","); // the contents will be stored in this array 'Items'
			Employee e = new Employee(items[0], Double.valueOf(items[1])); // stores the objects in the items array into the list 
			people.add(e);
		}	
	}

	public void printAll() {
		String fmt = "%-10s%-1s\n";
		out.printf(fmt, "ID", "Salary");
		out.print("------------------\n");
		for(Employee e : people) {
			out.printf("%5s%13.2f\n", e.getId(), e.getSalary()); //displays the id and salary that are in the list
		}
	}

	public double getMaxSalary() {
		if(people != null && people.size() > 0) { //checks if the list is empty
			double max = 0;
			for (Employee e : people) {
				//retrieves the salary and compares if it is greater than max
				//this will keep repeating for every element in the list 
				//if it is greater then max the salary will be set as the max
				//in the loop, if another object is greater it will replace the existing max and become the new max
				if(e.getSalary()> max) 
					max = e.getSalary();
			}
			return (double)max;
		}
		return 0;
	}

	public String getMinSalaryID() {
		if(people != null && people.size() > 0) { //checks if the list is empty
			Employee cp = people.get(0); //retrieves the first person's id and salary 
			for (Employee e : people) {
				if(e.getSalary() < cp.getSalary()) {    //goes through the list and compares if it is less than the first person's salary
					cp = e; //if in comparison the salary of the next person on the list's salary is less than the first person's their salary will be the new value of cp
				}}
			return cp.getId(); //returns the id of the person with the lowest salary
		}
		return "";
	}


	public void promoteSalary() {
		if(people != null && people.size() > 0) { //checks if the list is empty
			for(Employee e : people) {
				e.setSalary(e.getSalary() + 2000); //sets the new salary (adds $2000)
				if(e.getSalary() > 100000) { //If the employee is getting more than 100000
					e.setSalary(100000); //This sets the employee's salary fixed to 100000 if they surpass 100000 after getting a raise
	}}}}}
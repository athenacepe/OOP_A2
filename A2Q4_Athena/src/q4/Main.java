/**
 * Name: Athena Cepe
 * Student ID: 18470716
 * Pledge of honour: I pledge by honour that this program is solely my own work.
 */

package q4;
import static java.lang.System.out;
import java.util.*;

public class Main {
	 public static void main(String[] args) {
	 List<Book> books = new LinkedList<>();
	 Book b1 = new Book("book 1", 303);
	 Book b2 = new Book("book 2", 200);
	 Book b3 = new Book("book 3", 399);
	 books.add(b1);
	 books.add(b2);
	 books.add(b3);
	 
	 BookApp bkapp = new BookApp();
	 int totalPages = bkapp.calcTotalPages(books, 0); //calls the calcTotalPages() method
	 out.printf("Total number of books: %d\n", books.size()); //output is the size of the list
	 out.printf("Total pages: %d\n", totalPages); //total number of pages of all the books
	 }
}//end of Main class



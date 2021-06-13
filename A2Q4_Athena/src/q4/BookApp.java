package q4;
import java.util.List;
import q4.Book;

public class BookApp {

	public int calcTotalPages(List<Book> bookList, int accum) {
		if(bookList != null && bookList.size() > 0) { //checks is the list is empty
			List<Book> subList = bookList.subList(1, bookList.size()); //creates a sublist and removes the first object in the booklist
			return calcTotalPages(subList, accum + bookList.get(0).getNumOfPages()); //returns to itself(recursion) and adds the 1st object to the accumulator
		}
		else {
			return accum; //when the recursion has gone through the list, it returns the accumulator
		}
	}
}

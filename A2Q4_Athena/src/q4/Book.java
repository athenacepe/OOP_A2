package q4;

public class Book {
	private String title;
	private int numOfPages;
	
public Book(String title, int numOfPages) {
	this.setTitle(title);
	this.setNumOfPages(numOfPages);
}
	
// GETTERS AND SETTERS FOR TITLE AND NUM OF PAGES
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getNumOfPages() {
		return numOfPages;
	}
	public void setNumOfPages(int numOfPages) {
		this.numOfPages = numOfPages;
	}
}

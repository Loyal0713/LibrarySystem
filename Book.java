package hw2;

/**
 * Class that represents a book and inherits the media
 * class
 * 
 * @author brown8jt - Josh Brown
 *
 */

public class Book extends Media {

	private int numPages;

	/**
	 * Constructor used to instantiate a book object
	 * @param id
	 * @param isAvailable
	 */
	public Book(int id, boolean isAvailable) {
		super(id, isAvailable);
		this.numPages = (int)(100 + Math.random() * 100);
	}

	/**
	 * Returns the number of pages in book
	 * @return numPages - Integer representing the number of pages in book
	 */
	public int getNumPages() {
		return this.numPages;
	}

	/**
	 * Returns all book information in a friendly way
	 * @return String - Returns a string printing the book information in a user-friendly
	 * way
	 */
	public String toString() {
		return "Book id: " + this.getId() + "\nBook availability: " + this.isAvailable() + "\nNumber of pages: "
				+ this.numPages + "\n";
	}

}

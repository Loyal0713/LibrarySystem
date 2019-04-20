package hw2;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Class representing an individual who will check out/return books
 * @author brown8jt - Josh Brown
 *
 */
public class Borrower {

	private int id;
	private String name;
	private BigDecimal fine;
	private List<Media> checkOut;

	/**
	 * Constructor that uses an integer id and name to instantiate a new borrower
	 * @param id
	 * @param name
	 */
	public Borrower(int id, String name) {
		this.id = id;
		this.name = name;
		this.fine = new BigDecimal("0.00");
		this.checkOut = new ArrayList<Media>();
	}

	/**
	 * Adds media to the borrower's checked out list
	 * @param m
	 */
	public void addToCheckedOut(Media m) {
		checkOut.add(m);
	}
	

	/**
	 * Returns the borrower's checked out media list
	 * @return Returns media list
	 */
	List<Media> getCheckedOutMedia() {
		return this.checkOut;
	}

	/**
	 * Returns the unique borrower id
	 * @return Returns integer representing an id
	 */
	public int getId() {
		return this.id;
	}

	/**
	 * Returns name of the borrower
	 * @return Returns string representing a name
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Returns the amount in fines the borrower owes
	 * @return Returns BigDecimal representing the amount of fines
	 */
	public BigDecimal getFine() {
		return this.fine;
	}

	/**
	 * Sets the current fine to a new fine
	 * @param newFine - New amount that the fine will be set to
	 */
	public void setFine(BigDecimal newFine) {
		this.fine = newFine;
	}
	
	/**
	 * Pays fine with a given amount. Fine will be set to 0.00
	 * if the borrower over pays. Otherwise, the current fine will 
	 * be changed to the current fine minus amount
	 * @param amount
	 */
	public void payFine(BigDecimal amount) {
		
		//if user overpaid
		if(amount.compareTo(this.fine) == 1) {
			
			this.fine = new BigDecimal("0.00");
			
		} else {
			this.fine = fine.subtract(amount);
		}
		
	}

	/**
	 * Returns a string that shows the borrower information in a user-friendly way
	 * 
	 * @return Returns a string with borrower information
	 */
	public String toString() {
		return "Borrower id: " + this.id + "\nBorrower name: " + this.name + "\nBorrower fine amount ($): " + this.fine
				+ "\n";
	}
	
	/**
	 * Prints the users checked out media list in a user-friendly way
	 */
	public void dispCheckedOut() {
		System.out.println("Your checked out items:");
		System.out.println("----------------------------------------");
		for(Media b : this.checkOut) {
			System.out.println(b);
		}
		
		System.out.println("----------------------------------------\n");
	}

}

package hw2;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;

/**
 * Class representing a librarian and is used to interface with the library and
 * borrowers
 * 
 * @author brown8jt - Josh Brown
 *
 */

public class Librarian {

	private Library lib;
	private int borrowerCount;

	/**
	 * Constructor that sets the starting id number to 1
	 */
	public Librarian() {
		this.borrowerCount = 1;
	}

	/**
	 * Adds a library object using a text file
	 * 
	 * @param file
	 * @throws IOException
	 *             - file could not be found
	 */
	public void addLib(File file) throws IOException {
		this.lib = new Library(file);
	}

	/**
	 * Used to test library class without having a text file
	 * 
	 * @param a,
	 *            b, c - Media objects to be added manually
	 */
	public void addLib(Media a, Media b, Media c) {
		this.lib = new Library();
		this.lib.addMedia(a);
		this.lib.addMedia(b);
		this.lib.addMedia(c);
	}

	/**
	 * Registers a borrower using a name
	 * 
	 * @param name
	 *            - String representing the borrowers name to be added
	 */
	public void registerBorrower(String name) {

		// create new borrower
		Borrower b = new Borrower(this.borrowerCount, name);

		// try to add borrower
		if (lib.addBorrower(b) == true) {

			// new borrower was successfully registered and displays their id
			System.out.println("Your id is: " + this.borrowerCount);

			// increases unique id by 1
			this.borrowerCount++;
		}
	}

	/**
	 * Registers a borrower using a already defined borrower object
	 * 
	 * @param b
	 *            - Borrower to be added
	 */
	public void registerBorrower(Borrower b) {

		// try to add borrower
		if (lib.addBorrower(b) == true) {

			// new borrower was successfully registered and displays their id
			System.out.println("Your id is: " + this.borrowerCount);

			// increases unique id by 1
			this.borrowerCount++;
		}
	}

	/**
	 * Displays the library media inventory in a user-friendly way
	 */
	public void dispLibMedia() {
		this.lib.printLibInventory();
	}

	/**
	 * Tries to check out media with given id for borrower with given id If media is
	 * checked out, checked out media is added to the borrower's checked out list
	 * 
	 * @param borrowerId
	 *            - Represents the borrower's id
	 * @param mediaId
	 *            - Represents the media id to be checked out
	 */
	public void checkOutMedia(int borrowerId, int mediaId) {

		Media toCheckOut = this.lib.checkOut(mediaId);

		// checking out was successful
		if (toCheckOut != null) {
			Borrower b = this.lib.getBorrower(borrowerId);

			// borrower exists in system - add media to checked out list
			if (b != null) {
				b.addToCheckedOut(toCheckOut);
				System.out.println("Successfully checked out media!");
			} else {
				System.out.println("Your id is not registered with the system!");
			}
		}

	}

	/**
	 * Tries to return media with given id from borrower with given id. If media is
	 * returned, media is removed from borrower's checked out list and is set to
	 * available in library system. Checks whether or not media is already returned
	 * and if user exists
	 * 
	 * @param borrowerId
	 *            - Represents the borrower's id
	 * @param mediaId
	 *            - Represents the media id to be returned
	 */
	public void returnMedia(int borrowerId, int mediaId) {

		Borrower personReturning = null;

		for (Borrower b : this.lib.getBorrowerList()) {

			// found borrower with id
			if (b.getId() == borrowerId) {
				personReturning = b;
				break;
			}
		}

		// borrower with given id was found
		if (personReturning != null) {

			Media returned = this.lib.returnMedia(mediaId);

			// media can be returned
			if (returned != null) {

				// remove media from borrower's checked out list
				personReturning.getCheckedOutMedia().remove(returned);
				System.out.println("Returned media!");
				return;
			} else {

				// media was already returned
				System.out.println("Media already returned");
				return;
			}
		} else {

			// borrower with given id was not found
			System.out.println("Your id is not registered with the system!");
		}

	}

	/**
	 * Checks whether or not the media can be checked out
	 * 
	 * @param mediaId
	 *            - Id to check if media with given id is available to be checked
	 *            out
	 * @return -True if media can be checked out -False if media cannot be checked
	 *         out
	 */
	public boolean isMediaAvailable(int mediaId) {

		return this.lib.isMediaAvailable(mediaId);
	}

	/**
	 * Sets the total fine for a borrower with given id
	 * 
	 * @param borrowerId
	 *            - id for borrower to set fine
	 */
	public void setFineBal(int borrowerId) {

		// get borrower with given id
		Borrower b = this.lib.getBorrower(borrowerId);

		// borrower with given id could be found
		if (b != null) {

			// add 5 to borrowers fine
			BigDecimal newFine = b.getFine().add(new BigDecimal("5.00"));
			this.lib.getBorrower(borrowerId).setFine(newFine);
			System.out.println("Fine added to borrower with id: " + borrowerId);

		} else {

			// borrower with given id was not found
			System.out.println("Given id is not registered with the system!");

		}

	}

	/**
	 * Displays the borrower's given id checked out media
	 * 
	 * @param borrowerId
	 *            - Borrower's id to display their checked out media
	 */
	public void dispBorrowerCheckOut(int borrowerId) {

		// get borrower with given id
		Borrower b = this.lib.getBorrower(borrowerId);

		// borrower with given id could be found
		if (b != null) {

			// display borrower's checked out media
			b.dispCheckedOut();
		} else {

			// borrower with given id was not found
			System.out.println("Your id is not registered with the system!");
		}
	}
}

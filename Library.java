package hw2;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Class representing a library with check out, return, add borrowers
 * functionality
 * 
 * @author brown8jt - Josh Brown
 *
 */
public class Library {

	private List<Media> inventory;
	private List<Borrower> borrowerList;

	/**
	 * Constructor that uses a file to instantiate a library and its inventory
	 * 
	 * @param file
	 * @throws IOException
	 */
	public Library(File file) throws IOException {

		// initialize lists
		borrowerList = new ArrayList<Borrower>();
		inventory = new ArrayList<Media>();

		// fill library inventory
		Scanner fiSc = new Scanner(file);

		// iterate through file
		while (fiSc.hasNextLine()) {

			// get next line
			String line = fiSc.nextLine();

			// split line into 3
			String[] tempArray = line.split(",");

			// add new media to inventory
			if (tempArray[2].equals("Book")) {
				inventory.add(new Book(Integer.parseInt(tempArray[0]), Boolean.parseBoolean(tempArray[1])));
			} else {
				inventory.add(new DVD(Integer.parseInt(tempArray[0]), Boolean.parseBoolean(tempArray[1])));
			}

		}

		// close scanner
		fiSc.close();

	}

	/**
	 * Constructor with no params - used to debug without a file
	 */
	public Library() {

		// initialize lists
		inventory = new ArrayList<Media>();
		borrowerList = new ArrayList<Borrower>();
	}

	/**
	 * Adds a borrower to the borrower list if the borrower does not already exist
	 * in system using a predefined borrower object
	 * 
	 * @param pB
	 * @return boolean - Returns true if borrower was added to the system False if
	 *         borrower could not be added
	 */
	boolean addBorrower(Borrower pB) {

		boolean didAdd = false;

		// borrower list is empty
		if (this.borrowerList.size() == 0) {
			this.borrowerList.add(pB);
			didAdd = true;
		} else {

			boolean contains = false;

			// check if borrower is in system
			for (Borrower b : this.borrowerList) {

				// system already contains the borrower
				if (b.getId() == pB.getId()) {
					contains = true;
				}
			}

			// borrower is not in system
			if (!contains) {
				this.borrowerList.add(pB);
				didAdd = true;
			}

		}

		return didAdd;

	}

	/**
	 * Adds media object to the inventory system if media is not already in system
	 * 
	 * @param b
	 *            - media object to be added to the system
	 */
	void addMedia(Media b) {

		// inventory is empty
		if (this.inventory.size() == 0) {
			this.inventory.add(b);
		} else {

			boolean contains = false;

			// check if media is already in system
			for (Media i : inventory) {

				// media is already in system
				if (i.getId() == b.getId()) {
					contains = true;
				}
			}

			// media is not in system
			if (!contains) {
				this.inventory.add(b);

			}

		}

	}

	/**
	 * Checks whether or not media with given id is available to be checked out
	 * 
	 * @param id
	 *            - Integer representing a media id
	 * @return boolean - Boolean representing availability status of the given media
	 */
	boolean isMediaAvailable(int id) {

		boolean isAvailable = true;

		// check if media is available
		for (Media i : this.inventory) {
			if (i.getId() == id) {

				if (i.isAvailable() == false) {

					isAvailable = false;
				}
			}
		}

		return isAvailable;

	}

	/**
	 * Checks out media with given id if media is available
	 * 
	 * @param id
	 *            - Integer representing a media id
	 * @return Returns the media object that was checked out if check out was
	 *         successfull. Returns null if media could not be checked out
	 */
	Media checkOut(int id) {

		// iterate through inventory
		for (Media i : this.inventory) {

			// media is in list
			if (i.getId() == id) {

				// media is available to be checked out
				if (i.isAvailable() == true) {

					// set availability
					i.setAvailable(false);
					return i;

				} else {
					System.out.println("Media not available for checkout!\n");
				}

			}

		}

		return null;

	}

	/**
	 * Prints the library inventory in a user-friendly way
	 */
	void printLibInventory() {

		System.out.println("Media list:");
		System.out.println("----------------------------------------");

		// iterate through system
		for (Media i : inventory) {
			System.out.println(i.toString());
		}

		System.out.println("----------------------------------------\n");
	}

	/**
	 * Returns the borrower with the given id
	 * 
	 * @param id
	 *            - Id representing a unique borrower in list
	 * @return Returns the borrower with the given id if they are found. Returns
	 *         null if the borrower could not be found
	 */
	Borrower getBorrower(int id) {

		for (Borrower borrower : this.borrowerList) {

			if (borrower.getId() == id) {
				return borrower;
			}

		}
		return null;

	}

	/**
	 * Returns the entire borrower list
	 * 
	 * @return Returns the list of borrowers
	 */
	List<Borrower> getBorrowerList() {
		return this.borrowerList;
	}

	/**
	 * Tries to return media to the library
	 * 
	 * @param id
	 *            - Id representing media to be returned
	 * @return Returns the media that was returned. Returns null if media could not
	 *         be returned
	 */
	Media returnMedia(int id) {

		Media success = null;

		for (Media i : this.inventory) {

			// found media to return
			if (i.getId() == id) {

				// media will be returned
				if (i.isAvailable() == false) {

					// media was returned
					i.setAvailable(true);
					success = i;

				} else {

					// media was already returned
					success = null;
				}
			}

		}

		return success;

	}

}

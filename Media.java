package hw2;

/**
 * Abstract class that represents media in the library
 * system with an individual id and the availability 
 * of the media object
 * 
 * @author brown8jt - Josh Brown
 *
 */

public abstract class Media {

	private int id;
	private boolean isAvailable;

	/**
	 * Constructor for general media that sets the id
	 * and the availability
	 * 
	 * @param id - Id for media
	 * @param isAvailable - the availability for the media
	 * 
	 */
	public Media(int id, boolean isAvailable) {
		this.id = id;
		this.isAvailable = isAvailable;
	}

	/**
	 * Returns the availabilty of the media object
	 * @return isAvailable - True or false depending on the availability
	 * 						 of the media object
	 */
	public boolean isAvailable() {
		return this.isAvailable;
	}

	/**
	 * Returns the unique id of the media object
	 * @return id - Integer representing id of media object
	 */
	public int getId() {
		return this.id;
	}

	/**
	 * Sets the availability of the media object
	 * @param b - Boolean representing the new availability status of the media object
	 */
	public void setAvailable(boolean b) {
		this.isAvailable = b;
	}

}

package hw2;

/**
 * Class that represents a DVD and inherits the media class
 * 
 * @author brown8jt - Josh Brown
 *
 */
public class DVD extends Media{
	
	private int minLength;

	/**
	 * Constructor used to instantiate a dvd object
	 * @param id
	 * @param isAvailable
	 */
	public DVD(int id, boolean isAvailable) {
		super(id, isAvailable);
		this.minLength = (int)(100 + Math.random() * 100);
	}

	/**
	 * Returns the length of the movie in minutes
	 * @return minLength - Integer representing movie length in minutes
	 */
	public int getMinLength() {
		return this.minLength;
	}

	/**
	 * Returns all dvd information in a friendly way
	 * @return String - Returns a string printing the dvd information in a user-friendly
	 * way
	 */
	public String toString() {
		return "DVD id: " + this.getId() + "\nDVD availability: " + this.isAvailable() + "\nLength of movie (mins): "
				+ this.minLength + "\n";
	}

}

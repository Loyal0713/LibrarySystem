package hw2;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String args[]) throws IOException {

		File file = new File("hw2.txt");

		// create librarian
		Librarian lib = new Librarian();

		// add library to librarian
		lib.addLib(file);

		// create scanner to interact with librarian
		Scanner kb = new Scanner(System.in);

		// add new borrower
		System.out.println("Enter name to register:");
		String name = kb.nextLine();
		lib.registerBorrower(name);

		// display library inventory
		lib.dispLibMedia();

		// Enter details to check out media
		System.out.println("Enter your id to check out media:");
		int id = kb.nextInt();
		System.out.println("Enter media wanted:");
		int mediaId = kb.nextInt();

		// check out media
		lib.checkOutMedia(id, mediaId);
		
		// display current library inventory
		lib.dispLibMedia();

		// Enter id to view your checked out items
		System.out.println("Enter your id to view your checked out media:");
		id = kb.nextInt();

		// display borrowers checked out items
		lib.dispBorrowerCheckOut(id);

		// enter details to return media
		System.out.println("Enter your id to return media:");
		id = kb.nextInt();
		System.out.println("Id of media to return:");
		mediaId = kb.nextInt();

		// return media
		lib.returnMedia(id, mediaId);
		
		// display current library inventory
		lib.dispLibMedia();
		
		//set fine for borrower in system
		lib.setFineBal(1);
		
		//set fine for borrower not in system
		lib.setFineBal(234234);

	}

}

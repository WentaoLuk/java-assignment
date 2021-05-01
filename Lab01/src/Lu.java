import java.util.Scanner;
/**
 * 
 * @author evan
 *
 */

/*
 * Assignment: Lab01 Student: Wentao Lu Student ID: 040991469 Section Number:
 * SCT8284_304
 */
public class Lu {
	public static void main(String[] args) {

		// set up variables
		String name;
		String reason;
		int id;
		int remainTerm;

		Scanner keyboard = new Scanner(System.in);// set up a new Scanner object
		System.out.println("Student Name: ");// prompt the user for input
		name = keyboard.next();// the Scanner catch the input
		System.out.println("Student ID: ");
		id = keyboard.nextInt();
		System.out.println("Two reasons why you are taking this course");
		reason = keyboard.next();
		System.out.println("Compute the remaining terms till the end of your program");
		remainTerm = keyboard.nextInt();

		keyboard.close();// stop the Scanner object

		// output all the information input by user
		System.out
				.println("Student Name: " + name + "ID: " + id + "Reason: " + reason + "remaining terms:" + remainTerm);
	}
}

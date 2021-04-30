
package lab6W;

//import java.time.LocalDate;

/**
 * This is the Waiter hierarchy Test program. 
 * TO DO: You are required to complete the necessary portions of this code as designated in different areas.
 * TO DO: You must also provide appropriate Javadoc comments in the different portions of this program to explain what you have done.
 * It is your responsibility to ensure that ALL comments in the code are in the Javadoc style.
 */

import java.util.Scanner; // This program uses Scanner to obtain user input. NOTE!!!!

public class Test {

	public static void main(String[] args) {
		// create subclass objects
		SalariedWaiter salariedWaiter = new SalariedWaiter("Blessing", "Obioma", "123-44-1234", 3, 15, 1945, 750.00);
		HourlyWaiter hourlyWaiter = new HourlyWaiter("Ife", "Oluwa", "123-55-5678", 6, 29, 1965, 16.75, 40);
		CommissionWaiter commissionWaiter = new CommissionWaiter("Andrew", "Peters", "123-66-9012", 9, 8, 1985, 30000,
				.06);
		BasePlusCommissionWaiter basePlusCommissionWaiter = new BasePlusCommissionWaiter("John", "Mercy", "123-77-3456",
				12, 2, 2005, 7000, .04, 300);

		System.out.println("Waiter processed individually:\n");

		System.out.printf("%s\n%s: $%,.2f\n\n", salariedWaiter, "earned", salariedWaiter.earnings());
		System.out.printf("%s\n%s: $%,.2f\n\n", hourlyWaiter, "earned", hourlyWaiter.earnings());
		System.out.printf("%s\n%s: $%,.2f\n\n", commissionWaiter, "earned", commissionWaiter.earnings());
		System.out.printf("%s\n%s: $%,.2f\n\n", basePlusCommissionWaiter, "earned",
				basePlusCommissionWaiter.earnings());

		/**
		 * Create the elements Waiter array as required
		 */
		Waiter Waiters[] = { salariedWaiter, hourlyWaiter, commissionWaiter, basePlusCommissionWaiter };

		/**
		 * TO DO: IMPLEMENT THE USE OF A SCANNER TO GET THE CURRENT MONTH. COMPLETE THIS
		 * PORTION
		 */
		Scanner input = new Scanner(System.in);
		int userInputMonth;
		while (true) {
			System.out.println("Enter the current month (1 - 12): ");
			userInputMonth = input.nextInt();
			// GET AND VALIDATE THE CURRENT MONTH.
			if (userInputMonth >= 1 && userInputMonth <= 12) {
				break;
			} else {
				System.out.println("Wrong month!");
			}
		}

		input.close();
//		LocalDate today = LocalDate.now();
//		int month = today.getMonthValue();

		System.out.println("Waiters processed polymorphically:\n");

		/** Generically process each element in array Waiters */

		for (Waiter currentWaiter : Waiters) {
			System.out.printf("%n%n");

			System.out.println(currentWaiter); // invokes toString

			// determine whether element is a BasePlusCommissionWaiter
			if (currentWaiter instanceof BasePlusCommissionWaiter) {
				// downcast Waiter reference to
				// BasePlusCommissionWaiter reference
				BasePlusCommissionWaiter Waiter = (BasePlusCommissionWaiter) currentWaiter;

				double oldBaseSalary = Waiter.getBaseSalary();
				Waiter.setBaseSalary(1.10 * oldBaseSalary);
				System.out.printf("new base salary with 15%% increase is: $%,.2f%n", Waiter.getBaseSalary());
			}
			System.out.printf("earned $%,.2f",currentWaiter.earnings());//BasePlusCommissionWaiter.

			/**
			 * If this is the month of a Waiter's birthday, then add the sum of $350 to
			 * salary and print out the current waiter's earning Otherwise, go ahead and
			 * print what the waiter has earned.
			 */
			if (currentWaiter.getBirthDate().getMonth() == userInputMonth) {
				System.out.print(" plus $350.00 birthday bonus");
			}
		}
		System.out.printf("%n%n");

		/** get type name of each object in Waiters array */

		for (int j = 0; j < Waiters.length; j++) {
			System.out.printf("Waiter %d is a %s\n", j, Waiters[j].getClass().getName());
		}
	}
	
}

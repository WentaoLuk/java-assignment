package climatechanger;

/**
 * This program prints a table providing hypothetical number of animals that
 * have been displaced due to climate change as a result of twelve different
 * temperature variations. The varying temperatures considered are between 0
 * degrees celsius and 45 degrees celsius.
 * 
 * @author Wentao Lu
 * @since 1.8.0
 */


public class ClimateChange {
	public static void main(String[] args) {
		final int ROWS = 9;
		final int COLUMNS = 12;

		int[][] displaced = { { 106, 107, 111, 133, 221, 767, 866, 1001, 172, 307, 392, 395 },
				{ 20, 73, 26, 82, 502, 615, 209, 947, 116, 214, 278, 445 },
				{ 163, 203, 276, 308, 172, 246, 354, 118, 123, 310, 146, 152 },
				{ 121, 260, 234, 108, 149, 202, 216, 58, 567, 229, 628, 765 },
				{ 1203, 1274, 1226, 1882, 1072, 1007, 1192, 1395, 123, 310, 146, 152 },
				{ 116, 324, 438, 714, 167, 521, 209, 904, 76, 29, 31, 99 },
				{ 76, 29, 31, 99, 187, 201, 278, 306, 183, 122, 99, 246 },
				{ 109, 104, 121, 13, 121, 69, 246, 100, 123, 161, 69, 246 },
				{ 402, 415, 209, 547, 106, 234, 178, 145, 103, 121, 39, 246 } };// 2D array.

		String[] animals = { "Cheetah", "Tigers", "Asian elephant", "Vaquita porpoise", "Mountain gorilla", "Red tuna",
				"Orangutan", "Black Rhinos", "Dolphins" };

		System.out
				.println("              Temp     0C   1C     3C    5C    7C    9C   28C   32C   36C   38C   42C   45C");
		System.out.println();

		/**
		 * Important to note the number of animals displaced, so we print displaced
		 * numbers here for all animals.
		 */

		for (int i = 0; i < ROWS; i++) {
			// Print the ith row
			System.out.printf("%20s", animals[i]);// 间隔强制控制在20,如果短了,左边会有空白补齐,达到排序效果.s代表string
			for (int j = 0; j < COLUMNS; j++) {
				System.out.printf("%8d", displaced[i][j]);// 同理同上。
			}
			System.out.println(); // A new line begins at the end of the row.
		}

		/**
		 * Update the code in this section BELOW writing a nested for loop (for the
		 * columns and rows of your array) to compute the sum (column) of animals that
		 * were displaced in view of the temperatures. Print the column sum using
		 * printf.
		 */
		System.out.println();
		System.out.print("             Animals");
		for (int i = 0; i < COLUMNS; i++) {
			int sum = 0;
			for (int j = 0; j < ROWS; j++) {
				sum += displaced[j][i];
			}
			System.out.printf("%8d", sum);

		}
		System.out.println();

		// TO DO: INSERT YOUR CODE HERE!!!!

		System.out.println("               Save our animals, climate change is real!");
	}
}

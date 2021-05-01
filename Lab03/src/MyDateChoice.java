/**
 * MyDateChoice class definition Study this code completely before you start
 * updating. Check slide instructions for references. Ensure that ALL comments
 * within your Java files are written in Javadoc format. Include new comments
 * where necessary - ALL USING JAVADOC style.
 * @author Wentao Lu
 */

public class MyDateChoice {
	private static final String[] monthNames = { "January", "February", "March", "April", "May", "June", "July",
			"August", "September", "October", "November", "December" };
	private static final int[] monthDays = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

	private int month; // month in the year
	private int day; // day of the month
	private int year; // year

	// TO DO 1: CREATE a no-argument constructor HERE and then implement constructor
	// chaining to one of the constructors in this class.
	// Using Javadoc format provide comments on this section of your code and how
	// you implemented chaining.

	/**
	 * The default constructor sets the day to 1, month to 1, and year to 1970.
	 */
	public MyDateChoice() {
		this(1, 1, 1970);
	}

	// TO DO 2: IMPLEMENT THE FIRST CASE of the overloaded constructor (SEE LAB
	// SLIDES FOR DESCRIPTION):

	// CREATE a CONSTRUCTOR for the FIRST CASE date format: MM/DD/YYY
	// Note that in creating the date formats, you must use overloaded constructors.
	// Add necessary comment.
	// This constructor receives three integers.

	// Your code for this section STARTS here.

	/**
	 * This constructor sets the month, the day and the year as passed.
	 * @param month The month in the date.
	 * @param day The day of the month in the date.
	 * @param year The year in the date.
	 */
	public MyDateChoice(int month, int day, int year) {
		this.day = day;
		this.month = month;
		this.year = year;
	}

	// Your code for this section ENDS here.

	// TO DO 3: Implement the SECOND CASE of the overloaded constructor (SEE LAB
	// SLIDES FOR DESCRIPTION):

	// The requirement for this section of your code is to create a CONSTRUCTOR for
	// the SECOND CASE date format: Monthname dd, yyyy
	// Note that in creating these formats, overloaded constructors are used.
	// Add relevant comments using the Javadoc style comments.

	// Your code for this section STARTS here.

	/**
	 * This constructor sets the name of the month, the day of the month and the year as passed.
	 * @param monthName The name of the month in the date.
	 * @param day The day of the month in the date.
	 * @param year The year in the date.
	 */
	public MyDateChoice(String monthName, int day, int year) {
		this.month = convertFromMonthName(monthName);
		this.day = day;
		this.year = year;
	}

// Your code for this section ENDS here.

	/**
	 * DO NOT MODIFY OR UPDATE the rest of this code. Just review the remaining
	 * sections to see the implementation. This is the implementation of the THIRD
	 * CASE (SEE LAB SLIDES DESCRIPTION): constructor for the format: DDD YYYY.
	 */

	public MyDateChoice(int ddd, int year) {
		if (year < 0) { // validate year
			throw new IllegalArgumentException("year must be > 0");
		}

		if (ddd < 1 || ddd > 366) { // check for invalid day
			throw new IllegalArgumentException("day out of range");
		}

		this.year = year;

		int dayTotal = 0;

		for (int m = 1; m < 13 && (dayTotal + daysInMonth(m, year)) < ddd; ++m) {
			dayTotal += daysInMonth(m, year);
			this.month = m + 1;
		}

		this.day = ddd - dayTotal;
	}

	// Set the day
	public void setDay(int day) {
		if (day < 1 || day > daysInMonth(month, year)) {
			throw new IllegalArgumentException("day out of range for current month");
		}

		this.day = day;
	}

	// Set the month
	public void setMonth(int month) {
		if (month <= 0 || month > 12) { // validate month
			throw new IllegalArgumentException("month must be 1-12");
		}

		this.month = month;
	}

	// Set the year
	public void setYear(int year) {
		if (year < 0) { // validate year
			throw new IllegalArgumentException("year must be > 0");
		}

		this.year = year;
	}

	// return Date in format: mm/dd/yyyy
	public String toString() {
		return String.format("%d/%d/%d", month, day, year);
	}

	// return Date in format: MonthName dd, yyyy
	public String toMonthNameDateString() {
		return String.format("%s %d, %d", monthNames[month - 1], day, year);
	}

	// return Date in format DDD YYYY
	public String toDayDateString() {
		return String.format("%d %d", convertToDayOfYear(), year);
	}

	// Return the number of days in the month
	private static int daysInMonth(int month, int year) {
		return leapYear(year) && month == 2 ? 29 : monthDays[month - 1];
	}

	// test for a leap year
	private static boolean leapYear(int year) {
		if (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) {
			return true;
		} else {
			return false;
		}
	}

	// convert mm and dd to ddd
	private int convertToDayOfYear() {
		int ddd = 0;

		for (int m = 1; m < month; ++m) {
			if (leapYear(year) && m == 2) {
				ddd += 29;
			} else {
				ddd += monthDays[m - 1];
			}
		}

		ddd += day;
		return ddd;
	}

	// convert from month name to month number
	private static int convertFromMonthName(String monthName) {
		for (int subscript = 0; subscript < 12; subscript++) {
			if (monthName.equals(monthNames[subscript])) {
				return subscript + 1;
			}
		}

		throw new IllegalArgumentException("Invalid month name");
	}
}

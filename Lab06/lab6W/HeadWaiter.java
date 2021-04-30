package lab6W;

/**
 * This waiter subclass represents a waiter whose pay 
 * depends on the number of pieces of sandwiches produced while on duty.
 * @author Wentao Lu
 *
 */
public class HeadWaiter extends Waiter {

	/**
	 * the waiter's earning for each piece of bread he made
	 */
	private double wage;
	
	/**
	 * the number of pieces of sandwiches made
	 */
	private int pieces;

	public HeadWaiter(String firstName, String lastName, String socialSecurityNumber, int month, int day, int year,
			double wage, int pieces) {
		super(firstName, lastName, socialSecurityNumber, month, day, year);

		if (wage < 0.0) { // validate wage
			throw new IllegalArgumentException("Hourly wage must be >= 0.0");
		}

		if (pieces < 0) { // validate hours
			throw new IllegalArgumentException("Hours worked must be >= 0.0 and <= 168.0");
		}
		this.wage = wage;
		this.pieces = pieces;
	}

	public void setPieces(int pieces) {
		if (pieces < 0) { // validate pieces
			throw new IllegalArgumentException("pieces  must be >= 0 ");
		}
		this.pieces = pieces;
	}

	/**
	 * getter of pieces
	 * @return the integer number of pieces the waiter has made
	 */
	public int getPieces() {
		return pieces;
	}

	/**
	 * getter of wage
	 * @return the double number of the wage
	 */
	public double getWage() {
		return wage;
	}

	/**
	 * setter of wage
	 * @param 
	 */
	public void setWage(double wage) {
		if (wage < 0.0) { // validate wage
			throw new IllegalArgumentException("Wage per piece must be >= 0.0");
		}
		this.wage = wage;
	}

	@Override
	/**
	 * calculate earnings; override abstract method earnings in Employee
	 */
	public double earnings() {

		return pieces * wage;

	}

	// return String representation of HeadWaiter object
	@Override
	public String toString() {
		return String.format("Head Waiter: %s%n%s: $%,.2f; %s: %d", super.toString(), "wage per piece", getWage(),
				"Num. of pieces made", getPieces());
	}

}

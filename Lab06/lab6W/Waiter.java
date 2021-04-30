
package lab6W;

/**
 * This is the Waiter abstract superclass. It is your responsibility to ensure
 * that all comments are stated in the Javadoc style. Complete the relevant
 * portions of this code as designated below and ensure that your code runs
 * without errors.
 */

public abstract class Waiter {
	private final String firstName;
	private final String lastName;
	private final String socialSecurityNumber;
	private Date birthDate;

// constructor
	public Waiter(String firstName, String lastName, String socialSecurityNumber, int month, int day, int year) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.socialSecurityNumber = socialSecurityNumber;
		birthDate = new Date(month, day, year);
	}

// return first name
	public String getFirstName() {
		return firstName;
	}

// return last name
	public String getLastName() {
		return lastName;
	}

// return social security number
	public String getSocialSecurityNumber() {
		return socialSecurityNumber;
	}

	/**
	 * 
	 * @return birth date
	 */
	public Date getBirthDate() {
		return birthDate;
	}

	/**
	 * @return the String representation of Waiter object
	 */
	@Override
	public String toString() {
		return firstName + " " + lastName + "\n" + "social security number: " + socialSecurityNumber + "\n"
				+ "birthDate: " + birthDate.toString();
	}

// abstract method must be overridden by concrete subclasses
	public abstract double earnings(); /** There is no implementation here. Do you know why? */

}

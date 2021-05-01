package hospitalpersonnel;
/**
 * This class is inherited from Doctor class.
 * 
 * @author Wentao Lu
 */
public class Surgeon extends Doctor {

	/**
	 * Construct a Surgeon object.
	 * 
	 * @param n 	the name of the Surgeon
	 * @param s 	the salary of the Surgeon
	 * @param ward	the Doctor's ward
	 */
	public Surgeon(String n, double s, String ward) {
		super(n, s, ward);
	}

	/**
	 * This is an overridden toString method that returns the string representation
	 * of the Surgeon object including its ward, name and salary.
	 * 
	 * @return a string representation of the Surgeon object
	 */
	@Override
	public String toString() {
		return "Surgeon [toString()=" + super.toString() + "]";
	}
	
	
	
}

package hospitalpersonnel;
/**
 * This class is inherited from HospitalPersonnel class.
 * 
 * @author Wentao Lu
 */
public class Doctor extends HospitalPersonnel{
	
	/**
	 * The ward that the doctor belongs to.
	 */
	private String ward;

	
	
	/**
	 * Construct a Doctor object.
	 * 
	 * @param n 	the name of the Doctor
	 * @param s 	the salary of the Doctor
	 * @param ward	the Doctor's ward
	 */
	public Doctor(String n, double s, String ward) {
		super(n, s);
		this.ward = ward;
	}

	/**
	 * This is an overridden toString method that returns the string representation
	 * of the Doctor object including its ward, name and salary.
	 * 
	 * @return a string representation of the Doctor object
	 */
	@Override
	public String toString() {
		return "Doctor [ward=" + ward + ", toString()=" + super.toString() + "]";
	}

}

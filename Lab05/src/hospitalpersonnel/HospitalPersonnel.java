package hospitalpersonnel;

/**
 * In a hospital there are many people who work to ensure good health outcomes.
 * Hospital personnel are paid salaries and such personnel could belong to
 * different wards. An example of a ward is the inpatients ward, and inside the
 * ward you can have specialties like Inpatients Theatre, etc. TO DO: Read the
 * comments inserted into all the code files provided carefully to know what you
 * are expected to. TO DO: Show your professor any other relevant modification
 * you have made. TO DO: Remember to insert your Javadoc style comments to
 * explain what you have done in all code files.
 */

public class HospitalPersonnel {
	private String name;
	private double salary;

	/**
	 * Construct an HospitalPersonnel object.
	 * 
	 * @param n the name of the Hospital Personnel
	 * @param s the salary of the Hospital Personnel
	 */
	public HospitalPersonnel(String n, double s) {
		name = n;
		salary = s;
	}

	/**
	 * Returns the string representation of the object.
	 * 
	 * @return a string representation of the object
	 */
	public String toString() {
		return "HospitalPersonnel[name=" + name + ",salary=" + salary + "]";
	}
}

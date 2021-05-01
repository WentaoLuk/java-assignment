package hospitalpersonnel;

/**
 * This program tests the HospitalPersonnel class and its subclasses. You are
 * required to write your code and update this file. Remember to provide the
 * necessary Javadoc output for your documentations. Check the sample output to
 * give you an idea of what to expect. The Doctor works at the Inpatients ward
 * Use your name as the surgeon and assign any salary you wish to earn. The
 * Surgeon works at the Inpatients Theatre ward Use your friend's name as the
 * doctor and give any salary you wish. Ensure that your output shows all
 * necessary details based on the concepts applied in this lab
 */

/**
 * The this program tests the HospitalPersonnel class and its subclasses by
 *  using their constructors and toString methods.
 * 
 * 
 * @author Wentao Lu
 */
public class HospitalPersonnelTest {

	public static void main(String[] args) {
		
		/**
		 * create a Doctor object with the name of "Wentao Lu", salary of 10000 and the ward
		 * of "Inpatient Ward".
		 */
		HospitalPersonnel lukeDoctor = new Doctor("Wentao Lu", 10000, "Inpatient Ward");

		/**
		 * create a Surgeon object with the name of "Wentao Lu", salary of 10000 and the ward
		 * of "General Ward".
		 */
		HospitalPersonnel lukeSurgeon = new Surgeon("Wentao Lu", 10000, "General Ward");
		
		/**
		 * create a Surgeon object with the name of "Wentao Lu", salary of 10000
		 */
		HospitalPersonnel luke = new HospitalPersonnel("Wentao Lu", 10000);
		
		
		
		/**
		 * print out the return value of the Doctor object including its
		 * ward, name and salary.
		 */
		System.out.println(lukeDoctor.toString());
		
		/**
		 * print out the return value of the Surgeon object including its
		 * ward, name and salary.
		 */
		System.out.println(lukeSurgeon.toString());
		
		/**
		 * print out the return value of the HospitalPersonnel object including its
		 * ward, name and salary.
		 */
		System.out.println(luke.toString());
		
	}
}

package newTest;

//package lab4;

import org.junit.Test;
import org.junit.Assert;

public class MoneyMartTest {
	private static final double EPSILON = 1E-12;

	@Test
	/**
	 * @see MoneyMart.java
	 * This test case is to create an object of MoneyMart and place parameters into its method
	 * to see if the value provided by the output method giveChange() is as expected.
	 */
	public void currencies() {
		MoneyMart mart = new MoneyMart();
		mart.recordPurchase(0);
		mart.recordPurchase(1.50);
		mart.receivePayment(2, 0, 5, 0, 0);
		double expected = 0.25;
		Assert.assertEquals(expected, mart.giveChange(), EPSILON);
	}

	/**
	 * @see MoneyMart.java
	 * This method will test MoneyMart again with the expectation of zero balance outcome.
	 */
	@Test
	public void testZeroBalance() {
		MoneyMart mart = new MoneyMart();
		mart.recordPurchase(0.75);
		mart.recordPurchase(1.50);
		mart.receivePayment(2, 0, 0, 0, 25);
		double expected = 0;
		Assert.assertEquals(expected, mart.giveChange(), EPSILON);
	}


	// NEW TEST CASE REQUIRED HERE. FOLLOW INSTRUCTIONS BELOW.

	/**
	 * YOUR TASKS STARTS HERE: DO THE FOLLOWING: YOUR TASK 1: Run the code files AS
	 * PROVIDED for you (JUnit Test) and show that THERE IS NO ERROR - IT MUST SHOW
	 * THE GREEN BAR. YOUR TASK 2: During your demo to your professor, MODIFY the
	 * TEST CASE in this file named: currencies() by introducing an error in the
	 * test so that the test fails. YOUR TASK 3: Demo the failed test to your
	 * professor (IT MUST SHOW THE RED BAR) YOUR TASK 4: Modify this MoneyMartTest
	 * code file by adding just one NEW TEST CASE. Name your NEW TEST CASE:
	 * testZeroBalance. Ensure that in your new test case, you have used an
	 * assertion. YOUR TASK 5: Add Javadoc comments as necessary within this file.
	 * YOUR TASK 6: Run your new test suite and demo this to your professor.
	 */
}

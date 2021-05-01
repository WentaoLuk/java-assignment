package newTest;


import org.junit.Assert;
import org.junit.Test;
/**
 * @author Wentao Lu
 * This is another test case to test MoneyMart.java
 *
 */
public class MoneyMart2Test {
	private static final double EPSILON = 1E-12;

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
}
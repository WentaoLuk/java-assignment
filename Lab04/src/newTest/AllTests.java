package newTest;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * 
 * @author Wentao Lu
 * @see MoneyMartTest.java MoneyMart2Test.java
 *
 */
@RunWith(Suite.class)
@SuiteClasses({ MoneyMart2Test.class, MoneyMartTest.class })
public class AllTests {

}

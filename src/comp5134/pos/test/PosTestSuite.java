package comp5134.pos.test;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * Test suite for POS, contains the following test cases:
 * MerchantTest; 
 * FlavorsTest; 
 * DecoratorsTest; 
 * TransactionTest and
 * TransactionDetailTest
 * @author Raymond Kwan
 *
 */
public class PosTestSuite extends TestSuite {
	public static Test suite()
	{
		TestSuite posSuite = new TestSuite("POS Test Suite");
		
		posSuite.addTestSuite(MerchantTest.class);
		posSuite.addTestSuite(FlavorsTest.class);
		posSuite.addTestSuite(DecoratorsTest.class);
		posSuite.addTestSuite(TransactionTest.class);
		posSuite.addTestSuite(TransactionDetailTest.class);
		return posSuite;
	}
}

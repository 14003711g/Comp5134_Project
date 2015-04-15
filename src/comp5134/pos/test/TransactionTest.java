package comp5134.pos.test;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import comp5134.pos.domain.Transaction;

/**
 * Test case of transaction domain
 * @author Raymond Kwan
 *
 */
public class TransactionTest extends TestCase {
	private Transaction t1;
	private Transaction t2;
	
	@Before
	public void setUp() throws Exception {
		Calendar createdTime = Calendar.getInstance();
		Calendar createdTime2 = Calendar.getInstance();
		createdTime2.add(Calendar.SECOND, 10);

		SimpleDateFormat displayFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				
		t1 = new Transaction(1, 23.5, displayFormat.format(createdTime.getTime()), "Cashier1");
		t2 = new Transaction(2, 32.0, displayFormat.format(createdTime2.getTime()), "Cashier2");
	}

	@After
	public void tearDown() throws Exception {
		t1 = null;
		t2 = null;
	}

	@Test
	public void testTransactionCreated() {
		Assert.assertNotNull(t1);
		Assert.assertNotNull(t2);
		Assert.assertNotSame(t1, t2);
	}

	@Test
	public void testGetter() {
		Assert.assertFalse(t1.getId() == 0);
		Assert.assertFalse(t2.getId() == 0);
		Assert.assertTrue(t1.getId() == 1);
		Assert.assertTrue(t2.getId() == 2);
		Assert.assertEquals("Transaction amount of transaction 1 not match", 0, Double.compare(23.50, t1.getAmount()));
		Assert.assertEquals("Cashier does not match of transaction 1", "Cashier1", t1.getCreatedBy());
		Assert.assertEquals("Cashier does not match of transaction 2", "Cashier2", t2.getCreatedBy());
		Assert.assertEquals("Transaction amount of transaction 2 not match", 0, Double.compare(32.00, t2.getAmount()));
	}
}

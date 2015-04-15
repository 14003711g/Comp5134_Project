package comp5134.pos.test;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import comp5134.pos.domain.TransactionDetail;

/**
 * Test case of transaction detail domain
 * @author Raymond Kwan
 *
 */
public class TransactionDetailTest extends TestCase {
	private TransactionDetail td1;
	private TransactionDetail td2;
	
	@Before
	public void setUp() throws Exception {
		td1 = new TransactionDetail(1, "f", "Chocolate", 20);
		td2 = new TransactionDetail(2, "d", "M&M", 5);
	}

	@After
	public void tearDown() throws Exception {
		td1 = null;
		td2 = null;
	}

	@Test
	public void testTransactionDetailCreated() {
		Assert.assertNotNull(td1);
		Assert.assertNotNull(td2);
		Assert.assertNotSame(td1, td2);
	}

	@Test
	public void testGetter() {
		Assert.assertFalse(td1.getId() == 0);
		Assert.assertFalse(td2.getId() == 0);
		Assert.assertTrue(td1.getId() == 1);
		Assert.assertTrue(td2.getId() == 2);
		Assert.assertEquals("Unit price of transaction detail 1 not match", 0, Double.compare(20, td1.getUnitPrice()));
		Assert.assertTrue("Item type of transaction detail 1 dos not match", td1.getItemType().equals("f"));
		Assert.assertTrue("Item type of transaction detail 2 dos not match", td2.getItemType().equals("d"));
		Assert.assertTrue("Item Name of transaction detail 1 dos not match", td1.getItemName().equals("Chocolate"));
		Assert.assertTrue("Item Name of transaction detail 2 dos not match", td2.getItemName().equals("M&M"));
		Assert.assertEquals("Unit price of transaction detail 2 not match", 0, Double.compare(5, td2.getUnitPrice()));
	}
}

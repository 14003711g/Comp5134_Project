package comp5134.pos.test;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import comp5134.pos.domain.Flavors;

/**
 * Test case of flavors domain
 * @author Raymond Kwan
 *
 */
public class FlavorsTest extends TestCase {
	private Flavors f1;
	private Flavors f2;
	
	@Before
	public void setUp() throws Exception {
		f1 = new Flavors("Flavor 1", 15.00);
		f2 = new Flavors("Flavor 2", 20.00);
	}

	@After
	public void tearDown() throws Exception {
		f1 = null;
		f2 = null;
	}

	@Test
	public void testFlavorCreated() {
		Assert.assertNotNull(f1);
		Assert.assertNotNull(f2);
		Assert.assertNotSame(f1, f2);
	}
	
	@Test
	public void testGetter() {
		Assert.assertFalse(f1.getName().isEmpty());
		Assert.assertEquals("Unit price does not match", 0, Double.compare(15.00, f1.getUnitPrice()));
		Assert.assertEquals("Flavor name does not match", "Flavor 2", f2.getName());
		Assert.assertEquals("Unit price does not match", 0, Double.compare(20.00, f2.getUnitPrice()));
	}
	
	@Test
	public void testSetter() {
		f2.setName("Modified Flavor 2");
		f2.setUnitPrice(22.00);
		
		Assert.assertEquals("Flavor name does not match", "Modified Flavor 2", f2.getName());
		Assert.assertEquals("Unit price does not match", 0, Double.compare(22.00, f2.getUnitPrice()));
	}
	
	@Test
	public void testCheckOverLimit() {
		Assert.assertFalse(f1.checkOverLimit(-1));
		Assert.assertFalse(f1.checkOverLimit(0));
		Assert.assertTrue(f1.checkOverLimit(1));
	}
}

package comp5134.pos.test;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import comp5134.pos.domain.Decorators;

/**
 * Test case of decorators domain
 * @author Raymond Kwan
 *
 */
public class DecoratorsTest extends TestCase {
	private Decorators d1;
	private Decorators d2;
	
	@Before
	public void setUp() throws Exception {
		d1 = new Decorators("Decorator 1", 2.50);
		d2 = new Decorators("Decorator 2", 3.50);
	}

	@After
	public void tearDown() throws Exception {
		d1 = null;
		d2 = null;
	}

	@Test
	public void testDecoratorCreated() {
		Assert.assertNotNull(d1);
		Assert.assertNotNull(d2);
		Assert.assertNotSame(d1, d2);
	}

	@Test
	public void testGetter() {
		Assert.assertFalse(d1.getName().isEmpty());
		Assert.assertEquals("Unit price does not match", 0, Double.compare(2.50, d1.getUnitPrice()));
		Assert.assertEquals("Decorator name does not match", "Decorator 2", d2.getName());
		Assert.assertEquals("Unit price does not match", 0, Double.compare(3.50, d2.getUnitPrice()));
	}
	
	@Test
	public void testSetter() {
		d2.setName("Modified Decorator 2");
		d2.setUnitPrice(4.50);
		
		Assert.assertEquals("Decorator name does not match", "Modified Decorator 2", d2.getName());
		Assert.assertEquals("Unit price does not match", 0, Double.compare(4.50, d2.getUnitPrice()));
	}
	
	@Test
	public void testCheckOverLimit() {
		Assert.assertFalse(d1.checkOverLimit(-1));
		Assert.assertFalse(d1.checkOverLimit(0));
		Assert.assertFalse(d1.checkOverLimit(1));
		Assert.assertFalse(d1.checkOverLimit(10));
	}
}

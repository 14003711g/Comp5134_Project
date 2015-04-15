package comp5134.pos.test;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import comp5134.pos.domain.Merchant;

/**
 * Test case of merchant domain
 * @author Raymond Kwan
 *
 */
public class MerchantTest extends TestCase {

	private Merchant m8;
	private Merchant m9;
	
	@Before
	public void setUp() throws Exception {
		m8 = new Merchant(8888, 8, "Rich Rich Ice Cream Shop 8", "Address 8, Hong Kong", "8888 8888"); 
		m9 = new Merchant(9999, 9, "Rich Rich Ice Cream Shop 9", "Address 9, Hong Kong", "9999 9999");
	}

	@After
	public void tearDown() throws Exception {
		m8 = null;
		m9 = null;
	}

	@Test
	public void testMerchantCreated() {
		Assert.assertNotNull(m8);
		Assert.assertNotNull(m9);
		Assert.assertNotSame(m8, m9);
	}
	
	@Test
	public void testGetter() {
		Assert.assertEquals("MerchantId does not match", 8888, m8.getMerchantId());
		Assert.assertEquals("ShopId does not match", 8, m8.getShopId());
		Assert.assertEquals("Shop Name does not match", "Rich Rich Ice Cream Shop 8", m8.getName());
		Assert.assertEquals("Address does not match", "Address 8, Hong Kong", m8.getAddress());
		Assert.assertEquals("Telephone number does not match", "8888 8888", m8.getTelephone());
	}
	
	@Test
	public void testSetter() {
		m8.setMerchantId(6666);
		m8.setShopId(6);
		m8.setName("Rich Rich Ice Cream Shop 6");
		m8.setAddress("Address 6, Hong Kong");
		m8.setTelephone("6666 6666");
		
		Assert.assertEquals("Modified MerchantId does not match", 6666, m8.getMerchantId());
		Assert.assertEquals("Modified ShopId does not match", 6, m8.getShopId());
		Assert.assertEquals("Modified Shop Name does not match", "Rich Rich Ice Cream Shop 6", m8.getName());
		Assert.assertEquals("Modified Address does not match", "Address 6, Hong Kong", m8.getAddress());
		Assert.assertEquals("Modified Telephone number does not match", "6666 6666", m8.getTelephone());
	}
	
}

package comp5134.pos.domain;

/**
 * This class is used to store the merchant details, which properties are gathered from SystemSetting.java 
 * @author Raymond Kwan
 *
 */
public final class Merchant {
	private int merchantId;
	private int shopId;
	private String name;
	private String address;
	private String telephone;
	
	/**
	 * Create a new merchant instance 
	 * @param merchantId int
	 * @param shopId int
	 * @param name String
	 * @param address String
	 * @param telephone String
	 */
	public Merchant(int merchantId, int shopId, String name, String address, String telephone)
	{
		this.merchantId = merchantId;
		this.shopId = shopId;
		this.name = name;
		this.address = address;
		this.telephone = telephone;
	}
	
	/**
	 * Assign merchant Id 
	 * @param merchantId is an integer
	 */
	public void setMerchantId(int merchantId)
	{
		this.merchantId = merchantId;
	}
	
	/**
	 * Gather merchant Id 
	 * @return Merchant Id
	 */
	public int getMerchantId()
	{
		return this.merchantId;
	}

	/**
	 * Assign Shop Id 
	 * @param shopId is an integer
	 */
	public void setShopId(int shopId)
	{
		this.shopId = shopId;
	}
	
	/**
	 * Gather shop Id 
	 * @return Shop Id
	 */
	public int getShopId()
	{
		return this.shopId;
	}
	
	/**
	 * Assign merchant name 
	 * @param name is a String
	 */
	public void setName(String name)
	{
		this.name = name;
	}
	
	/**
	 * Gather merchant name 
	 * @return merchant name
	 */
	public String getName()
	{
		return this.name;
	}
		
	/**
	 * Assign merchant address 
	 * @param address is a String
	 */
	public void setAddress(String address)
	{
		this.address = address;
	}
	
	/**
	 * Gather merchant address 
	 * @return merchant address
	 */
	public String getAddress()
	{
		return this.address;
	}
	
	/**
	 * Assign merchant telephone 
	 * @param telephone is a String
	 */
	public void setTelephone(String telephone)
	{
		this.telephone = telephone;
	}
	
	/**
	 * Gather merchant telephone 
	 * @return merchant telephone
	 */
	public String getTelephone()
	{
		return this.telephone;
	}
}
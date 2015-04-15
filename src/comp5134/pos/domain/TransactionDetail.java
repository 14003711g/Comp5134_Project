package comp5134.pos.domain;

/**
 * This class is used to represent transaction details and does not extended by other class
 * @author Raymond Kwan
 *
 */
public final class TransactionDetail {
	int id;
	String itemType;
	String itemName;
	double untiPrice;
	
	/**
	 * Constructor of transaction detail 
	 */
	public TransactionDetail(int id, String itemType, String itemName, double unitPrice)
	{
		this.id = id;
		this.itemType = itemType;
		this.itemName = itemName; 
		this.untiPrice = unitPrice;
	}
	
	/**
	 * Gather transaction id 
	 * @return id
	 */
	public int getId()
	{
		return this.id;
	}
	
	/**
	 * Gather the item type 
	 * @return itme type
	 */
	public String getItemType()
	{
		return this.itemType;
	}
	
	/**
	 * Gather the item name 
	 * @return itme name
	 */
	public String getItemName()
	{
		return this.itemName;
	}
	
	/**
	 * Gather the unit price 
	 * @return unit price
	 */
	public double getUnitPrice()
	{
		return this.untiPrice;
	}
}
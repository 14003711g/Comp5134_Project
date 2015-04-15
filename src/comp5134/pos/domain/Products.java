package comp5134.pos.domain;

/**
 * This class is a super class for all productions of this POS
 * @author Raymond Kwan
 *
 */
public abstract class Products {
	String name;
	double unitPrice;
	
	/**
	 * Constructor for subclass. It will be default empty as the product name and 0.00 as the unit price respectively 
	 */
	public Products()
	{
		this.name = "";
		this.unitPrice = 0.00;
	}
	
	/**
	 * Constructor for subclass with provided name and unit price 
	 * @param name String
	 * @param unitPrice double
	 */
	public Products(String name, double unitPrice)
	{
		this.name = name;
		this.unitPrice = unitPrice;
	}
	
	/**
	 * Gather product name 
	 * @return product name
	 */
	public String getName()
	{
		return this.name;
	}
	
	/**
	 * Assign product name 
	 * @param product name is a String
	 */
	public void setName(String name)
	{
		this.name = name;
	}
	
	/**
	 * Gather product unit price 
	 * @return product unit price
	 */
	public double getUnitPrice()
	{
		return this.unitPrice;
	}
	
	/**
	 * Assign product unit price 
	 * @param product unit price is a double
	 */
	public void setUnitPrice(double unitPrice)
	{
		this.unitPrice = unitPrice;
	}
}

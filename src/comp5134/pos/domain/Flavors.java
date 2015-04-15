package comp5134.pos.domain;

import comp5134.pos.system.SystemSetting;

/**
 * This class is used to create a new instance of ice-cream flavor. Must be implemented "checkOverLimit" which is used to check the user selected count.
 * @author Raymond Kwan
 * @see This is the child class of Product
 * 
 */
public final class Flavors extends Products implements ProductInterface {
	String name;
	double unitPrice;
	
	/**
	 * Create a new ice-cream flavor instance with provided name and unit price 
	 * @param name String
	 * @param unitPrice double
	 */
	public Flavors(String name, double unitPrice)
	{
		super(name, unitPrice);
	}

	/**
	 * This function is used to check the select flavor item(s) whether over the defined limit at SystemSetting.java 
	 * @param checkValue an integer; -1 means infinite
	 * @return true if over limit ; false if not over limit
	 * @exception will be return true if there is any exception
	 */
	@SuppressWarnings("unused")
	public boolean checkOverLimit(int checkValue)
	{
		try
		{
			return (SystemSetting.flavorLimit == -1 ? false : (checkValue + 1 > SystemSetting.flavorLimit ? true : false));
		}
		catch (Exception ex)
		{
			return true;
		}
		
	}
}

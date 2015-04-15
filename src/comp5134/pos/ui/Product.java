package comp5134.pos.ui;

import javax.swing.JButton;

/**
 * This is a super class which allow ice-cream flavor or decorator button as which child class 
 * @author Raymond Kwan
 *
 */
public class Product extends JButton {
	protected String name;
	protected double unitPrice;

	/**
	 * This is used to create a product instance
	 * @param caption is a String
	 * @param unitPrice is double
	 */
	public Product(String caption, double unitPrice)
	{
		super(caption + ", $" + String.valueOf(unitPrice));
		this.name = caption;
		this.unitPrice = unitPrice;
		this.setEnabled(false);
	}
	
	/**
	 * Gather the button caption
	 */
	public String getName()
	{
		return this.name;
	}
	
	/**
	 * Assign the button caption which will show on UI
	 * @param name is a String
	 */
	public void setName(String name)
	{
		this.name = name;
	}
	
	/**
	 * Gather the product unit price
	 */
	public double getUnitPrice()
	{
		return this.unitPrice;
	}
	
	/**
	 * Assign the unit price which will show on UI too
	 * @param unitPrice is a double
	 */
	public void setUnitPrice(double unitPrice)
	{
		this.unitPrice = unitPrice;
	}
}

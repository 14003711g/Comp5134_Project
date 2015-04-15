package comp5134.pos.ui;

/**
 * This is a child class of super class, Product
 * @author Raymond Kwan
 *
 */
public final class Decorator extends Product {
	/**
	 * This is used to create a decorator instance
	 * @param caption is a String
	 * @param unitPrice is double
	 */
	public Decorator(String caption, double unitPrice)
	{
		super(caption, unitPrice);
	}
}

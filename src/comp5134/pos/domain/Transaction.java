package comp5134.pos.domain;

/**
 * This class is used to represent a transaction and does not extended by other class
 * @author Raymond Kwan
 *
 */
public final class Transaction {
	int id;
	double amount;
	String createdTime;
	String createdBy;
	
	/**
	 * Constructor of transaction 
	 */
	public Transaction(int id, double amount, String createdTime, String createdBy)
	{
		this.id = id;
		this.amount = amount;
		this.createdTime = createdTime;
		this.createdBy = createdBy;  
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
	 * Gather transaction amount 
	 * @return amount
	 */
	public double getAmount()
	{
		return this.amount;
	}
	
	/**
	 * Gather create time of transaction 
	 * @return create time
	 */
	public String getCreatedTime()
	{
		return this.createdTime;
	}
	
	/**
	 * Gather creator of transaction 
	 * @return creator
	 */
	public String getCreatedBy()
	{
		return this.createdBy;
	}
}
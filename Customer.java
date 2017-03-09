
public class Customer
{
	private String customerID;
	private int timeWaiting;
	private boolean impatient;
	private static int MAX_WAIT_TIME = 10;
	int current = 0;
	private boolean inQueue;
	private int seatNumber;

	public Customer(String customerID, boolean inQueue)
	{
		this.customerID = customerID;
		inQueue = false;
		this.inQueue=inQueue;	
		seatNumber=9999;
	}

	public String getName()
	{
		customerID = generateID();
		return customerID;
	}
	
	// Generates an ID based on the current integer value.
	public String generateID()
	{
		current++;
		return "" + current/2;
	}
	
	public boolean isImpatient()
	{
		if(timeWaiting >= MAX_WAIT_TIME)
		{
			return true;
		}
		else return false;
	}
	
	
	public void setInQueue()
	{
		inQueue=true;
	}

	public int timeWaiting(Customer c)
	{
		if(isInQueue(c))
		{
			return timeWaiting++;
		}
		else return timeWaiting;
	}

	public boolean isInQueue(Customer c)
	{
		if(c.inQueue==true)
		{
			return true;
		}
		return false;
	}
	
	public void setSeatNumber(int value)
	{
		seatNumber=value;
	}
	
}

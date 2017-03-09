import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Random;

public class HSeller extends Thread
{
	private int waitTime;
	private int cost;
	private String sellerID;
	private List<Integer> sellerPattern= Arrays.asList(1,2,3,4,5,6,7,8,9,10);
	private int sold;
	private Queue<Customer> customers;
	
	
	public HSeller(String sellerID)
	{ 
		waitTime = generateWaitTime();
		this.sellerID = sellerID;
		sold=0;
		customers = new LinkedList<Customer>();
		//test = new Theatre();
	}
	
	private int generateWaitTime()
	{
		return new Random().nextInt(2);
	}
	
	public List<Integer> getList()
	{
		return sellerPattern;
	}
	public void incrementSold()
	{
		sold++;
	}
	
	private int getSold()
	{
		return sold;
	}
	
	public Queue<Customer> getQueue()
	{
		return customers;
	}
	
	public void addtoQueue(Customer customer)
	{
		customer.setInQueue();
		customers.add(customer);
	}
	
	public Customer remove()
	{
		return customers.remove();
	}

	
	public void startSelling()
	{
		int hSoldNumber=0;
		int seatNumber=1;
		Theatre hold = new Theatre();
		for(int i = 0; i < 100; i++)
		{
			String temp = "" + i;
			Customer customer = new Customer("H" + temp, false);
			
			Seats[][] test = hold.getLayout();
			for(int j=0; j <test.length; j++)
			{
				for(int h=0; h<test[j].length; h++)
				{
					if(test[j][h].getIsSold()==false)
					{
						Seats seat = test[j][h];
						seat.setCustomerName(customer.getName());
						seat.setIsSold();
						seat.setSellerName("H");
						seat.setCustomerName("H" + seatNumber);
						seatNumber++;
						//hSoldNumber++;
						

						String number = (j+"")+(h+"");
						customer.setSeatNumber(Integer.parseInt(number));
						hold.addToSeat(customer);
						hSoldNumber++;
					
					}
					else
					{
						continue;
					}
				}
			}
		}
		hold.printSeats();
	}
}



import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Random;

public class LSeller extends Thread 
{
	private int waitTime;
	private int cost;
	private String sellerID;
	private List<Integer> sellerPattern= Arrays.asList(10,9,8,7,6,5,4,3,2,1);
	private int sold;
	Queue<Customer> customers;
	
	public LSeller(String sellerID)
	{
		waitTime = generateWaitTime();
		this.sellerID = sellerID;
		sold=0;
		customers = new LinkedList<Customer>();
	}

	private int generateWaitTime()
	{
		return new Random().nextInt(4) +4;
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
	
	public void addtoQueue(Customer customer)
	{
		customers.add(customer);
	}

	public Customer remove()
	{
		return customers.remove();
	}
	
	
	
	public void startSelling()
	{
		int hSoldNumber=0;
		Theatre hold = new Theatre();
		int seatNumber=1;
		for(int i = 0; i < 100; i++)
		{
			String temp = "" + i;
			Customer customer = new Customer("H" + temp, false);
			
			Seats[][] test = hold.getLayout();
		
			for(int j=test.length-1; j >=0; j--)
			{
				for(int h=test[j].length-1; h>=0; h--)
				{
					if(test[j][h].getIsSold()==false)
					{
						
						Seats seat = test[j][h];
						seat.setCustomerName(customer.getName());
						seat.setIsSold();
						seat.setSellerName("H");
						seat.setCustomerName("H" + customer.getName());
						

						String number = (j+"")+(h+"");
						customer.setSeatNumber(seatNumber);
						seatNumber++;
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

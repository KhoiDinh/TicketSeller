import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Random;

public class MSeller extends Thread
{
	private int waitTime;
	private int cost;
	private String sellerID;
	private int sold;
	private List<Integer> sellerPattern=Arrays.asList(4,5,3,6,2,7,1,8,0,9);
	Queue<Customer> customers;

	public MSeller(String sellerID)
	{
		waitTime = generateWaitTime();
		this.sellerID=sellerID;
		sold=0;
		customers = new LinkedList<Customer>();
	}

	public List<Integer> getList()
	{
		return sellerPattern;
	}

	private int generateWaitTime()
	{
		return new Random().nextInt(3) +2;
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
		int seatNumber=1;
		//int whichRow=0;
		int count=0;
		Theatre hold = new Theatre();
		Seats[][] test = hold.getLayout();
		ArrayList<Customer> temporary = new ArrayList<Customer>();
		for(int i=0; i <100;i++)
		{
			Customer customer = new Customer(i+"", false);
			temporary.add(customer);
			
			
			for(int j=0; j <sellerPattern.size();j++)
			{
				int hold2 = sellerPattern.get(j);
				for(int k=0; k<test[hold2].length; k++)
				{
					if(test[hold2][k].getIsSold()==false)
					{
						
						Seats seat = test[hold2][k];
						seat.setCustomerName(customer.getName());
						seat.setIsSold();
						seat.setSellerName("H");
						seat.setCustomerName("H" + seatNumber);
						seatNumber++;
						
						String number = (hold2+"")+(k+"");
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

import java.util.ArrayList;

public class Seller
{
	ArrayList<Integer> tickets;
	
	public Seller()
	{
		tickets = new ArrayList<Integer>();
		for(int i=0; i<100; i++)
		{
			tickets.add(i);
		}
	}
	
	public void removeTicket(int value)
	{
		for(int i=0; i <tickets.size();i++)
		{
			if(tickets.get(i) == value)
			{
				tickets.remove(i);
			}
		}
	}
}

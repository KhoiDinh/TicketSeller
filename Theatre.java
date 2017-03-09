import java.util.ArrayList;

public class Theatre
{
	private Seats[][]  layout;
	
	
	public Theatre()
	{
		layout = new Seats[10][10];
		for(int i=0; i <layout.length; i++)
		{
			for(int j=0; j < layout[i].length; j++)
			{
				layout[i][j] = new Seats("---");
			}
		}
	}
	
	
	public void printSeats()
	{
		int count =0;
		for(int i=0; i <layout.length; i++)
		{
			for(int j=0; j <layout[i].length; j++)
			{
				
				if(count==9)
				{
					System.out.print(layout[i][j] +"\t");
					System.out.println();
					count=0;
				}
				else
				{
					System.out.print(layout[i][j].toString() +"\t");
					count++;
				}
				
			}
		}
	}
	
	public Seats[][] getLayout()
	{
		return layout;
	}
	
	public void addToSeat(Customer c)
	{

	}
}

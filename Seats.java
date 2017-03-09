
public class Seats 
{
	private boolean isSold;
	private String customerName;
	private String sellerName;
	
	public Seats(String customerName)
	{
		this.customerName= customerName;
		isSold=false;
		sellerName="";
	}
	
	public void setIsSold()
	{
		isSold= true;
	}
	
	public boolean getIsSold()
	{
		return isSold;
	}
	
	public void setCustomerName(String name)
	{
		customerName = name;
	}
	
	public String getCustomerName()
	{
		return customerName;
	}
	
	public void setSellerName(String sellerName)
	{
		this.sellerName=sellerName;
	}
	
	public String getSellerName()
	{
		return sellerName;
	}
	
	public String toString()
	{
		return getSellerName() + " " + getCustomerName() + " ";
	}
	
	
}

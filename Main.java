public class Main implements Runnable 
{
	Thread runner;
	public Main() 
	{
		this.runner = new Thread(this);
		this.runner.start();
		try {
			this.runner.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void run() 
	{
		//HSeller H = new HSeller("H");
		//H.startSelling();
		
		//LSeller L = new LSeller("L");
		//L.startSelling();
		
		MSeller M = new MSeller("M");
		M.startSelling();
		
		
	}

	public static void main(String[] args) 
	{
		new Main();
	}
}

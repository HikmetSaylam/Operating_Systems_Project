package pckg;


public class Process 
{
	private int arrivalTime;
	private int priority;
	private int burstTime;
	/*private ProcessBuilder builder;
	private java.lang.Process process;*/
	
	
	public Process(int arrivalTime,int priority,int burstTime)
	{
		this.arrivalTime=arrivalTime;
		this.priority=priority;
		this.burstTime=burstTime;
		/*this.builder= new ProcessBuilder();
		this.process =builder.start();*/
		
	}
	
	
	public int getArrivalTime() 
	{
		return arrivalTime;
	}


	public int getPriority() 
	{
		return priority;
	}


	public int getBurstTime() 
	{
		return burstTime;
	}
	
}

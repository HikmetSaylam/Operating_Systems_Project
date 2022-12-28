package pckg;

import java.io.IOException;

public class Proses //extends ProsesBuilder
{
	private int arrivalTime;
	private int priority;
	private int burstTime;
	private int remainingTime;
	
	/*private ProsesBuilder builder;
	private java.lang.Proses Proses;*/
	
	
	public Proses(int arrivalTime,int priority,int burstTime)
	{
		
		this.arrivalTime=arrivalTime;
		this.priority=priority;
		this.burstTime=burstTime;
		this.remainingTime=burstTime;
		
		/*this.builder= new ProsesBuilder();
		this.Proses =builder.start();*/
	  
	}
	
	public void ProsesRunning () throws IOException { // ProsesBuilding 
		
		 // create the Proses 
		//ProsesBuilder build = new ProsesBuilder( ProsesDurum + "Gelme zamani :" + String.valueOf(this.arrivalTime) +" Öncelik: "+ String.valueOf(this.priority) + " Toplam zaman: " + String.valueOf(this.burstTime) + " Kalan zaman:"+ String.valueOf(this.remainingTime)); 
		Process process;
		ProcessBuilder build = new ProcessBuilder("prosess basladi");
		ProcessBuilder build2 = new ProcessBuilder("cmd.exe","/c","echo");
		process = build2.start();
		// checking the command 
        System.out.println("command: " + build.command()); 	
        
	}
	public void ProsesDurum() {
		 System.out.println(this.arrivalTime +" "+ this.priority +" " + this.burstTime + " " + this.getRemainingTime() + " "); 	
		
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
	
	public int getRemainingTime()
	{
		return remainingTime;
	}
	
	public void updateRemainingTime()
	{ 
		remainingTime--;
	}
}


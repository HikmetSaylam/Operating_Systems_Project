package pckg;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ProcessManager 
{
	private List<Process> processList;
	private Queue<Process> firstQueue,secondQueue,thirdQueue,fourthQueue;
	
	public ProcessManager()
	{
		processList=new ArrayList<Process>();
		firstQueue=new LinkedList<Process>();
		secondQueue=new LinkedList<Process>();
		thirdQueue=new LinkedList<Process>();
		fourthQueue=new LinkedList<Process>();
	}
	
	
	public void addProcessToList(Process process)
	{
		processList.add(process);
	}
	
	public void writeProcess()
	{
		for (Process process : processList) 
		{
			System.out.println(process.getBurstTime());
		}
	}
}

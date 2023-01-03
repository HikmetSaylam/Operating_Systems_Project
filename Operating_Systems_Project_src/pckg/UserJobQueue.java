package pckg;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.List;

public class UserJobQueue {
	
	public List<Proses> firstQueue,secondQueue,thirdQueue;
	
	public UserJobQueue (){
		
		firstQueue=new LinkedList<Proses>();
		secondQueue=new LinkedList<Proses>();
		thirdQueue=new LinkedList<Proses>();
		
	}

	public List<Proses> ReSortSecondQueue ()
	{
		Iterator<Proses> iteratorQueue = this.secondQueue.iterator();
	
		return secondQueue;
	}
	
	public List<Proses> ReSortThirdQueue ()
	{
		Iterator<Proses> iteratorQueue = this.secondQueue.iterator();
	
		
		return thirdQueue;
	}
	
	
	public void  SendMultiLevelQueue( JobDispatch jobDispatch) //user job kuyrugundaki prosesleri 3 seviyeli geri beslemeli kuyruga aktarir
	{
		
		for (Proses Proses : jobDispatch.UserQueue) 
			
			if(Proses.getPriority()==1)
			{
			firstQueue.add(Proses);
			} 
			else if (Proses.getPriority()==2) 
			{
			 secondQueue.add(Proses);
			}
			else {	
				thirdQueue.add(Proses);
			}
	}

}

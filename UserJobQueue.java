package pckg;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class UserJobQueue {
	
	public Queue<Proses> firstQueue,secondQueue,thirdQueue;
	
	public UserJobQueue (){
		
		firstQueue=new LinkedList<Proses>();
		secondQueue=new LinkedList<Proses>();
		thirdQueue=new LinkedList<Proses>();
		
	}

	/*
	public Queue<Proses> ReSortSecondQueue ()
	{
		Iterator<Proses> iteratorQueue = this.secondQueue.iterator();
	
		return secondQueue;
	}
	
	public Queue<Proses> ReSortThirdQueue ()
	{
		Iterator<Proses> iteratorQueue = this.secondQueue.iterator();
	
		
		return thirdQueue;
	}
	*/
	
	public void  SendMultiLevelQueue( JobDispatch jobDispatch ,int time) //user job kuyrugundaki prosesleri 3 seviyeli geri beslemeli kuyruga aktarir
	{
		
		for (Proses Proses : jobDispatch.UserQueue) 
			
			if(Proses.getPriority()==1 && Proses.getArrivalTime()<=time)
			{
			firstQueue.add(Proses);
			} 
			else if (Proses.getPriority()==2  && Proses.getArrivalTime()<=time) 
			{
			 secondQueue.add(Proses);
			}
			else if( Proses.getArrivalTime()<=time) {	
				thirdQueue.add(Proses);
			}
	}

}

package pckg;

import java.util.LinkedList;
import java.util.Queue;

public class QueueClass{
	
	private Queue<Proses> RealTimeQueue,UserQueue,firstQueue,secondQueue,thirdQueue;
	
	public QueueClass() {
		
			UserQueue=new LinkedList<Proses>();
			RealTimeQueue=new LinkedList<Proses>();
			firstQueue=new LinkedList<Proses>();
			secondQueue=new LinkedList<Proses>();
			thirdQueue=new LinkedList<Proses>();
			
			}

}

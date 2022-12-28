package pckg;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Iterator;

public class JobDispatch 
{
	private FCFS fcfs;
	public List<Proses> ProsesList;
	public Queue<Proses> RealTimeQueue,UserQueue,gecicireal;

	
	public JobDispatch()
	{
		ProsesList=new ArrayList<Proses>();
		UserQueue=new LinkedList<Proses>();
		RealTimeQueue=new LinkedList<Proses>();
		gecicireal=new LinkedList<Proses>();
		
	}
	
	public void addProsesToList(Proses Proses)
	{
		ProsesList.add(Proses);
	}
	
	public void scanProsesList ( JobDispatch jobDispatch) // proses listesini dolarasak gercek zamanli ya da user job kuyruguna aktarir.
	{
		
		for (Proses Proses : ProsesList) 
		{  
			
			if( Proses.getPriority()==0 )
			{
				jobDispatch.RealTimeQueue.add(Proses);
				
				/*fcfs.findWaitingTime(RealTimeQueue);
				System.out.println(RealTimeQueue.size());
				System.out.println(RealTimeQueue.peek());
				RealTimeQueue.remove();*/
				
			}
			
			 else {
				jobDispatch.UserQueue.add(Proses);
			
			}
		
			//System.out.println(Proses.getBurstTime());
		}
	}
	
	public void scanQueues(UserJobQueue userjob ,int time) throws IOException //kuyruklari dolasarak konsola yazdiriyoruz
	{
		MultiLevelQueue multilevelQueue;
		multilevelQueue = new MultiLevelQueue();
		Iterator<Proses> iterator=RealTimeQueue.iterator();
		System.out.println("\nRealtime Queue");
		int sonuc=0;
		//int time=0;
		//realtimequeue yu geziyor 
		while(true)
		{
			
			if(iterator.hasNext()) // en yuksek oncelıklı kuyruk dolu ıse 
			{
					Proses pro=iterator.next(); // gercek zamanli kuyruktaki ilk proses aliniyor
					
					
					//Proseslerin varis  zamani ile time Ä± karÅŸÄ±laÅŸtÄ±rÄ±yor varÄ±ÅŸ zamanÄ± timeden bÃ¼yÃ¼kse dÃ¶ngÃ¼den Ã§kÄ±yor.
					if(pro.getArrivalTime()>time) // yuksek oncelikli kuyrugun zamani gelmediyse
					{
						 userjob.SendMultiLevelQueue(this, time);
						//burada dusuk oncelıklı kuyruklar calısabılır
						System.out.println("time:" +time +"");
						sonuc=multilevelQueue.RunMultiLevelQueue(userjob , time);
						if(sonuc==1) { time++; }
					
						
						
					}
					else  //varÄ±ÅŸ zamanÄ± timeden kuÃ§Ã¼k ya da esit olnalari gecici bir queya atayÄ±p realtime queue'sundan atanan procesleri siliyor.
					{
						
						// gecicireal.add(pro);
						int sayacStart=0;
						//burada yuksek oncelikli prosesı direkt calistirsin
						while(pro.getRemainingTime()>= 0) // kalan zaman 0 olana kadar calıstırıp kalan zaman guncellensın
						{
							
							
							if (sayacStart==0)
							{
								
								pro.ProsesRunning(); //prosess builder
								pro.ProsesDurum();
								sayacStart++;
							}
							else 
							{
								pro.ProsesDurum();
							}
							pro.updateRemainingTime();
							
							
						}
						//iterator.remove(); 
						time+=pro.getBurstTime();
						System.out.println("time:" +time +" ");
					// bu kısım hatali olabilir
						
						
						
					}
					
					iterator.remove();
					
					
					
			}
			
			else { // en yuksek oncelıklı kuyruk bos ıse user kuyruklar kontrol edilip calistirilir.
				
				 userjob.SendMultiLevelQueue(this, time);
				System.out.println("\n time:" +time +"");
				sonuc=multilevelQueue.RunMultiLevelQueue(userjob,time);
				if(sonuc==1) { time++; }
				
			
				
			}
			if (sonuc==0) break; // mlqueue bos ıse 0 doner
		}
		//fcfs.findavgTime(gecicireal);//fcfs Ã§alÄ±ÅŸÄ±yor
		//gecicireal.clear();// geÃ§iÃ§i queue temizleniyor.
		/*System.out.println("\nUserJob Queue");
		for (Proses Proses : UserQueue) 
		{	
			System.out.println(Proses.getPriority());
			
			
		}
		
		
		System.out.println("\nFirst Queue");
		for (Proses Proses : userjob.firstQueue) 
		{
			System.out.println(Proses.getPriority());
		}
		
		System.out.println("\nSecond Queue");
		for (Proses Proses : userjob.secondQueue) 
		{
			System.out.println(Proses.getPriority());
		}
		
		System.out.println("\nThird Queue");
		for (Proses Proses : userjob.thirdQueue) 
		{	
			System.out.println(Proses.getPriority());
		}*/
	}

	
	/*
	public void writeProses()
	{
		for (Proses Proses : ProsesList) 
		{
			System.out.println(Proses.getBurstTime());
		}
	}
	*/
	}

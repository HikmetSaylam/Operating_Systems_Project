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
	public List<Proses> RealTimeQueue,UserQueue,gecicireal;



	
	
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
		int time=0;
		for (Proses Proses : ProsesList) 
		{  
			
			if( Proses.getPriority()==0 && Proses.getArrivalTime()<=time)
			{
				jobDispatch.RealTimeQueue.add(Proses);
				time+= Proses.getBurstTime();
				/*fcfs.findWaitingTime(RealTimeQueue);
				System.out.println(RealTimeQueue.size());
				System.out.println(RealTimeQueue.peek());
				RealTimeQueue.remove();*/
				
				
			}
			
			 else if (Proses.getArrivalTime()<=time){
				jobDispatch.UserQueue.add(Proses);
				time++;
			}
		
			//System.out.println(Proses.getBurstTime());
		}
	}
	
	public void scanQueues(UserJobQueue userjob) throws IOException //kuyruklari dolasarak konsola yazdiriyoruz
	{
		MultiLevelQueue multilevelQueue;
		multilevelQueue = new MultiLevelQueue();
		Iterator<Proses> iterator=RealTimeQueue.iterator();
		System.out.println("\nRealtime Queue");
		int sonuc=0;
		int time=0;
		//realtimequeue yu geziyor 
		while(true)
		{
			
			if(iterator.hasNext()) // en yuksek oncelıklı kuyruk dolu ıse 
			{
					Proses pro=iterator.next(); // gercek zamanli kuyruktaki ilk proses aliniyor
					//Proseslerin varis  zamani ile time Ä± karÅŸÄ±laÅŸtÄ±rÄ±yor varÄ±ÅŸ zamanÄ± timeden bÃ¼yÃ¼kse dÃ¶ngÃ¼den Ã§kÄ±yor.
					if(pro.getArrivalTime()>time) // yuksek oncelikli kuyrugun zamani gelmediyse
					{
						System.out.println("time:" +time +"");
						time=multilevelQueue.RunMultiLevelQueue(userjob , time,pro.getArrivalTime());
						System.out.println(pro.getArrivalTime()+": arrival ,time: "+time);
						if(pro.getArrivalTime()<=time)
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

					}
					else
					{
						if(pro.getArrivalTime()>time)
						{
							break;
						}
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

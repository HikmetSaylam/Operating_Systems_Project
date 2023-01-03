package pckg;

import java.io.IOException;
import java.util.Iterator;
import java.util.Queue;
import java.util.List;

public class MultiLevelQueue {
	
	
	
	public MultiLevelQueue ( ) 
	{
		
		
	}

	

	public int RunMultiLevelQueue(UserJobQueue userjobQueue, int time,int fcfsarrival) throws IOException
	{
		Iterator<Proses> iteratorUser1 =userjobQueue.firstQueue.iterator(); // ilk kullanici kuyrugu icin iterator
		Iterator<Proses> iteratorUser2 =userjobQueue.secondQueue.iterator();
		Iterator<Proses> iteratorUser3 =userjobQueue.thirdQueue.iterator();
	
		Proses firstProses=iteratorUser1.next();  // buraları kontrol et
		Proses secondProses=iteratorUser2.next();
		Proses thirdProses=iteratorUser3.next();
		
		if(iteratorUser1.hasNext() && firstProses.getArrivalTime()<=time) // eger ilk kullanici kuyrugu bos degilse ilk prosesi bir sn calissin
		{
			
			
				firstProses.ProsesRunning(); //Proses builder
				firstProses.ProsesDurum();
				// user1'in kalan zamani azaltilip alt kuyruga gonderilecek.
				firstProses.updateRemainingTime(); // prosessin kalan zamanini 1 sn azaltsin
				firstProses.ProsesDurum();
				time++;
			
			
			if(firstProses.getRemainingTime()!=0)
			{
				for(Proses proses :userjobQueue.secondQueue)
				{
					if(proses.getArrivalTime()>=time)
					{
						userjobQueue.secondQueue.add(userjobQueue.secondQueue.indexOf(proses),firstProses);
						break;
					}
				}
			}
			iteratorUser1.remove();
			//userjobQueue.firstQueue.remove(0);// kuyruktaki ilk prosesi kaldirir.
			if(time>=fcfsarrival) 
			{
				return  time;
			}
		}
		else if  (iteratorUser2.hasNext() && secondProses.getArrivalTime()<=time )
		{
			
			
				secondProses.ProsesRunning(); //Proses builder
				secondProses.ProsesDurum();
				// user1'in kalan zamani azaltilip alt kuyruga gonderilecek.
				secondProses.updateRemainingTime(); // prosessin kalan zamanini 1 sn azaltsin
				secondProses.ProsesDurum();
				time++;
				if(secondProses.getRemainingTime()!=0)
				{
					for(Proses proses :userjobQueue.thirdQueue)
					{
						if(proses.getArrivalTime()>=time)
						{
							userjobQueue.thirdQueue.add(userjobQueue.thirdQueue.indexOf(proses),secondProses);
							break;
						}
					}
				}

				iteratorUser2.remove();
				//userjobQueue.secondQueue.remove(0);// kuyruktaki ilk prosesi kaldirir.
				if(time>=fcfsarrival)  
				{
					return time;
				}
		}
		else if (iteratorUser3.hasNext() && thirdProses.getArrivalTime()>time ) // buradaki prosesler 1 sn calisip kuyrugun sonuna yollanıcak , rr modu
		{
			thirdProses.ProsesRunning(); //Proses builder
			thirdProses.ProsesDurum();
			// user1'in kalan zamani azaltilip alt kuyruga gonderilecek.
			thirdProses.updateRemainingTime(); // prosessin kalan zamanini 1 sn azaltsin
			thirdProses.ProsesDurum();
			time++;
			System.out.println("ücüncğkuyruk");
			
				if(thirdProses.getRemainingTime()!=0)
				{
					for(Proses proses :userjobQueue.thirdQueue)
					{
						if(proses.getArrivalTime()>time)
						{
							System.out.println("ücüncükuyurk sona ekleme");
							userjobQueue.thirdQueue.add(userjobQueue.thirdQueue.indexOf(proses),thirdProses);
							break;
						}
					}
	
				}
				userjobQueue.thirdQueue.remove(0);
				if(time>=fcfsarrival) return time;
				// kuyruktaki ilk prosesi kaldirir.
			
		}
		return time;
		
	}
}


package pckg;

import java.io.IOException;
import java.util.Iterator;
import java.util.Queue;

public class MultiLevelQueue {
	
	
	
	public MultiLevelQueue ( ) 
	{
		
		
	}

	

	public int RunMultiLevelQueue(UserJobQueue userjobQueue, int time) throws IOException
	{
		Iterator<Proses> iteratorUser1 =userjobQueue.firstQueue.iterator(); // ilk kullanici kuyrugu icin iterator
		Iterator<Proses> iteratorUser2 =userjobQueue.secondQueue.iterator();
		Iterator<Proses> iteratorUser3 =userjobQueue.thirdQueue.iterator();
	
		
			Proses firstProses=iteratorUser1.next(); 
			Proses secondProses=iteratorUser2.next();
			Proses thirdProses=iteratorUser1.next(); 
			
		
		 // buraları kontrol et
		
		
		
		
		if( firstProses.getArrivalTime()<=time) // eger ilk kullanici kuyrugu bos degilse ilk prosesi bir sn calissin
		{
			
			
				firstProses.ProsesRunning(); //Proses builder
				firstProses.ProsesDurum();
				// user1'in kalan zamani azaltilip alt kuyruga gonderilecek.
				firstProses.updateRemainingTime(); // prosessin kalan zamanini 1 sn azaltsin
				firstProses.ProsesDurum();
				
			
			
			if(firstProses.getRemainingTime()!=0)
			{
				userjobQueue.secondQueue.add(firstProses); //prosesın kalan zamanı sıfır degılse alt kuyruga yollar
				// askıya alma yapilacak
			}
			userjobQueue.firstQueue.remove();// kuyruktaki ilk prosesi kaldirir.
			
		}
		else if  (iteratorUser2.hasNext() && secondProses.getArrivalTime()<=time )
		{
			
		
				secondProses.ProsesRunning(); //Proses builder
				secondProses.ProsesDurum();
				// user1'in kalan zamani azaltilip alt kuyruga gonderilecek.
				secondProses.updateRemainingTime(); // prosessin kalan zamanini 1 sn azaltsin
				secondProses.ProsesDurum();
			
			
			
				if(secondProses.getRemainingTime()!=0)
				{
					userjobQueue.thirdQueue.add(secondProses); //prosesın kalan zamanı sıfır degılse alt kuyruga yollar
					// askiya alma yapilacak
				}
				userjobQueue.secondQueue.remove();// kuyruktaki ilk prosesi kaldirir.
		}
		else if (iteratorUser3.hasNext() && thirdProses.getArrivalTime()<=time ) // buradaki prosesler 1 sn calisip kuyrugun sonuna yollanıcak , rr modu
		{
			
			
			thirdProses.ProsesRunning(); //Proses builder
			thirdProses.ProsesDurum();
			// user1'in kalan zamani azaltilip alt kuyruga gonderilecek.
			thirdProses.updateRemainingTime(); // prosessin kalan zamanini 1 sn azaltsin
			thirdProses.ProsesDurum();
			
		
			
				if(thirdProses.getRemainingTime()!=0)
				{
					userjobQueue.thirdQueue.add(thirdProses); //  prosesın kalan zamanı sıfır degılse kuyrugun sonuna yollar
					// askıya alma yapilacak
				}
				userjobQueue.thirdQueue.remove();// kuyruktaki ilk prosesi kaldirir.
			
		}
		else {return 0;} // eger 3 kutuk da bos ise 
		
		return 1;
		
	}
}


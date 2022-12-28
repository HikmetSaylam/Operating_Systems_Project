package pckg;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main 
{
	  

	public static void main(String[] args) throws IOException 
	{
		int time=0;
		DataReader dataReader=new DataReader(new File("data.txt"));
		JobDispatch jobDispatch=new JobDispatch();
		UserJobQueue userjob = new UserJobQueue();
		
		dataReader.read(jobDispatch); // data reader data.txt yi satir satir okur. Job dispatch nesnesi ile okuma sonunda job dispatchde bulunan Proses listesine ekleme yapar.
		jobDispatch.scanProsesList(jobDispatch); // olusturdugumuz Proses listesini dolasarak prosesleri gercek zamanli kuyruga ya da user job kuyruguna ekler.
		//userjob.SendMultiLevelQueue(jobDispatch,time);
		jobDispatch.scanQueues(userjob,time);
		 // userjob nesnesi, az once olusturudugumuz user job kuyrugundaki prosesleri onceliklerine gore multilevel kuyruklara yerlestirir.
		
	 // tum kuyruklar dolasilir ve oncelikleri konsola yazdirilir.
	
		//jobDispatch.writeProses();
	}
	

}

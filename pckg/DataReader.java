package pckg;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class DataReader 
{
	private static Scanner scanner;
	
	@SuppressWarnings("static-access")
	public DataReader(File fileName) throws FileNotFoundException
	{
		this.scanner=new Scanner(fileName);
	}
	
	public void read(JobDispatch jobDispatch) 
	{
		while(scanner.hasNextLine())
		{
			String line =scanner.nextLine();
			String word="";
			int arrivalTime = 0, priority = 0, burstTime=0;
			int commaCounter=0;
			for(int i=0;i<line.length();i++)
			{
				if(line.charAt(i)!=','&&i<=line.length()-1)
				{
					if(line.charAt(i)!=' ')
					{
						word+=Character.toString(line.charAt(i));
					}
					else
					{
						continue;
					}
					if(i==line.length()-1)
					{
						burstTime=Integer.valueOf(word);
						word="";
					}
				}
				else if(line.charAt(i)==',')
				{
					if(commaCounter++%2==0)
					{
						arrivalTime=Integer.valueOf(word);
						word="";
					}
					else
					{
						priority=Integer.valueOf(word);
						word="";
					}
				}
			}
			
			jobDispatch.addProsesToList(new Proses(arrivalTime, priority, burstTime));
		}
	}
	

}

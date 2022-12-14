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
		DataReader dataReader=new DataReader(new File("data.txt"));
		ProcessManager processManager=new ProcessManager();
		dataReader.read(processManager);
		processManager.writeProcess();
	}
	

}

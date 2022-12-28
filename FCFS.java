package pckg;

import java.util.Queue;

public class FCFS {
	// Function to find the waiting time for all
    // Proseses
	static int[] findWaitingTime(Queue<Proses> realTimeQueue) 
	{	
		int n=realTimeQueue.size();
		int bt[]=new int[n];
		int wt[]=new int[n];
		int j=0;
		for (Proses Proses : realTimeQueue) 
		{  
			bt[j]=Proses.getBurstTime();
			j++;
		}
		
        // waiting time for first Proses is 0
        wt[0] = 0;
 
        // calculating waiting time
        for (int i = 1; i < n; i++) {
            wt[i] = bt[i - 1] + wt[i - 1];
        }
        int c=0;
        for (Proses Proses : realTimeQueue) 
		{  
	//System.out.println("bekleme zamanı:"+wt[c]);
			c++;
		}
        return wt;
    }
 
    // Function to calculate turn around time
    static int[] findTurnAroundTime(Queue<Proses> realTimeQueue)
    {
    	int n=realTimeQueue.size();
		int bt[]=new int[n];
		int wt[]=new int[n];
		int tat[]=new int[n];
		int j=0;
		for (Proses Proses : realTimeQueue) 
		{  
			bt[j]=Proses.getBurstTime();
			j++;
		}
		
        // waiting time for first Proses is 0
        wt[0] = 0;
 
        // calculating waiting time
        for (int i = 1; i < n; i++) {
            wt[i] = bt[i - 1] + wt[i - 1];
        }
        // calculating turnaround time by adding
        // bt[i] + wt[i]
        for (int i = 0; i < n; i++) {
            tat[i] = bt[i] + wt[i];
        //  System.out.println("turnaround time: "+tat[i]);
        }
        return tat;
    }
 
    //Function to calculate average time
    static void findavgTime(Queue<Proses> realTimeQueue)
    {
    	int n=realTimeQueue.size();
		int bt[]=new int[n];
        int wt[] = findWaitingTime(realTimeQueue);
        int  tat[] =findTurnAroundTime(realTimeQueue);
        int total_wt = 0, total_tat = 0;
        int j=0;
        for (Proses Proses : realTimeQueue) 
		{  
			bt[j]=Proses.getBurstTime();
			j++;
		}
        //Function to find waiting time of all Proseses
        findWaitingTime(realTimeQueue);
 
        //Function to find turn around time for all Proseses
        findTurnAroundTime(realTimeQueue);
 
        //Display Proseses along with all details
        System.out.printf("Proseses Burst time Waiting"
                       +" time Turn around time\n");
 
        // Calculate total waiting time and total turn
        // around time
        for (int i = 0; i < n; i++) {
            total_wt = total_wt + wt[i];
            total_tat = total_tat + tat[i];
            System.out.printf(" %d \t ", (i + 1));
            System.out.printf("     %d \t ", bt[i]);
            System.out.printf("     %d \t", wt[i]);
            System.out.printf("     %d\n", tat[i]);
        }
        float s = (float)total_wt /(float) n;
        int t = total_tat / n;
        System.out.printf("Average waiting time = %f", s);
        System.out.printf("\n");
        System.out.printf("Average turn around time = %d ", t);
    }

}


/**
 * Calculate the value of pi by simulating throwing darts at a
 * dart board
 *
 * @author Rohan Jakhete
 * @version 12/2/2017
 */
import java.util.Scanner; 
public class EstimatePi
{
    public static long dartsNum() //inputs amount of darts inputted from user
    {
        Scanner in = new Scanner(System.in);       
        System.out.print("How many darts should be thrown in a trial?");
        String darts = in.next(); 
        long dartsNum =Long.parseLong(darts); 
        return dartsNum; 
    }
    
    public static long trialsNum() //inputs trials inputted from user
    {
        Scanner in = new Scanner(System.in); 
        System.out.print("How many trials would you like"); 
        String trials = in.next(); 
        long trialsNum = Long.parseLong(trials); 
        return trialsNum; 
    }    
    
    
    public static long hits(long numDarts) //calculates number of hits for one trial, with inputted number of darts
    {
        long numHits = 0;
        for (long i = 1; i <= numDarts; i++)
        {
            double randomx = Math.random();
            double randomy = Math.random();
        
        if(((Math.pow(randomx,2)) + (Math.pow(randomy,2))) <= 1)
                numHits++; 
        }     
        return numHits;
    }
    
    
    public static double calc(long numHits,long dartsNum)//calculates pi for one trial based on number of hits
    {
        double piValue = ((double)numHits/(double)dartsNum) * 4.0; 
        return piValue; 
    }  
        
    
    public static void main(String[] args)
    {
        long numDarts = dartsNum(); 
        long numTrials = trialsNum();
        double totalpi = 0.0; 
        for (long i = 1; i <= numTrials; i++)//loops methods for number of trials inputted from user
        {
            long numHits = hits(numDarts); 
            double pi = calc(numHits,numDarts); 
            totalpi += pi; 
            System.out.printf("%-5s%1s%10s%5f\n", "Trial[ ", i, "]: pi = ", pi); 
        }
        
        double average = totalpi / (double)(numTrials); //displays average value of pi
        System.out.printf("%-10s%5f", "Estimate of pi = ", average); 
        
        
        // Testing shows that individual values will take more than 1E9
        //number of darts to reach 3.141592
        
        
    }
}

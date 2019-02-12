import java.util.Scanner; 

public class JavaSample
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in); 
        System.out.print("Please input your name"); 
        String name = in.next(); 
        if (name.equalsIgnoreCase("Rohan"))
        {
            print("He is awesome"); 
        }
    }
}
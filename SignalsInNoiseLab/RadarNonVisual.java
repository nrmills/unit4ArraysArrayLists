import java.util.Scanner;

public class RadarNonVisual
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        
        //Stores the y value for the starting position of the monster
        int startPosY;
        
        //Stores the x value for the starting position of the monster
        int startPosX;
        
        //Stores the DY value of the monster's velocity
        int dy;
        
        //Stores the DX value of the monster's velocity
        int dx;
        
        //Assigns Parameter Values
        System.out.print("Enter StartPosY, StartPosX, DY, and DX (Separated by spaces):");
        startPosY = input.nextInt();
        startPosX = input.nextInt();
        dy = input.nextInt();
        dx = input.nextInt();
        
        //Initialize Radar Object
        Radar r1 = new Radar( 150, 150, startPosY, startPosX, dy, dx );
 
        //Run Scans
        for( int iterations = 0; iterations < 50; iterations++ )
        {
            r1.scan();
        }
        
        //Print out Results from Scan
        System.out.println(r1.getMonsterVelocity());
        
        
    }
}

public class BoundsError
{
    public static void main(String[] args)
    {
        int[] scores = new int[10];
        
        for( int i = 1; i <= scores.length; i++ )
        {
            scores[i-1] = i;
            System.out.println(scores[i-1]);
        }
    }
}
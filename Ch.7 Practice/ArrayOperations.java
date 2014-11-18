
public class ArrayOperations
{
    public static void main(String[] args)
    {
        double x[] = {8,4,5,21,7,9,18,2,100};
        
        System.out.println(x.length);
        
        System.out.println(x[0]);
        
        System.out.println(x.length-1);
        
        System.out.println(x.length-1);
        
        for( int i = 0; i < x.length; i++ )
        {
            System.out.println(x[i]);
        }
        
        for( int i = 0; i < x.length; i++ )
        {
            System.out.print(i+1);
            System.out.println(" "+x[i]);
        }
        
        for( int i = x.length; i > 0; i-- )
        {
            System.out.print(i);
            System.out.println(" "+x[i]);
        }
        
        for( double values : x )
        {
            System.out.println(values);
        }
    }
}
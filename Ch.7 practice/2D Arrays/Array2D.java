
public class Array2D
{
    private int[][] table = 
        {
            {1,2,3},
            {4,5,6},
            {7,8,9},
            {10,11,12}
        };

    public Array2D()
    {
    }
    
    public String toString()
    {
        String str = "";
        
        /**
         * |||||||||||||||||||||||||||||||||||||||||||||||||||||||||||
         * table.length = number of nested arrays in the table
         * table[row].length = number of elements in the nested arrays
         * |||||||||||||||||||||||||||||||||||||||||||||||||||||||||||
         * row = number of nested arrays
         * col = number of elements in nested arrays
         * |||||||||||||||||||||||||||||||||||||||||||||||||||||||||||
         */
        for( int row = 0; row < table.length; row++ )
        {
            for( int col = 0; col < table[row].length; col++ )
            {
                str += table[row][col] + "\t";
            }
            str += "\n";
        }
        
        return str;
    }
    
    public String extractRowNormalLoop( int row )
    {
        String str = "";
        System.out.println("Row "+row);
        for( int col = 0; col < table[row].length; col++ )
        {
            str += table[row][col] + "\t";
        }
        
        return str;
    }
    
    public String extractRowEnhancedLoop( int row )
    {
        String str = "";
        System.out.println("Row "+row);
        for( int element : table[row] )
        {
            str += element + "\t";
        }
        
        return str;
    }
    
    public String extractColumn( int col )
    {
        String str = "";
        System.out.println("Column "+1);
        for( int row = 0; row < table.length; row++ )
        {
            str += table[row][col] + "\n";
        }
        
        return str;
    }
    
    public static void main(String[] args)
    {
        Array2D table = new Array2D();
        System.out.println( table.toString());
        System.out.println( table.extractRowNormalLoop( 1 ));
        System.out.println( table.extractRowEnhancedLoop( 1 ));
        System.out.println( table.extractColumn( 2 ));
    }

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}

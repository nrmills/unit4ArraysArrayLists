import java.util.Scanner;

public class MagicSquares
{

    int[][] grid = new int[4][4];
    Scanner input = new Scanner(System.in);

    public void fillGrid()
    {
        //Creates Grid of Numbers
        for( int rowNum = 0; rowNum < 4; rowNum++ )
        {
            for( int colNum = 0; colNum < 4; colNum++ )
            {
                System.out.println("Row "+rowNum+" Column "+colNum+": ");
                grid[rowNum][colNum] = input.nextInt();
            }
        }
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
        for( int row = 0; row < grid.length; row++ )
        {
            for( int col = 0; col < grid[row].length; col++ )
            {
                str += grid[row][col] + "\t";
            }
            str += "\n";
        }
        
        return str;
    }

    public boolean checkMagicNum()
    {
        //Evaluates Horizontal
        int horizontalSum = 0;
        int lastTotal = 0;
        for( int rowNum = 0; rowNum < 4; rowNum++ )
        {
            for( int colNum = 0; colNum < 4; colNum++ )
            {
                horizontalSum += grid[rowNum][colNum];
            }
            if( rowNum == 0 )
            {
                lastTotal = horizontalSum;
            }
            if( lastTotal != horizontalSum )
            {
                return false;
            }
        }

        //Evaluates Vertical
        int verticalSum = 0;
        for( int colNum = 0; colNum < 4; colNum++ )
        {
            verticalSum = 0;
            for( int rowNum = 0; rowNum < 4; rowNum++ )
            {
                verticalSum += grid[rowNum][colNum];
            }

            if( colNum == 0 )
            {
                lastTotal = verticalSum;
            }

            if( lastTotal != verticalSum )
            {
                return false;
            }
        }

        //Evaluates decreasing diagonal row
        int decreasingDiag = 0;
        int increasingDiag = 0;
        int rowNum = 0;
        int colNum = 0;
        int OpRowNum = 4;
        int OpColNum = 4;
        while( rowNum < 4)
        {
            decreasingDiag += grid[rowNum][colNum];
            increasingDiag += grid[OpRowNum][OpColNum];
            rowNum++;
            colNum++;
            OpRowNum--;
            OpColNum--;
        }
        if( decreasingDiag != increasingDiag )
        {
            return false;
        }

        //Once all tests have been passed, return true
        return true;
    }
}

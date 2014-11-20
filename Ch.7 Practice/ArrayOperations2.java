
public class ArrayOperations2
{
    private int[] values;
    private int[] newArray;
    int temp;
    int currentSize;
    public ArrayOperations2(int[] initialValues)
    {
        values = initialValues;
        newArray = new int[values.length];
        currentSize = values.length;
    }

    public void swapFirstAndLast()
    {
        temp = values[0];
        values[values.length-1] = temp;
    }

    public void shiftRight()
    {
        temp = values[0];
        for( int index = 0; index < values.length; index++ )
        {
            if (index < values.length)
            {
                values[index] = values[index+1];
            }
            else
            {
                values[index] = temp;
            }
        }
    }

    public void replaceEvenElements(int replacement)
    {
        for( int index = 0; index < values.length; index++ )
        {
            if( values[index] % 2 == 0 )
            {
                values[index] = 0;
            }
        }
    }

    public void replaceSmallElements()
    {
        for( int index = 1; index < values.length-1; index++ )
        {
            temp = values[index];
            if( values[index] < values[index-1])    
            {
                values[index] = values[index-1];
            }
            else if( values[index] < values[index+1] )
            {
                values[index] = values[index+1];
            }
        }
    }

    public void removeMiddleElement()
    {
        if( values.length % 2 == 0 )
        {
            for( int index = 0; index < values.length; index++ )
            {
                if( (index+1)*2 != values.length &&
                    (index+1)*2 != (values.length+1))
                    {
                        newArray[index] = values[index];
                    }
            }
        }
        else
        {
            for( int index = 0; index < values.length; index++ )
            {
                if( (index*2)+1 != values.length)
                    {
                        newArray[index] = values[index];
                    }
            }
        } 
        values = newArray;
    }

    public void moveEvenElementsToFront()
    {
        for( int index = 0; index < values.length; index++ )
        {
            if( values[index] % 2 == 0 )
            {
                for( int miniIndex = 0; miniIndex < values.length; miniIndex++ )
                {
                    if ( values[miniIndex] % 2 != 0 )
                    {
                        temp = values[miniIndex];
                        values[miniIndex] = values[index];
                        values[index] = temp;
                        break;
                    }
                }
            }
        }
    }

    public int returnSecondLargest()
    {
        int secondLargest = 0;
        int largest = 1;
        for( int index = 0; index < values.length; index++ )
        {
            if( values[index] > largest )
            {
                secondLargest = largest;
                largest = values[index];
            }
        }
        return secondLargest;
    }

    public boolean checkIncreasingOrder()
    {
        temp = values[0];
        for( int index = 1; index < values.length; index++ )
        {
            if( temp > values[index] )
            {
                return false;
            }
            temp = values[index];
        }
        return true;
    }
    
    public boolean checkAdjacentDuplicates()
    {
        temp = values[0];
        for( int index = 1; index < values.length; index++ )
        {
            if( temp == values[index] )
            {
                return true;
            }
        }
        return false;
    }
    
    public boolean checkDuplicateElements()
    {
        newArray = values;
        for( int row = 0; row < values.length; row++ )
        {
            for( int col = 0; col < values.length; col++ )
            {
                if( values[row] == newArray[col] )
                {
                    return true;
                }
            }
        }
        return false;
    }
}
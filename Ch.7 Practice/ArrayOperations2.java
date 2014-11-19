
public class ArrayOperations2
{
    private int[] values;
    int temp;
    int currentSize;
    public ArrayOperations2(int[] initialValues)
    {
        values = initialValues;
        currentSize = values.length;
    }

    public void swapFirstAndLast()
    {
        temp = values[0];
        values[0] = values[values.length-1];
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
            values[values.length/2] = values[currentSize-1];
            values[(values.length/2)+1] = values[currentSize-1];
            currentSize-=2;
        }
        else
        {
            values[(values.length/2)+1] = values[currentSize-1];
            currentSize--;
        }
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
        for( int index = 0; index < values.length; index++ )
        {
        }
    }
}
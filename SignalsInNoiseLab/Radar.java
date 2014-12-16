
/**
 * The model for radar scan and accumulator
 * 
 * @author @gcschmit
 * @version 19 July 2014
 */
public class Radar
{
    // stores the vector of the monster (dy and dx)
    private int dy;
    private int dx;

    // stores whether each cell triggered detection for the current scan of the radar
    private boolean[][] currentScan;

    // stores whether each cell triggered detection for the previous scan of the radar
    private boolean[][] lastScan;

    // stores the frequency of occurrences for each vector
    private int[][] vectorAccumulator;

    // location of the monster
    private int monsterLocationRow;
    private int monsterLocationCol;

    // probability that a cell will trigger a false detection (must be >= 0 and < 1)
    private double noiseFraction;

    // number of scans of the radar since construction
    private int numScans;

    /**
     * Constructor for objects of class Radar
     * 
     * @param   rows    the number of rows in the radar grid
     * @param   cols    the number of columns in the radar grid
     */
    public Radar(int rows, int cols, int startPosY, int startPosX, int initDy, int initDx)
    {
        // initialize instance variables
        lastScan = new boolean[rows][cols]; // elements will be set to false
        currentScan = new boolean[rows][cols]; // elements will be set to false
        vectorAccumulator = new int[11][11]; // elements will be set to 0
        dy = initDy;
        dx = initDx;
        monsterLocationRow = startPosY;
        monsterLocationCol = startPosX;
        noiseFraction = 0.01;
        numScans= 0;
    }

    /**
     * Performs a scan of the radar. Noise is injected into the grid and the accumulator is updated.
     * 
     */
    public void scan()
    {
        // Sets lastScan to be equal to currentScan before it is updated
        for( int row = 0; row < currentScan.length; row++ )
        {
            for( int col = 0; col < currentScan[0].length; col++ )
            {
                lastScan[row][col] = currentScan[row][col];
            }
        }

        // zero the current scan grid
        for(int row = 0; row < currentScan.length; row++)
        {
            for(int col = 0; col < currentScan[0].length; col++)
            {
                currentScan[row][col] = false;
            }
        }

        // Update monster location and detect monster
        monsterLocationRow += dx;
        monsterLocationCol += dy;
        currentScan[monsterLocationRow][monsterLocationCol] = true;

        // inject noise into the grid
        injectNoise();

        // udpate the accumulator
        for(int row = 0; row < lastScan.length; row++)
        {
            for(int col = 0; col < lastScan[0].length; col++)
            {
                if( lastScan[row][col] == true )
                {
                    for( int checkDy = -5; checkDy <= 5; checkDy++ )
                    {
                        for( int checkDx = -5; checkDx <= 5; checkDx++ )
                        {
                            if( ((row+checkDy >= 0 && row+checkDy < getNumRows()) &&
                                (col+checkDx >= 0 && col+checkDx < getNumCols())) &&
                                currentScan[row+checkDy][col+checkDx] == true)
                            {
                                vectorAccumulator[checkDy+5][checkDx+5] += 1;
                            }
                        }
                    }
                }
            }
        }

        // keep track of the total number of scans
        numScans++;
    }

    /**
     * Returns the velocity (dy and dx) of the monster
     * 
     * @return the velocity (dy and dx) of the monster
     */
    public String getMonsterVelocity()
    {
        int greatestFrequency = 0;
        int[] monsterVelocity = new int[2];
        String output = "";
        for( int dy = 0; dy < vectorAccumulator.length; dy++ )
        {
            for( int dx = 0; dx < vectorAccumulator[0].length; dx++ )
            {
                if( vectorAccumulator[dy][dx] > greatestFrequency )
                {
                    monsterVelocity[0] = dy;
                    monsterVelocity[1] = dx;
                    greatestFrequency = vectorAccumulator[dy][dx];
                }
            }
        }
        output = "DY "+(monsterVelocity[0]-5)+"\nDX "+(monsterVelocity[1]-5);
        return output;
    }

    /**
     * Sets the location of the monster
     * 
     * @param   row     the row in which the monster is located
     * @param   col     the column in which the monster is located
     * @pre row and col must be within the bounds of the radar grid
     */
    public void setMonsterLocation(int row, int col)
    {
        // remember the row and col of the monster's location
        monsterLocationRow = row;
        monsterLocationCol = col;

        // update the radar grid to show that something was detected at the specified location
        currentScan[row][col] = true;
    }

    /**
     * Sets the probability that a given cell will generate a false detection
     * 
     * @param   fraction    the probability that a given cell will generate a flase detection expressed
     *                      as a fraction (must be >= 0 and < 1)
     */
    public void setNoiseFraction(double fraction)
    {
        noiseFraction = fraction;
    }

    /**
     * Returns true if the specified location in the radar grid triggered a detection.
     * 
     * @param   row     the row of the location to query for detection
     * @param   col     the column of the location to query for detection
     * @return true if the specified location in the radar grid triggered a detection
     */
    public boolean isDetected(int row, int col)
    {
        return currentScan[row][col];
    }

    /**
     * Returns the number of rows in the radar grid
     * 
     * @return the number of rows in the radar grid
     */
    public int getNumRows()
    {
        return currentScan.length;
    }

    /**
     * Returns the number of columns in the radar grid
     * 
     * @return the number of columns in the radar grid
     */
    public int getNumCols()
    {
        return currentScan[0].length;
    }

    /**
     * Returns the number of scans that have been performed since the radar object was constructed
     * 
     * @return the number of scans that have been performed since the radar object was constructed
     */
    public int getNumScans()
    {
        return numScans;
    }

    /**
     * Sets cells as falsely triggering detection based on the specified probability
     * 
     */
    private void injectNoise()
    {
        for(int row = 0; row < currentScan.length; row++)
        {
            for(int col = 0; col < currentScan[0].length; col++)
            {
                // each cell has the specified probablily of being a false positive
                if(Math.random() < noiseFraction)
                {
                    currentScan[row][col] = true;
                }
            }
        }
    }

}

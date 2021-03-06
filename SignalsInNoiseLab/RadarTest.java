

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Write a description of test class RadarTest here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class RadarTest
{
    /** description of instance variable x (add comment for each instance variable) */
    private int x;

    /**
     * Default constructor for objects of class RadarTest
     */
    public RadarTest()
    {
        // initialise instance variables
        x = 0;
    }
    
    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }
    
    @Test
    public void testVelocity()
    {
        //Test 1
        Radar r1 = new Radar( 150, 150, 0, 0, 2, 2 );
        for( int iterations = 0; iterations < 50; iterations++ )
        {
            r1.scan();
        }
        assertEquals(("DY "+2+"\nDX "+2),r1.getMonsterVelocity());
        
        //Test 2
        Radar r2 = new Radar( 100, 100, 10, 10, 1, 1 );
        for( int iterations = 0; iterations < 50; iterations++ )
        {
            r2.scan();
        }
        assertEquals(("DY "+1+"\nDX "+1),r2.getMonsterVelocity());
    }

}


public class RadarNonVisual
{
    public static void main(String[] args)
    {
        Radar r1 = new Radar( 150, 150, 2, 2 );
        r1.setMonsterLocation(0,0);
        int[] monsterVelocity;
        for( int iterations = 0; iterations < 50; iterations++ )
        {
            r1.scan();
        }
        System.out.println(r1.getMonsterVelocity());
        
        
    }
}
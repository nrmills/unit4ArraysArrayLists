
public class RadarNonVisual
{
    public static void main(String[] args)
    {
        Radar r1 = new Radar( 100, 100, 1, 1 );
        r1.setMonsterLocation(30,30);
        for( int iterations = 0; iterations < 1; iterations++ )
        {
            r1.scan();
        }
        System.out.println(r1.getMonsterVelocity());
    }
}
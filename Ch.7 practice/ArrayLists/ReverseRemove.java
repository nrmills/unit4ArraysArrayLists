import java.util.ArrayList;

public class ReverseRemove
{
    public static void main(String[] args)
    {
        String match = "match";
        ArrayList list = new ArrayList();
        for( int i = list.size() - 1; i >= 0; i-- )
        {

            if( match.equals( list.get( i )))
            {
                list.remove( i );
            }
        }
    }
}
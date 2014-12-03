import java.util.ArrayList;

public class ArrayListOperations
{
    public static void main(String[] args)
    {
        ArrayList<String> names = new ArrayList();
        System.out.println(names);
        //Section A
        names.add("Alice");
        names.add("Bob");
        names.add("Connie");
        names.add("David");
        names.add("Edward");
        names.add("Fran");
        names.add("Gomez");
        names.add("Harry");
        //Section B
        names.get(0);
        names.get(names.size()-1); //Last element
        //Section C
        System.out.println(names.size());
        //Section D
        names.get(names.size()-1); //Last element
        //Section E
        names.set(0,"Alice B. Toklas");
        //Section F
        names.add(4,"Douglas");
        //Section G
        for( String value : names )
        {
            System.out.println(value);
        }
        //Section H
        ArrayList<ArrayList> names2 = new ArrayList(names);
        System.out.println(names2);
        //Section I
        names.remove(0);
        System.out.println(names);
        System.out.println(names2);

    }
}


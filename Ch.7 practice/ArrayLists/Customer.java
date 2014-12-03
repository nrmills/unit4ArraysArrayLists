import java.util.ArrayList;

public class Customer
{
    public Customer( String cName, double total)
    {
        ArrayList<String> customerName = new ArrayList(1);
        ArrayList<Integer> customerAmount = new ArrayList(1);
        ArrayList<ArrayList> customerInfo = new ArrayList(2);
        customerInfo.add(customerName);
        customerInfo.add(customerInfo);
    }
}

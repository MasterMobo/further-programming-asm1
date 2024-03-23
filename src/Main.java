import customer.Customer;
import customer.CustomerMap;
import customer.Dependent;
import customer.PolicyHolder;

public class Main {
    public static void main(String[] args) {
        Customer josh = new Dependent("123", "Josh Keplin");
        Customer keith = new Dependent("224", "Keith Mulligan");
        Customer mary = new PolicyHolder("223", "Mary Jane");

        ((PolicyHolder) mary).addDependent((Dependent) josh);
        ((PolicyHolder) mary).addDependent((Dependent) keith);

        CustomerMap customers = new CustomerMap();
        customers.add(mary);

        System.out.println(customers);
    }
}
package customer;

public interface CustomerMapOperations {
    Customer get(String id);
    Customer add(Customer customer);
}

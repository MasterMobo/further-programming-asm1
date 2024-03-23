package customer;

public class PolicyHolder extends Customer {
    private CustomerManager dependents;

    public PolicyHolder() {
        super();
        dependents = new CustomerMap();
    }

    public PolicyHolder(String id, String fullName) {
        super(id, fullName);
        dependents = new CustomerMap();
    }

    public void addDependent(Dependent dependent) {
        dependents.add(dependent);
    }

    @Override
    public String toString() {
        return "PolicyHolder{" +
                "id=" + id + "\n" +
                "name=" + fullName + "\n" +
                "dependents=" + dependents +
                '}';
    }
}

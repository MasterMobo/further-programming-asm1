package models.customer;

// TODO: clean this up
public interface CustomerRoleCode {
    String POLICYHOLDER = "ph";
    String DEPENDENT = "dp";

    static boolean validRole(String role) {
        // I give up
        if (role.equals(POLICYHOLDER)) return true;
        if (role.equals(DEPENDENT)) return true;

        return false;
    }
}

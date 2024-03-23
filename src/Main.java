import claims.InsuranceClaim;
import customer.Customer;
import customer.Dependent;
import customer.PolicyHolder;
import insuranceCard.InsuranceCard;
import systems.InsuranceClaimSystem;

public class Main {
    public static void main(String[] args) {
        Customer josh = new Dependent("123", "Josh Keplin");
        Customer keith = new Dependent("224", "Keith Mulligan");
        Customer mary = new PolicyHolder("223", "Mary Jane");

        ((PolicyHolder) mary).addDependent((Dependent) josh);
        ((PolicyHolder) mary).addDependent((Dependent) keith);
        InsuranceClaimSystem system = new InsuranceClaimSystem();
        system.addCustomer(mary);
        system.displayCustomers();
//
//        InsuranceCard card = new InsuranceCard();
//
//        system.addInsuranceCard("223", card);
//
//        InsuranceClaim claim = new InsuranceClaim();
//        system.addClaim("223", claim);
//
//        System.out.println(system.getAllClaims("223").get(0));


    }
}
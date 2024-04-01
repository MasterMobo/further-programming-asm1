import card.InsuranceCard;
import card.PolicyOwner;
import claims.InsuranceClaim;
import customer.Customer;
import customer.Dependent;
import customer.PolicyHolder;
import systems.InsuranceClaimSystem;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Customer josh = new Dependent("123", "Josh Keplin");
        Customer keith = new Dependent("224", "Keith Mulligan");
        Customer mary = new PolicyHolder("223", "Mary Jane");

        ((PolicyHolder) mary).addDependent((Dependent) josh);
        ((PolicyHolder) mary).addDependent((Dependent) keith);

        PolicyOwner rmit = new PolicyOwner("RMIT");

        InsuranceCard joshCard = InsuranceCard.createInsuranceCard("12345", josh, rmit, new Date("01/03/2024"));

        InsuranceClaim joshClaim = new InsuranceClaim();

        InsuranceClaimSystem system = new InsuranceClaimSystem();
        system.add(josh);
        system.add(joshCard);

        System.out.println(system.getAllCustomers());
        System.out.println(system.getAllInsuranceCards());
    }
}
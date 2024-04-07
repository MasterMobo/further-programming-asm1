package controllers.claims;

import controllers.ControllerOperator;
import models.claims.InsuranceClaim;
import models.claims.InsuranceClaimStorage;
import models.customer.Customer;
import models.customer.CustomerStorageManager;
import models.customer.roles.dependent.Dependent;
import models.customer.roles.holder.PolicyHolder;
import models.system.SystemStorageManager;
import views.general.InsuranceClaimView;
import views.general.MessageView;
import views.system.SystemViewManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class InsuranceClaimManyGetter extends ControllerOperator {
    public InsuranceClaimManyGetter() {
        super();
    }

    public InsuranceClaimManyGetter(SystemStorageManager systemStorageManager, SystemViewManager systemViewManager) {
        super(systemStorageManager, systemViewManager);
    }

    @Override
    public List<List<InsuranceClaim>> execute(Map<String, String> data) {
        // Returns a list of two lists:
        // First list contains claims belonging to this customer only. If no customer ID is provided, this contains all the claims in the system.
        // Second list contains claims of the dependent of the customer (if they are a PolicyHolder). This should be empty if no customer ID is provided, or if the customer is a Dependent.

        MessageView message = systemViewManager.getMessageView();

        InsuranceClaimStorage claims = systemStorageManager.getClaimStorage();
        CustomerStorageManager customers = systemStorageManager.getCustomerStorageManager();

        List<List<InsuranceClaim>> res = new ArrayList<>(2);
        res.add(new ArrayList<>());
        res.add(new ArrayList<>());

        String insuredId = data.get(InsuranceClaimView.INSURED_PERSON);

        if (insuredId.equalsIgnoreCase("")) {
            // If entered empty string, return all claims
            res.set(0, claims.getAll());
            return res;
        }

        if (!customers.customerExists(insuredId)) {
            message.displayError("Customer does not exist");
            return null;
        }

        // Get the customer claims
        res.set(0, claims.getClaimsOfCustomer(insuredId));

        // If customer is dependent, they should not have any dependent claims, return result
        Customer customer = customers.getCustomer(insuredId);
        if (!(customer instanceof PolicyHolder)) {
            return res;
        }

        // Customer must be a PolicyHolder now
        List<InsuranceClaim> dependentClaims = new ArrayList<>();
        List<String> dependentIds = ((PolicyHolder) customer).getDependentIds();

        // Add all the dependent claims
        for (String id: dependentIds) {
            dependentClaims.addAll(claims.getClaimsOfCustomer(id));
        }

        res.set(1, dependentClaims);

        return res;
    }
}

package controllers.claims;

import models.card.InsuranceCard;
import models.card.InsuranceCardManager;
import models.claims.ClaimProcessManager;
import models.claims.InsuranceClaim;
import models.customer.CustomerManager;
import views.general.InsuranceClaimView;

import java.util.Map;

public class InsuranceClaimController {
    private ClaimProcessManager claimManager;   // Model
    private InsuranceClaimView claimView;

    private CustomerManager customerManager;
    private InsuranceClaimCreator claimCreator;

    public InsuranceClaimController(ClaimProcessManager claimManager, InsuranceClaimView claimView, CustomerManager customerManager) {
        this.claimManager = claimManager;
        this.claimView = claimView;
        this.customerManager = customerManager;

        claimCreator = new InsuranceClaimCreator(claimManager, claimView, customerManager);
    }

    public InsuranceClaim createClaim() {
        claimView.displayMessage("Creating new claim...");

        Map<String, String> data = claimView.displayCreateClaimForm();
        InsuranceClaim newClaim = claimCreator.create(data);

        if (newClaim == null) return null;

        claimView.displayMessage("Successfully added new insurance claim:");
        claimView.displayInsuranceClaim(newClaim);
        return newClaim;
    }
}

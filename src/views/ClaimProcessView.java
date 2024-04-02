package views;

import claims.InsuranceClaim;

import java.util.Map;

public abstract class ClaimProcessView {
    public ClaimProcessView() {
    }

    public abstract void displayInsuranceClaim(InsuranceClaim claim);
    public abstract Map<String, String> displayCreateClaimForm();
}

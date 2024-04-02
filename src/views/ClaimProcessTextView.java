package views;

import claims.InsuranceClaim;

import java.util.Map;

public class ClaimProcessTextView extends ClaimProcessView{

    @Override
    public void displayInsuranceClaim(InsuranceClaim claim) {
        // FIXME: need to format
        System.out.println(claim);
    }

    @Override
    public Map<String, String> displayCreateClaimForm() {
        return null;
    }
}

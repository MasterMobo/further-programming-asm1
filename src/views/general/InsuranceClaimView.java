package views.general;

import models.claims.InsuranceClaim;

import java.util.Map;

public interface InsuranceClaimView {
    String CLAIM_DATE = "CLAIM_DATE";
    String INSURED_PERSON = "INSURED_PERSON";
    String CARD_NUM = "CARD_NUM";
    String EXAM_DATE = "EXAM_DATE";
    String DOCUMENTS = "DOCUMENTS";
    String CLAIM_AMOUNT = "CLAIM_AMOUNT";
    String CLAIM_STATUS = "CLAIM_STATUS";
    String RECEIVER_BANK = "RECEIVER_BANK";

    void displayInsuranceClaim(InsuranceClaim claim);
    Map<String, String> displayCreateClaimForm();
    void displayMessage(String s);
    void displayError(String s);
}

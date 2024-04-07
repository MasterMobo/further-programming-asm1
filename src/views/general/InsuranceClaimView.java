package views.general;

import models.claims.InsuranceClaim;
import views.general.operations.*;
import views.system.StorableView;

import java.util.List;

public interface InsuranceClaimView extends GetView, AddView, UpdateView, DeleteView, ItemDisplayView<InsuranceClaim>, StorableView {
    String CLAIM_ID = "CLAIM_ID";
    String CLAIM_DATE = "CLAIM_DATE";
    String INSURED_PERSON = "INSURED_PERSON";
    String EXAM_DATE = "EXAM_DATE";
    String DOCUMENTS = "DOCUMENTS";
    String CLAIM_AMOUNT = "CLAIM_AMOUNT";
    String CLAIM_STATUS = "CLAIM_STATUS";
    String RECEIVER_BANK = "RECEIVER_BANK";

    void displayMany(List<List<InsuranceClaim>> res);
}

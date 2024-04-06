package views.general;

import models.claims.InsuranceClaim;
import views.general.operations.AddView;
import views.general.operations.DeleteView;
import views.general.operations.ItemDisplayView;
import views.general.operations.UpdateView;
import views.system.StorableView;

public interface InsuranceClaimView extends AddView, ItemDisplayView<InsuranceClaim>, UpdateView, StorableView, DeleteView {
    String CLAIM_ID = "CLAIM_ID";
    String CLAIM_DATE = "CLAIM_DATE";
    String INSURED_PERSON = "INSURED_PERSON";
    String CARD_NUM = "CARD_NUM";
    String EXAM_DATE = "EXAM_DATE";
    String DOCUMENTS = "DOCUMENTS";
    String CLAIM_AMOUNT = "CLAIM_AMOUNT";
    String CLAIM_STATUS = "CLAIM_STATUS";
    String RECEIVER_BANK = "RECEIVER_BANK";

}

package io.files.encoders.items;

import io.files.DataSeparator;
import io.files.encoders.StringEncoder;
import models.claims.InsuranceClaim;

public class InsuranceClaimEncoder extends StringEncoder<InsuranceClaim> {
    @Override
    public String encode(InsuranceClaim item) {
        return item.getId() + DataSeparator.ATTRIBUTE
                + item.getInsuredPersonId() + DataSeparator.ATTRIBUTE
                + item.getCardNumber() + DataSeparator.ATTRIBUTE
                + item.getClaimAmount() + DataSeparator.ATTRIBUTE
                + item.getStatus() + DataSeparator.ATTRIBUTE
                + item.getClaimDate() + DataSeparator.ATTRIBUTE
                + item.getExamDate() + DataSeparator.ATTRIBUTE
                + item.getReceiverBankInfo() + DataSeparator.ATTRIBUTE
                + encodeList(item.getDocuments());
    }
}

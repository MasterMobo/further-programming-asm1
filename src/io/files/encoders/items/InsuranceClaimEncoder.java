package io.files.encoders.items;

/**
 * @author <Bui Dang Khoa - s3978482>
 */

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
                + encodeDate(item.getClaimDate()) + DataSeparator.ATTRIBUTE
                + encodeDate(item.getExamDate()) + DataSeparator.ATTRIBUTE
                + item.getReceiverBankInfo() + DataSeparator.ATTRIBUTE
                + encodeList(item.getDocuments());
    }
}

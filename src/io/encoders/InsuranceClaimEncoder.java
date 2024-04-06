package io.encoders;

import io.Separator;
import models.claims.InsuranceClaim;

public class InsuranceClaimEncoder extends StringEncoder<InsuranceClaim> {
    @Override
    public String encode(InsuranceClaim item) {
        return item.getId() + Separator.OBJECT
                + item.getInsuredPersonId() + Separator.OBJECT;
    }
}

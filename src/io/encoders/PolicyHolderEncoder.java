package io.encoders;

import io.Separator;
import models.customer.roles.holder.PolicyHolder;

public class PolicyHolderEncoder extends StringEncoder<PolicyHolder> {
    @Override
    public String encode(PolicyHolder item) {
        return item.getId() + Separator.OBJECT
                + item.getFullName() + Separator.OBJECT
                + item.getInsuranceCardNumber() + Separator.OBJECT
                + encodeList(item.getDependentIds());
    }

}

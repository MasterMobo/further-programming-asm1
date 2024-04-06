package io.files.encoders.items;

import io.files.DataSeparator;
import io.files.encoders.StringEncoder;
import models.customer.roles.holder.PolicyHolder;

public class PolicyHolderEncoder extends StringEncoder<PolicyHolder> {
    @Override
    public String encode(PolicyHolder item) {
        return item.getId() + DataSeparator.ATTRIBUTE
                + item.getFullName() + DataSeparator.ATTRIBUTE
                + item.getInsuranceCardNumber() + DataSeparator.ATTRIBUTE
                + encodeList(item.getDependentIds());
    }

}

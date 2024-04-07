package io.files.encoders.items;

/**
 * @author <Bui Dang Khoa - s3978482>
 */

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

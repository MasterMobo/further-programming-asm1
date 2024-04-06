package io.files.encoders.items;

import io.files.DataSeparator;
import io.files.encoders.StringEncoder;
import models.customer.roles.dependent.Dependent;

public class DependentEncoder extends StringEncoder<Dependent> {
    @Override
    public String encode(Dependent item) {
        return item.getId() + DataSeparator.ATTRIBUTE
                + item.getFullName() + DataSeparator.ATTRIBUTE
                + item.getInsuranceCardNumber();
    }
}

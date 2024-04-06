package io.encoders;

import io.Separator;
import models.customer.roles.dependent.Dependent;

public class DependentEncoder extends StringEncoder<Dependent> {
    @Override
    public String encode(Dependent item) {
        return item.getId() + Separator.OBJECT
                + item.getFullName() + Separator.OBJECT
                + item.getInsuranceCardNumber();
    }
}

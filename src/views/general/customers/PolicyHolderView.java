package views.general.customers;

import models.customer.roles.holder.PolicyHolder;

import java.util.List;

public interface PolicyHolderView extends CustomerView<PolicyHolder> {
    void displayWithDependents(List<Object> res);
}

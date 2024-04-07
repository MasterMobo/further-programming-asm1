package views.general.customers;

/**
 * @author <Bui Dang Khoa - s3978482>
 */

import models.customer.roles.holder.PolicyHolder;

import java.util.List;

public interface PolicyHolderView extends CustomerView<PolicyHolder> {
    void displayWithDependents(List<Object> res);
}

package views.general.customers;

/**
 * @author <Bui Dang Khoa - s3978482>
 */

import models.customer.roles.dependent.Dependent;

public interface DependentView extends CustomerView<Dependent> {
    String DEPENDS_ON = "DEPENDS_ON";
}

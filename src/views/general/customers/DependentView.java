package views.general.customers;

import models.customer.roles.dependent.Dependent;

public interface DependentView extends CustomerView<Dependent> {
    String DEPENDS_ON = "DEPENDS_ON";
}

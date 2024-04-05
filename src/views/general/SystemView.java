package views.general;

import views.general.customers.CustomerView;
import views.general.customers.DependentView;
import views.general.customers.PolicyHolderView;

public interface SystemView {
    MessageView getMessageView();
    PolicyHolderView getPolicyHolderView();
    DependentView getDependentView();
    InsuranceCardView getInsuranceCardView();
    InsuranceClaimView getInsuranceClaimView();
}

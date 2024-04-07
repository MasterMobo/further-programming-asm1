package views.system;

/**
 * @author <Bui Dang Khoa - s3978482>
 */

import models.storage.Storage;
import views.general.InsuranceCardView;
import views.general.InsuranceClaimView;
import views.general.MessageView;
import views.general.customers.DependentView;
import views.general.customers.PolicyHolderView;

public interface SystemViewManager extends Storage<StorableView> {
    MessageView getMessageView();
    PolicyHolderView getPolicyHolderView();
    DependentView getDependentView();
    InsuranceCardView getInsuranceCardView();
    InsuranceClaimView getInsuranceClaimView();
}

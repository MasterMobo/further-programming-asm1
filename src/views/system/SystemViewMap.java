package views.system;

/**
 * @author <Bui Dang Khoa - s3978482>
 */

import models.storage.MapStorage;
import views.general.InsuranceCardView;
import views.general.InsuranceClaimView;
import views.general.MessageView;
import views.general.customers.DependentView;
import views.general.customers.PolicyHolderView;

public class SystemViewMap extends MapStorage<StorableView> implements SystemViewManager{
    public SystemViewMap() {
    }

    @Override
    public MessageView getMessageView() {
        return (MessageView) get(ViewCode.MESSAGE);
    }

    @Override
    public PolicyHolderView getPolicyHolderView() {
        return (PolicyHolderView) get(ViewCode.POLICY_HOLDERS);
    }

    @Override
    public DependentView getDependentView() {
        return (DependentView) get(ViewCode.DEPENDENTS);
    }

    @Override
    public InsuranceCardView getInsuranceCardView() {
        return (InsuranceCardView) get(ViewCode.INSURANCE_CARDS);
    }

    @Override
    public InsuranceClaimView getInsuranceClaimView() {
        return (InsuranceClaimView) get(ViewCode.INSURANCE_CLAIMS);
    }
}

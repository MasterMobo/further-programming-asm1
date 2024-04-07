package controllers.system;

/**
 * @author <Bui Dang Khoa - s3978482>
 */

import controllers.Controller;
import controllers.cards.InsuranceCardController;
import controllers.claims.InsuranceClaimController;
import controllers.customers.dependents.DependentController;
import controllers.customers.policy_holder.PolicyHolderController;
import models.storage.MapStorage;

public class SystemControllerStorage extends MapStorage<Controller> implements SystemControllerManager {

    @Override
    public DependentController getDependentController() {
        return (DependentController) get(ControllerCode.DEPENDENTS);
    }

    @Override
    public PolicyHolderController getPolicyHolderController() {
        return (PolicyHolderController) get(ControllerCode.POLICY_HOLDER);
    }

    @Override
    public InsuranceCardController getInsuranceCardController() {
        return (InsuranceCardController) get(ControllerCode.INSURANCE_CARDS);
    }

    @Override
    public InsuranceClaimController getInsuranceClaimController() {
        return (InsuranceClaimController) get(ControllerCode.INSURANCE_CLAIMS);
    }
}

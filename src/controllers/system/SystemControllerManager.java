package controllers.system;

import controllers.Controller;
import controllers.cards.InsuranceCardController;
import controllers.claims.InsuranceClaimController;
import controllers.customers.DependentController;
import controllers.customers.PolicyHolderController;
import models.storage.Storage;

public interface SystemControllerManager extends Storage<Controller> {
    DependentController getDependentController();
    PolicyHolderController getPolicyHolderController();
    InsuranceCardController getInsuranceCardController();
    InsuranceClaimController getInsuranceClaimController();
}

package controllers.claims;

/**
 * @author <Bui Dang Khoa - s3978482>
 */

import controllers.*;
import controllers.system.ControllerCode;
import models.claims.InsuranceClaim;
import models.system.SystemStorageManager;
import views.general.InsuranceClaimView;
import views.system.SystemViewManager;

import java.util.List;
import java.util.Map;

public class InsuranceClaimController extends Controller<InsuranceClaim> implements GettableController<InsuranceClaim>, AddableController<InsuranceClaim>, UpdatableController<InsuranceClaim>, DeletableController<InsuranceClaim> {

    public InsuranceClaimController() {
        super();
    }

    public InsuranceClaimController(SystemStorageManager systemStorageManager, SystemViewManager systemViewManager) {
        this.systemStorageManager = systemStorageManager;
        this.systemViewManager = systemViewManager;
    }

    @Override
    public InsuranceClaim add() {
        InsuranceClaimCreator creator = new InsuranceClaimCreator(systemStorageManager, systemViewManager);
        InsuranceClaimView claimView = systemViewManager.getInsuranceClaimView();
        Map<String, String> data = claimView.displayAddForm();

        return executeOperator(creator, data, claimView);
    }

    @Override
    public InsuranceClaim update() {
        InsuranceClaimUpdater updater = new InsuranceClaimUpdater(systemStorageManager, systemViewManager);
        InsuranceClaimView claimView = systemViewManager.getInsuranceClaimView();
        Map<String, String> data = claimView.displayUpdateForm();

        return executeOperator(updater, data, claimView);
    }

    @Override
    public InsuranceClaim delete() {
        InsuranceClaimDeleter deleter = new InsuranceClaimDeleter(systemStorageManager, systemViewManager);
        InsuranceClaimView claimView = systemViewManager.getInsuranceClaimView();
        Map<String, String> data = claimView.displayDeleteForm();

        return executeOperator(deleter, data, claimView);
    }

    @Override
    public InsuranceClaim get() {
        InsuranceClaimSingleGetter singleGetter = new InsuranceClaimSingleGetter(systemStorageManager, systemViewManager);
        InsuranceClaimView claimView = systemViewManager.getInsuranceClaimView();
        Map<String, String> data = claimView.displayGetForm();

        return executeOperator(singleGetter, data, claimView);
    }

    @Override
    public List<InsuranceClaim> getMany() {
        InsuranceClaimManyGetter manyGetter = new InsuranceClaimManyGetter(systemStorageManager, systemViewManager);
        InsuranceClaimView claimView = systemViewManager.getInsuranceClaimView();
        Map<String, String> data = claimView.displayGetManyForm();

        List<List<InsuranceClaim>> res = manyGetter.execute(data);

        if (res == null) return null;

        claimView.displayMany(res);

        return res.get(0);  // Returning only the main claims. Might change later lol.
    }

    @Override
    public String getId() {
        return ControllerCode.INSURANCE_CLAIMS;
    }
}

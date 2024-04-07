package controllers.claims;

import controllers.ControllerOperator;
import models.claims.InsuranceClaimStorage;
import models.claims.InsuranceClaim;
import models.claims.InsuranceClaimStatus;
import models.customer.CustomerStorageManager;
import models.system.SystemStorageManager;
import utils.converters.DateConverter;
import utils.converters.DoubleConverter;
import utils.converters.TypeConverter;
import views.general.InsuranceClaimView;
import views.general.MessageView;
import views.system.SystemViewManager;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class InsuranceClaimCreator extends ControllerOperator {
    public InsuranceClaimCreator() {
        super();
    }

    public InsuranceClaimCreator(SystemStorageManager systemStorageManager, SystemViewManager systemViewManager) {
        super(systemStorageManager, systemViewManager);
    }

    @Override
    public InsuranceClaim execute(Map<String, String> data) {
        // Get the storages
        CustomerStorageManager customerStorageManager = systemStorageManager.getCustomerStorageManager();
        InsuranceClaimStorage claimStorage = systemStorageManager.getClaimStorage();

        // Get the views
        MessageView messageView = systemViewManager.getMessageView();

        // Get the converters
        TypeConverter<Date> dateConverter = new DateConverter();
        TypeConverter<Double> doubleConverter = new DoubleConverter();

        // Get Customer ID
        String insuredPersonId = data.get(InsuranceClaimView.INSURED_PERSON);

        if (!customerStorageManager.customerExists(insuredPersonId)) {
            messageView.displayError("Customer does not exist");
            return null;
        }

        if (!customerStorageManager.hasInsuranceCard(insuredPersonId)) {
            messageView.displayError("This customer does not have an insurance card");
            return null;
        }

        // Get remaining claim info
        String cardNum = customerStorageManager.getCardNumber(insuredPersonId);
        List<String> documentNames = parseDocuments(data.get(InsuranceClaimView.DOCUMENTS));
        String bankInfo = data.get(InsuranceClaimView.RECEIVER_BANK);
        double claimAmount = doubleConverter.fromString(data.get(InsuranceClaimView.CLAIM_AMOUNT));

        // Try-catch here to catch Date and Status errors
        try {
            InsuranceClaimStatus claimStatus = InsuranceClaimStatus.valueOf(data.get(InsuranceClaimView.CLAIM_STATUS).trim().toUpperCase());
            Date claimDate = dateConverter.fromString(data.get(InsuranceClaimView.CLAIM_DATE));
            Date examDate = dateConverter.fromString(data.get(InsuranceClaimView.EXAM_DATE));

            String claimId = claimStorage.generateId();
            List<String> documents = formatDocumentNames(claimId, cardNum, documentNames);

            InsuranceClaim newClaim = new InsuranceClaim(claimId, claimDate, insuredPersonId, cardNum, examDate, documents, claimAmount, claimStatus, bankInfo);

            return claimStorage.add(newClaim);

        } catch (IllegalArgumentException e) {
            if (e.getMessage() == null) {
                messageView.displayError("Invalid Date");
                return null;
            }

            if (e.getMessage().contains("enum")) {
                messageView.displayError("Invalid Status");
                return null;
            }

            return null;
        }
    }

    private List<String> parseDocuments(String docString) {
        return List.of(docString.split("\n"));
    }

    private List<String> formatDocumentNames(String claimId, String cardNum, List<String> documentNames) {
        List<String> res = new ArrayList<>();
        for (String documentName: documentNames) {
            res.add(claimId + "_" + cardNum + "_" + documentName + ".pdf");
        }

        return res;
    }
}

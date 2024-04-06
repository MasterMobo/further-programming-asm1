package controllers.claims;

import controllers.ControllerOperator;
import models.claims.InsuranceClaim;
import models.claims.InsuranceClaimStatus;
import models.claims.InsuranceClaimStorage;
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

public class InsuranceClaimUpdater extends ControllerOperator<InsuranceClaim> {
    public InsuranceClaimUpdater() {
        super();
    }

    public InsuranceClaimUpdater(SystemStorageManager systemStorageManager, SystemViewManager systemViewManager) {
        super(systemStorageManager, systemViewManager);
    }

    @Override
    public InsuranceClaim execute(Map<String, String> data) {
        CustomerStorageManager customers = systemStorageManager.getCustomerStorageManager();
        InsuranceClaimStorage insuranceClaims = systemStorageManager.getClaimStorage();

        MessageView message = systemViewManager.getMessageView();

        TypeConverter<Date> dateConverter = new DateConverter();
        TypeConverter<Double> doubleConverter = new DoubleConverter();

        String claimId = data.get(InsuranceClaimView.CLAIM_ID);

        if (!insuranceClaims.exists(claimId)) {
            message.displayError("Claim does not exist");
            return null;
        }


        String insuredId = data.get(InsuranceClaimView.INSURED_PERSON);

        if (!customers.customerExists(insuredId)) {
            message.displayError("Customer does not exist");
            return null;
        }

        if (!customers.hasInsuranceCard(insuredId)) {
            message.displayError("This customer does not have an insurance card");
            return null;
        }

        // Get remaining claim info
        String cardNum = customers.getCardNumber(insuredId);
        List<String> documentNames = parseDocuments(data.get(InsuranceClaimView.DOCUMENTS));
        String bankInfo = data.get(InsuranceClaimView.RECEIVER_BANK);
        double claimAmount = doubleConverter.fromString(data.get(InsuranceClaimView.CLAIM_AMOUNT));

        // Try-catch here to catch Date and Status errors
        try {
            InsuranceClaimStatus claimStatus = InsuranceClaimStatus.valueOf(data.get(InsuranceClaimView.CLAIM_STATUS).trim().toUpperCase());
            Date claimDate = dateConverter.fromString(data.get(InsuranceClaimView.CLAIM_DATE));
            Date examDate = dateConverter.fromString(data.get(InsuranceClaimView.EXAM_DATE));

            List<String> documents = formatDocumentNames(claimId, cardNum, documentNames);

            InsuranceClaim newClaim = new InsuranceClaim(claimId, claimDate, insuredId, cardNum, examDate, documents, claimAmount, claimStatus, bankInfo);

            return insuranceClaims.update(claimId, newClaim);

        } catch (IllegalArgumentException e) {
            if (e.getMessage().contains("enum")) {
                message.displayError("Invalid Status");
                return null;
            }

            // The remaining exception should be from date conversion
            message.displayError("Invalid Date");
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

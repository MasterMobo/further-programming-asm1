package controllers.claims;

import models.claims.InsuranceClaimManager;
import models.claims.InsuranceClaim;
import models.claims.InsuranceClaimStatus;
import models.customer.CustomerManager;
import models.system.SystemManager;
import utils.converters.DateConverter;
import utils.converters.DoubleConverter;
import utils.converters.TypeConverter;
import views.general.InsuranceClaimView;
import views.general.MessageView;
import views.general.SystemView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class InsuranceClaimCreator {
    private SystemManager systemManager;
    private SystemView systemView;

    public InsuranceClaimCreator() {
    }

    public InsuranceClaimCreator(SystemManager systemManager, SystemView systemView) {
        this.systemManager = systemManager;
        this.systemView = systemView;
    }

    public InsuranceClaim create(Map<String, String> data) {
        // Get the managers
        CustomerManager customerManager = systemManager.getCustomerManager();
        InsuranceClaimManager claimManager = systemManager.getClaimManager();

        // Get the views
        InsuranceClaimView claimView = systemView.getInsuranceClaimView();
        MessageView messageView = systemView.getMessageView();

        // Get the converters
        TypeConverter<Date> dateConverter = new DateConverter();
        TypeConverter<Double> doubleConverter = new DoubleConverter();

        // Get Customer ID
        String insuredPersonId = data.get(InsuranceClaimView.INSURED_PERSON);

        if (!customerManager.exists(insuredPersonId)) {
            messageView.displayError("Customer does not exist");
            return null;
        }

        if (!customerManager.hasInsuranceCard(insuredPersonId)) {
            messageView.displayError("This customer does not have an insurance card");
            return null;
        }

        // Get remaining claim info
        String cardNum = customerManager.getCardNumber(insuredPersonId);
        List<String> documentNames = parseDocuments(data.get(InsuranceClaimView.DOCUMENTS));
        String bankInfo = data.get(InsuranceClaimView.RECEIVER_BANK);
        double claimAmount = doubleConverter.fromString(data.get(InsuranceClaimView.CLAIM_AMOUNT));

        // Try-catch here to catch Date and Status errors
        try {
            InsuranceClaimStatus claimStatus = InsuranceClaimStatus.valueOf(data.get(InsuranceClaimView.CLAIM_STATUS).trim().toUpperCase());
            Date claimDate = dateConverter.fromString(data.get(InsuranceClaimView.CLAIM_DATE));
            Date examDate = dateConverter.fromString(data.get(InsuranceClaimView.EXAM_DATE));

            String claimId = claimManager.generateId();
            List<String> documents = formatDocumentNames(claimId, cardNum, documentNames);

            InsuranceClaim newClaim = new InsuranceClaim(claimId, claimDate, insuredPersonId, cardNum, examDate, documents, claimAmount, claimStatus, bankInfo);

            return claimManager.add(newClaim);

        } catch (IllegalArgumentException e) {
            if (e.getMessage().contains("enum")) {
                messageView.displayError("Invalid Status");
                return null;
            }

            // The remaining exception should be from date conversion
            messageView.displayError("Invalid Date");
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

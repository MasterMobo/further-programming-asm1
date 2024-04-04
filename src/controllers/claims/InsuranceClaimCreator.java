package controllers.claims;

import models.claims.ClaimProcessManager;
import models.claims.InsuranceClaim;
import models.claims.InsuranceClaimStatus;
import models.customer.CustomerManager;
import utils.converters.DateConverter;
import utils.converters.DoubleConverter;
import utils.converters.TypeConverter;
import views.general.InsuranceClaimView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class InsuranceClaimCreator {
    private ClaimProcessManager claimManager;
    private InsuranceClaimView claimView;
    private CustomerManager customerManager;

    public InsuranceClaimCreator(ClaimProcessManager claimManager, InsuranceClaimView claimView, CustomerManager customerManager) {
        this.claimManager = claimManager;
        this.claimView = claimView;
        this.customerManager = customerManager;
    }

    public InsuranceClaim create(Map<String, String> data) {
        String insuredPersonId = data.get(InsuranceClaimView.INSURED_PERSON);
        TypeConverter<Date> dateConverter = new DateConverter();
        TypeConverter<Double> doubleConverter = new DoubleConverter();

        if (!customerManager.exists(insuredPersonId)) {
            claimView.displayError("Customer does not exist");
            return null;
        }

        if (!customerManager.hasInsuranceCard(insuredPersonId)) {
            claimView.displayError("This customer does not have an insurance card");
            return null;
        }

        String cardNum = customerManager.getCardNumber(insuredPersonId);
        List<String> documentNames = parseDocuments(data.get(InsuranceClaimView.DOCUMENTS));
        String bankInfo = data.get(InsuranceClaimView.RECEIVER_BANK);
        double claimAmount = doubleConverter.fromString(data.get(InsuranceClaimView.CLAIM_AMOUNT));

        try {
            InsuranceClaimStatus claimStatus = InsuranceClaimStatus.valueOf(data.get(InsuranceClaimView.CLAIM_STATUS));
            Date claimDate = dateConverter.fromString(data.get(InsuranceClaimView.CLAIM_DATE));
            Date examDate = dateConverter.fromString(data.get(InsuranceClaimView.EXAM_DATE));

            String claimId = claimManager.generateId();
            List<String> documents = formatDocumentNames(claimId, cardNum, documentNames);

            InsuranceClaim newClaim = new InsuranceClaim(claimId, claimDate, insuredPersonId, cardNum, examDate, documents, claimAmount, claimStatus, bankInfo);

            return claimManager.add(newClaim);

        } catch (IllegalArgumentException e) {
            if (e.getMessage().contains("enum")) {
                claimView.displayError("Invalid Status");
                return null;
            }

            // The remaining exception should be from date conversion
            claimView.displayError("Invalid Date");
            return null;
        }
    }

    private List<String> parseDocuments(String docString) {
        return List.of(docString.split("\n"));
    }

    private List<String> formatDocumentNames(String claimId, String cardNum, List<String> documentNames) {
        List<String> res = new ArrayList<>();
        for (String documentName: documentNames) {
            res.add(claimId + "_" + cardNum + "_" + documentName);
        }

        return res;
    }
}

package models.claims;

/**
 * @author <Bui Dang Khoa - s3978482>
 */

import models.storage.StorageItem;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class InsuranceClaim implements StorageItem {
    private String id;
    private Date claimDate;
    private String insuredPersonId;
    private String cardNumber;
    private Date examDate;
    private List<String> documents;
    private double claimAmount;
    private InsuranceClaimStatus status;
    private String receiverBankInfo;

    public InsuranceClaim() {
        id = "Default";
        claimDate = null;
        insuredPersonId = null;
        cardNumber = "Default";
        examDate = null;
        documents = new ArrayList<>();
        claimAmount = 0;
        status = null;
        receiverBankInfo = null;
    }

    public InsuranceClaim(String id, Date claimDate, String insuredPersonId, String cardNumber, Date examDate, List<String> documents, double claimAmount, InsuranceClaimStatus status, String receiverBankInfo) {
        this.id = id;
        this.claimDate = claimDate;
        this.insuredPersonId = insuredPersonId;
        this.cardNumber = cardNumber;
        this.examDate = examDate;
        this.documents = documents;
        this.claimAmount = claimAmount;
        this.status = status;
        this.receiverBankInfo = receiverBankInfo;
    }

    @Override
    public String getId() {
        return id;
    }

    public Date getClaimDate() {
        return claimDate;
    }

    public String getInsuredPersonId() {
        return insuredPersonId;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public Date getExamDate() {
        return examDate;
    }

    public List<String> getDocuments() {
        return documents;
    }

    public double getClaimAmount() {
        return claimAmount;
    }

    public InsuranceClaimStatus getStatus() {
        return status;
    }

    public String getReceiverBankInfo() {
        return receiverBankInfo;
    }
}

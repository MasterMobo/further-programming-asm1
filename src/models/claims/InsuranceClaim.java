package models.claims;

import models.id.Identifiable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class InsuranceClaim implements Identifiable {
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

}

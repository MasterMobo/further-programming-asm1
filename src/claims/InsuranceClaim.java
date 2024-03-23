package claims;

import customer.Customer;
import maps.Identifiable;

import java.util.ArrayList;
import java.util.Date;

public class InsuranceClaim implements Identifiable {
    private String id;
    private Date claimDate;
    private Customer insuredPerson;
    private String cardNumber;
    private Date examDate;
    private ArrayList<Document> documents;
    private double claimAmount;
    private ClaimStatus status;
    private BankInfo receiverBankInfo;

    public InsuranceClaim() {
        id = "Default";
        claimDate = null;
        insuredPerson = null;
        cardNumber = "Default";
        examDate = null;
        documents = new ArrayList<>();
        claimAmount = 0;
        status = null;
        receiverBankInfo = null;
    }

    public InsuranceClaim(String id, Date claimDate, Customer insuredPerson, String cardNumber, Date examDate, ArrayList<Document> documents, double claimAmount, ClaimStatus status, BankInfo receiverBankInfo) {
        this.id = id;
        this.claimDate = claimDate;
        this.insuredPerson = insuredPerson;
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

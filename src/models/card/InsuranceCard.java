package models.card;

import models.storage.StorageItem;

import java.util.Date;

public class InsuranceCard implements StorageItem {
    private String cardNumber;
    private String cardHolderId;    // Cardholder is a Customer
    private String policyOwner;     // Organization that purchases the insurance to the models.customer
    private Date expirationDate;

    public InsuranceCard() {
        cardNumber = "Default";
        cardHolderId = null;
        policyOwner = null;
        expirationDate = null;
    }

    public InsuranceCard(String cardNumber, String cardHolderId, String policyOwner, Date expirationDate) {
        this.cardNumber = cardNumber;
        this.cardHolderId = cardHolderId;
        this.policyOwner = policyOwner;
        this.expirationDate = expirationDate;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public String getCardHolderId() {
        return cardHolderId;
    }

    public String getPolicyOwner() {
        return policyOwner;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    @Override
    public String getId() {
        return cardNumber;  // Card number will serve as the ID for every models.card
    }
}

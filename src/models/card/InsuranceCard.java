package models.card;

import models.id.Identifiable;

import java.util.Date;

public class InsuranceCard implements Identifiable {
    private String cardNumber;
    private String cardHolderId;    // Cardholder is a models.customer
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

    @Override
    public String getId() {
        return cardNumber;  // Card number will serve as the ID for every models.card
    }
}

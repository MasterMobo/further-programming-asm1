package card;

import customer.Customer;
import id.Identifiable;

import java.util.Date;

public class InsuranceCard implements Identifiable {
    private String cardNumber;
    private Customer cardHolder;
    private PolicyOwner policyOwner;
    private Date expirationDate;

    public InsuranceCard() {
        cardNumber = "Default";
        cardHolder = null;
        policyOwner = null;
        expirationDate = null;
    }

    public InsuranceCard(String cardNumber, Customer cardHolder, PolicyOwner policyOwner, Date expirationDate) {
        this.cardNumber = cardNumber;
        this.cardHolder = cardHolder;
        this.policyOwner = policyOwner;
        this.expirationDate = expirationDate;
    }

    public static InsuranceCard createInsuranceCard(String cardNumber, Customer cardHolder, PolicyOwner policyOwner, Date expirationDate) {
        // Factory?
        // Instantiate new InsuranceCard and set the card-holder's card to the new card
        InsuranceCard newCard = new InsuranceCard(cardNumber, cardHolder, policyOwner, expirationDate);
        cardHolder.setInsuranceCard(newCard);

        return newCard;
    }

    @Override
    public String toString() {
        return "InsuranceCard{" +
                "cardNumber='" + cardNumber + '\'' +
                ", cardHolder=" + cardHolder +
                ", policyOwner=" + policyOwner +
                ", expirationDate=" + expirationDate +
                '}';
    }

    @Override
    public String getId() {
        return cardNumber;  // Card number will serve as the ID for every card
    }
}

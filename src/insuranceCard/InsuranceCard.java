package insuranceCard;

import customer.Customer;

import java.util.Date;

public class InsuranceCard {
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
}

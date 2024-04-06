package views.text.cards;

import models.card.InsuranceCard;
import views.general.InsuranceCardView;
import io.readers.ConsoleReader;
import io.readers.DataReader;
import views.system.ViewCode;

import java.util.HashMap;
import java.util.Map;

public class InsuranceCardTextView implements InsuranceCardView {

    @Override
    public void displayItem(InsuranceCard card) {
        System.out.println("Insurance Card (" + card.getCardNumber() +"): ");
        System.out.println("\tCard Holder ID: " + card.getCardHolderId() );
        System.out.println("\tPolicy Owner: " + card.getPolicyOwner());
        System.out.println("\tExpiry Date: " + card.getExpirationDate());
    }

    @Override
    public Map<String, String> displayAddForm() {
        Map<String, String> data = new HashMap<>();
        DataReader reader = ConsoleReader.getInstance();

        System.out.println("---Adding new Insurance Card---");

        System.out.print("Enter Card Holder ID: ");
        String cardHolder = reader.read();

        System.out.print("Enter Policy Owner: ");
        String policyOwner = reader.read();

        System.out.print("Enter Expiry Date (mm/dd/yyyy): ");
        String expiryDate = reader.read();

        data.put(CARD_HOLDER, cardHolder);
        data.put(POLICY_OWNER, policyOwner);
        data.put(EXPIRY_DATE, expiryDate);

        return data;
    }

    @Override
    public String getId() {
        return ViewCode.INSURANCE_CARDS;
    }
}

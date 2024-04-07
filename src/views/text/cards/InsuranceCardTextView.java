package views.text.cards;

import models.card.InsuranceCard;
import utils.console.ConsoleUtils;
import views.general.InsuranceCardView;
import io.readers.ConsoleReader;
import io.readers.DataReader;
import views.sorters.InsuranceCardSorter;
import views.sorters.Sorter;
import views.system.ViewCode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InsuranceCardTextView implements InsuranceCardView {

    @Override
    public void displayItem(InsuranceCard card) {
        if (card == null) {
            System.out.println("Nothing to Show");
            return;
        };

        System.out.println("Insurance Card (" + card.getCardNumber() +"): ");
        System.out.println("\tCard Holder ID: " + card.getCardHolderId() );
        System.out.println("\tPolicy Owner: " + card.getPolicyOwner());
        System.out.println("\tExpiry Date (mm/dd/yyyy): " + card.getExpirationDate());
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

    @Override
    public Map<String, String> displayDeleteForm() {
        Map<String, String> data = new HashMap<>();
        DataReader reader = ConsoleReader.getInstance();

        System.out.print("Enter Card Number to Delete: ");
        data.put(InsuranceCardView.CARD_NUM, reader.read());

        return data;
    }

    @Override
    public boolean displayDeleteConfirm() {
        DataReader reader = ConsoleReader.getInstance();
        ConsoleUtils.printYellow("This will also remove this card form the card holder.");
        ConsoleUtils.printYellow("Are you sure you want to delete this Insurance Claim? (y/n)");
        ConsoleUtils.printRed("(This action is irreversible)");

        return reader.read().equalsIgnoreCase("y");
    }

    @Override
    public Map<String, String> displayGetForm() {
        Map<String, String> data = new HashMap<>();
        DataReader reader = ConsoleReader.getInstance();

        System.out.print("Enter Card Number: ");
        data.put(InsuranceCardView.CARD_NUM, reader.read());

        return data;
    }

    @Override
    public Map<String, String> displayGetManyForm() {
        Map<String, String> data = new HashMap<>();
        DataReader reader = ConsoleReader.getInstance();

        System.out.print("Enter Card Holder ID (leave empty to get all cards): ");
        data.put(InsuranceCardView.CARD_HOLDER, reader.read().trim());
        return data;
    }

    @Override
    public void displayMany(List<List<InsuranceCard>> res) {
        List<InsuranceCard> mainCards = res.get(0);
        Sorter<InsuranceCard> sorter = new InsuranceCardSorter();
        for (InsuranceCard card: sorter.sort(mainCards)) {
            displayItem(card);
        }

        if (res.get(1).size() == 0) return;

        System.out.println("---Dependent Cards---");
        for (InsuranceCard card: sorter.sort(res.get(1))) {
            displayItem(card);
        }
    }

    @Override
    public Map<String, String> displayUpdateForm() {
        Map<String, String> data = new HashMap<>();
        DataReader reader = ConsoleReader.getInstance();

        System.out.println("---Updating Insurance Card---");

        System.out.print("Enter Card Number to Update: ");
        data.put(InsuranceCardView.CARD_NUM, reader.read());

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
}

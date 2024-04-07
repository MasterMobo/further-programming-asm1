package views.text.claims;

import models.claims.InsuranceClaim;
import utils.console.ConsoleColors;
import utils.console.ConsoleUtils;
import utils.converters.IntegerConverter;
import utils.converters.TypeConverter;
import views.general.InsuranceClaimView;
import io.readers.ConsoleReader;
import io.readers.DataReader;
import views.sorters.InsuranceClaimSorter;
import views.sorters.Sorter;
import views.system.ViewCode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InsuranceClaimTextView implements InsuranceClaimView {

    @Override
    public void displayItem(InsuranceClaim claim) {
        if (claim == null) {
            System.out.println("Nothing to show");
            return;
        };

        System.out.println("Insurance Claim (" + claim.getId() + "): "
                            + "\n\tInsured Customer ID: " + claim.getInsuredPersonId()
                            + "\n\tInsurance Card Number: " + claim.getCardNumber()
                            + "\n\tClaim Date: " + claim.getClaimDate()
                            + "\n\tClaim Status: " + claim.getStatus()
                            + "\n\tClaim Amount: " + claim.getClaimAmount()
                            + "\n\tExam Date: " + claim.getExamDate()
                            + "\n\tReceiver Bank Info: " + claim.getReceiverBankInfo()
                            + "\n\tDocuments: " + claim.getDocuments()
        );
    }

    private Map<String, String> displayBasicForm() {
        Map<String, String> data = new HashMap<>();
        DataReader reader = ConsoleReader.getInstance();

        System.out.print("Enter Insured Customer Id: ");
        data.put(INSURED_PERSON, reader.read());

        System.out.print("Enter Claim Date (mm/dd/yyyy): ");
        data.put(CLAIM_DATE, reader.read());

        System.out.print("Enter Exam Date (mm/dd/yyyy): ");
        data.put(EXAM_DATE, reader.read());

        System.out.print("Enter Claim Amount: ");
        data.put(CLAIM_AMOUNT, reader.read());

        System.out.print("Enter Claim Status (new, done, processing): ");
        data.put(CLAIM_STATUS, reader.read());

        String bankInfo = displayBankInfoForm();
        data.put(RECEIVER_BANK, bankInfo);

        String documents = displayDocumentForm();
        data.put(DOCUMENTS, documents);

        return data;
    }

    @Override
    public Map<String, String> displayAddForm() {
        System.out.println("---Adding new Insurance Claim---");
        return displayBasicForm();
    }

    @Override
    public Map<String, String> displayUpdateForm() {
        System.out.println("---Updating Insurance Claim---");
        Map<String, String> data = new HashMap<>();
        DataReader reader = ConsoleReader.getInstance();

        System.out.print("Enter Insurance Claim ID to Update: ");
        data.put(CLAIM_ID, reader.read());

        data.putAll(displayBasicForm());
        return data;
    }

    private String displayDocumentForm() {
        DataReader reader = ConsoleReader.getInstance();
        TypeConverter<Integer> intConverter = new IntegerConverter();

        StringBuilder documents = new StringBuilder();
        System.out.println("How many documents would you want to create for this claim? ");
        String input = reader.read();

        try {
            int docCount = intConverter.fromString(input);

            for (int i = 1; i <= docCount; i++) {
                System.out.print("Enter Document " + i + " Name: ");
                String docName = reader.read();
                documents.append(docName);
                documents.append("\n");
            }

            return documents.toString();
        } catch (IllegalArgumentException exception) {
            ConsoleUtils.printRed("Invalid number, please try again");
            return displayDocumentForm();
        }

    }

    private String displayBankInfoForm() {
        DataReader reader = ConsoleReader.getInstance();
        String s = "";

        System.out.print("Enter Bank Name: ");
        s += reader.read() + "-";

        System.out.print("Enter Account Name: ");
        s += reader.read() + "-";

        System.out.print("Enter Account Number: ");
        s += reader.read();

        return s;
    }

    @Override
    public Map<String, String> displayDeleteForm() {
        Map<String, String> data = new HashMap<>();
        DataReader reader = ConsoleReader.getInstance();
        System.out.println("---Deleting Insurance Claim---");
        System.out.print("Enter Insurance Claim ID to Delete: ");

        data.put(InsuranceClaimView.CLAIM_ID, reader.read());

        return data;
    }

    @Override
    public boolean displayDeleteConfirm() {
        DataReader reader = ConsoleReader.getInstance();
        ConsoleUtils.printYellow("Are you sure you want to delete this Insurance Claim? (y/n)");
        ConsoleUtils.printRed("(This action is irreversible)");

        return reader.read().equalsIgnoreCase("y");
    }

    @Override
    public Map<String, String> displayGetForm() {
        Map<String, String> data = new HashMap<>();
        DataReader reader = ConsoleReader.getInstance();

        System.out.print("Enter Insurance Claim ID: ");
        data.put(InsuranceClaimView.CLAIM_ID, reader.read());

        return data;
    }

    @Override
    public Map<String, String> displayGetManyForm() {
        Map<String, String> data = new HashMap<>();
        DataReader reader = ConsoleReader.getInstance();

        System.out.println("--Getting Insurance Claims---");

        System.out.print("Enter Customer ID (leave empty to get all claims): ");
        data.put(InsuranceClaimView.INSURED_PERSON, reader.read().trim());

        return data;
    }

    @Override
    public String getId() {
        return ViewCode.INSURANCE_CLAIMS;
    }

    @Override
    public void displayMany(List<List<InsuranceClaim>> res) {
        if (res.get(0).size() == 0 && res.get(1).size() == 0) {
            System.out.println(ConsoleColors.BLUE + "Nothing to show" + ConsoleColors.RESET);
            return;
        }

        Sorter<InsuranceClaim> sorter = new InsuranceClaimSorter();
        int i  = 0;
        for (InsuranceClaim mainClaim: sorter.sort(res.get(0))) {
            displayItem(mainClaim);
            System.out.println(i);
        }

        if (res.get(1).size() == 0) {
            return;
        }

        System.out.println("---Dependent Claims---");
        for (InsuranceClaim dependentClaim: sorter.sort(res.get(1))) {
            displayItem(dependentClaim);
        }
    }
}

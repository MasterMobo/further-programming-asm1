package views.text.claims;

import models.claims.InsuranceClaim;
import utils.converters.DateConverter;
import utils.converters.IntegerConverter;
import utils.converters.TypeConverter;
import views.general.InsuranceClaimView;
import views.io.ConsoleReader;
import views.io.DataReader;
import views.system.ViewCode;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class InsuranceClaimTextView implements InsuranceClaimView {

    @Override
    public void displayItem(InsuranceClaim claim) {
        // TODO: fill this out
        System.out.println("Insurance Claim: " + claim.getId());
    }

    @Override
    public Map<String, String> displayAddForm() {
        Map<String, String> data = new HashMap<>();
        DataReader reader = ConsoleReader.getInstance();

        System.out.println("---Adding new Insurance Claim---");

        System.out.print("Enter Insured Customer Id: ");
        data.put(INSURED_PERSON, reader.read());

        System.out.print("Enter Claim Date: ");
        data.put(CLAIM_DATE, reader.read());

        System.out.print("Enter Exam Date: ");
        data.put(EXAM_DATE, reader.read());

        System.out.print("Enter Claim Amount: ");
        data.put(CLAIM_AMOUNT, reader.read());

        System.out.print("Enter Claim Status (new, done, processing): ");
        data.put(CLAIM_STATUS, reader.read());

        System.out.println("Enter Receiver Bank Info (Bank – Name – Number): ");
        data.put(RECEIVER_BANK, reader.read());

        String documents = displayDocumentCreateForm();
        System.out.println(documents);
        data.put(DOCUMENTS, documents);

        return data;
    }

    private String displayDocumentCreateForm() {
        DataReader reader = ConsoleReader.getInstance();
        TypeConverter<Integer> intConverter = new IntegerConverter();

        StringBuilder documents = new StringBuilder();
        System.out.println("How many documents would you want to create for this claim? ");
        int docCount = intConverter.fromString(reader.read());

        for (int i = 1; i <= docCount; i++) {
            System.out.print("Enter Document " + i + " Name: ");
            String docName = reader.read();
            documents.append(docName);
            documents.append("\n");
        }

        return documents.toString();
    }

    @Override
    public void displaySuccessAddMsg() {
        System.out.println("Successfully added new Insurance Claim!");
    }

    @Override
    public String getId() {
        return ViewCode.INSURANCE_CLAIMS;
    }
}

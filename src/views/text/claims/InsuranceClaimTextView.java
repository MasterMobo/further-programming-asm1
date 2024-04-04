package views.text.claims;

import models.claims.InsuranceClaim;
import utils.converters.DateConverter;
import utils.converters.IntegerConverter;
import utils.converters.TypeConverter;
import views.general.InsuranceClaimView;
import views.io.ConsoleReader;
import views.io.DataReader;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class InsuranceClaimTextView implements InsuranceClaimView {

    @Override
    public void displayInsuranceClaim(InsuranceClaim claim) {
        // TODO: fill this out
        System.out.println("Insurance Claim: " + claim.getId());
    }

    @Override
    public Map<String, String> displayCreateClaimForm() {
        Map<String, String> data = new HashMap<>();
        DataReader reader = ConsoleReader.getInstance();

        System.out.print("Enter Insured Customer Id: ");
        data.put(INSURED_PERSON, reader.read());


        System.out.print("Enter Claim Date: ");
        data.put(CLAIM_DATE, reader.read());

        System.out.print("Enter Exam Date: ");
        data.put(EXAM_DATE, reader.read());

        System.out.print("Enter Claim Amount: ");
        data.put(CLAIM_AMOUNT, reader.read());

        System.out.print("Enter Claim Status: ");
        data.put(CLAIM_STATUS, reader.read());

        System.out.print("Enter Receiver Bank Info: ");
        data.put(RECEIVER_BANK, reader.read());

        String documents = displayDocumentCreateForm();
        System.out.println(documents);
        data.put(DOCUMENTS, documents);

        return data;
    }

    @Override
    public void displayMessage(String s) {
        System.out.println(s);
    }

    @Override
    public void displayError(String s) {
        System.out.println(s);
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
}

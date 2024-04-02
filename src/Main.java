import inputs.*;

public class Main {
    public static void main(String[] args) {
//        Customer josh = new Dependent("123", "Josh Keplin");
//        Customer keith = new Dependent("224", "Keith Mulligan");
//        Customer mary = new PolicyHolder("223", "Mary Jane");
//
//        ((PolicyHolder) mary).addDependent((Dependent) josh);
//        ((PolicyHolder) mary).addDependent((Dependent) keith);
//
//        PolicyOwner rmit = new PolicyOwner("RMIT");
//
//        InsuranceCard joshCard = InsuranceCard.createInsuranceCard("12345", josh, rmit, new Date("01/03/2024"));
//
//        Document joshDocument = new Document("VCB", "1233");
//        List<Document> docs = List.of(new Document[]{joshDocument});
//        BankInfo bankInfo = new BankInfo("VSCW", "1231444");
//
//        InsuranceClaim joshClaim = new InsuranceClaim("12233", new Date("12/03/2023"), josh, joshCard.getCardNumber(), new Date("12/03/2023"), docs, 123.3, ClaimStatus.NEW, bankInfo);
//
//        InsuranceClaimSystem system = new InsuranceClaimSystem();
//        system.add(josh);
//        system.add(joshCard);
//        system.add(joshClaim);
//
//        System.out.println(system.getCustomer());
//        System.out.println(system.getInsuranceCard());
//        System.out.println(system.getInsuranceClaim());

        DataReader<Double> reader = new ConsoleReader<>(new DoubleConverter());
        double d = reader.read();
        System.out.println(d);
    }
}
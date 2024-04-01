package claims;

public class BankInfo {
    private String bankName;
    private String accountNumber;

    public BankInfo() {
        bankName = "Default";
        accountNumber = "Default";
    }

    public BankInfo(String bankName, String accountNumber) {
        this.bankName = bankName;
        this.accountNumber = accountNumber;
    }
}

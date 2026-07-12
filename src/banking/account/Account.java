package banking.account;

public class Account {

    private static long counter=11111111;
    private long accountNumber;
    private String holderName;
    private double balance;

    Account(String name) {
        this.accountNumber=counter++;
        this.holderName=name;
        this.balance=0.0;
    }

    public double getBalance() {
        return balance;
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public String getHolderName() {
        return holderName;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountNumber=" + accountNumber +
                ", holderName='" + holderName + '\'' +
                ", balance=" + balance +
                '}';
    }
}

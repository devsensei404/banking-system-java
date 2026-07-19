package banking.account;
import banking.transaction.Transaction;
import java.util.List;
import java.util.ArrayList;

public abstract class Account {

    private static long counter=11111111;
    private long accountNumber;
    private String holderName;
    private double balance;
    private List<Transaction> transactionList;
    private static final double MIN_DEPOSIT = 500.0;

    protected Account(String name) {
        this.accountNumber=counter++;
        this.holderName=name;
        this.balance=0.0;
        this.transactionList = new ArrayList<>();
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

    public void addTransaction(Transaction transaction){
        transactionList.add(transaction);
    }

    public List<Transaction> getTransactionList() {
        return new ArrayList<>(transactionList);
    }

    protected void reduceBalance(double amount) {
        if (amount > 0) {
            balance -= amount;
        }
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountNumber=" + accountNumber +
                ", holderName='" + holderName + '\'' +
                ", balance=" + balance +
                '}';
    }

    public boolean deposit(double amount) {
        if (amount < MIN_DEPOSIT) {
            return false;
        }
        balance += amount;
        return true;
    }

    public abstract WithdrawResult withdraw(double amount, boolean forceOverride);
}

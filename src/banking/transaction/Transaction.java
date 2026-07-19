package banking.transaction;

import  java.time.LocalDateTime;


public class Transaction {

    private static long id=80808080;
    private final long transactionId;
    private final double amount;
    private final TransactionType type;
    private final LocalDateTime timestamp;

    public Transaction(double amount, TransactionType type){

        this.transactionId=id++;
        this.amount=amount;
        this.type=type;
        this.timestamp=LocalDateTime.now();

    }

    public long getTransactionId() {
        return transactionId;
    }

    public double getAmount() {
        return amount;
    }

    public TransactionType getType() {
        return type;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "transactionId=" + transactionId +
                ", amount=" + amount +
                ", type=" + type +
                ", timestamp=" + timestamp +
                '}';
    }
}

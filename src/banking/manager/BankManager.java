package banking.manager;
import java.util.Map;
import java.util.HashMap;
import banking.account.*;
import banking.transaction.TransactionType;
import banking.transaction.Transaction;
import java.util.List;
import java.util.ArrayList;

public class BankManager {

    private Map<Long, Account> accounts;

    public BankManager() {
        this.accounts = new HashMap<>();
    }

    public long createAccount(String name,int type){
        if(type==1){
            SavingsAccount savingsAccount= new SavingsAccount(name);
            accounts.put(savingsAccount.getAccountNumber(), savingsAccount);
            return savingsAccount.getAccountNumber();
        }
        else if(type==2){
            CurrentAccount currentAccount= new CurrentAccount(name);
            accounts.put(currentAccount.getAccountNumber(), currentAccount);
            return currentAccount.getAccountNumber();
        }
        else {
            return -1;
        }
    }

    public String getBalance(long accNum){

        Account account = accounts.get(accNum);
        if (account == null) {
            return "Account not found.";
        }
        return("Balance in your account is : " + account.getBalance());

    }

    public String deposit(long accNum,double amount){

        Account account = accounts.get(accNum);
        if (account == null) {
            return "Account not found.";
        }
        if(account.deposit(amount)) {
            account.addTransaction(new Transaction(amount, TransactionType.CREDIT));
            return ("Amount deposited Successfully. Current Balance: " + account.getBalance());
        }
        else
            return("Amount less than minimum deposit");
    }

        public WithdrawResult withdraw(long accNum, double amount, boolean forceOverride) {
            Account account = accounts.get(accNum);
            if (account == null) return null;
            WithdrawResult result = account.withdraw(amount, forceOverride);
            if (result == WithdrawResult.SUCCESS) {
                account.addTransaction(new Transaction(amount, TransactionType.DEBIT));
            }
            return result;
        }

        public List<String> getTransactionHistory(long accNum) {
            Account account = accounts.get(accNum);
            if (account == null) {
                return null;
            }

            List<Transaction> transactions = account.getTransactionList();
            List<String> history = new ArrayList<>();

            if (transactions.isEmpty()) {
                history.add("No transactions yet.");
                return history;
            }

            for (Transaction t : transactions) {
                history.add(t.getType() + " of " + t.getAmount() + " on " + t.getTimestamp() + " (ID: " + t.getTransactionId() + ")");
            }

            return history;
        }

    }


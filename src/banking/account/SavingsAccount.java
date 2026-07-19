package banking.account;

public class SavingsAccount extends Account {

    private static final double MIN_BALANCE=5000.0;

    public SavingsAccount(String name){
        super(name);
    }

    @Override
    public WithdrawResult withdraw(double amount, boolean forceOverride) {
        if (amount <= 0) return WithdrawResult.INVALID_AMOUNT;
        if (getBalance() < amount) return WithdrawResult.INSUFFICIENT_FUNDS;
        if (getBalance() < MIN_BALANCE + amount && !forceOverride) return WithdrawResult.BELOW_MINIMUM_BALANCE;
        reduceBalance(amount);
        return WithdrawResult.SUCCESS;
    }


}

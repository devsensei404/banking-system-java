package banking.account;

public class CurrentAccount extends Account {

    private static final double OVERDRAFT_LIMIT=10000.0;

    public CurrentAccount(String name){
        super(name);
    }

    @Override
    public WithdrawResult withdraw(double amount, boolean forceOverride) {
        if (amount <= 0) return WithdrawResult.INVALID_AMOUNT;
        if (getBalance() + OVERDRAFT_LIMIT < amount) return WithdrawResult.EXCEEDS_OVERDRAFT_LIMIT;
        reduceBalance(amount);
        return WithdrawResult.SUCCESS;
    }
}


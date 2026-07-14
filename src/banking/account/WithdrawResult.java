package banking.account;

public enum WithdrawResult {
    SUCCESS,
    INVALID_AMOUNT,
    INSUFFICIENT_FUNDS,
    BELOW_MINIMUM_BALANCE,
    EXCEEDS_OVERDRAFT_LIMIT
}
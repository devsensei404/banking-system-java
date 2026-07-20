package banking.menu;

import banking.account.WithdrawResult;
import banking.manager.BankManager;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BankManager bankManager = new BankManager();

        boolean running = true;
        while (running) {
            System.out.println("""
                    \n---------- BANKING SYSTEM ----------
                    1. Create Account
                    2. Deposit
                    3. Withdraw
                    4. Check Balance
                    5. Transaction History
                    6. Exit
                    """);

            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter holder name: ");
                    String name = scanner.nextLine();
                    System.out.println("1. Savings  2. Current");
                    System.out.print("Choose account type: ");
                    int type = scanner.nextInt();
                    scanner.nextLine();
                    if(type!=1&&type!=2)
                        System.out.println("Invalid choice\n");
                    else
                        System.out.println("Account created successfully. Account number: "+ bankManager.createAccount(name, type));
                }
                case 2 -> {
                    System.out.print("Enter account number: ");
                    long accNum = scanner.nextLong();
                    System.out.print("Enter deposit amount: ");
                    double amount = scanner.nextDouble();
                    System.out.println(bankManager.deposit(accNum, amount));
                }
                case 3 -> {
                    System.out.print("Enter account number: ");
                    long accNum = scanner.nextLong();
                    System.out.print("Enter withdrawal amount: ");
                    double amount = scanner.nextDouble();
                    WithdrawResult result = bankManager.withdraw(accNum, amount, false);

                    if (result == null) {
                        System.out.println("Account not found.");
                    } else {
                        if (result == WithdrawResult.BELOW_MINIMUM_BALANCE) {
                            System.out.print("This will breach minimum balance. Proceed anyway? (y/n): ");
                            scanner.nextLine();
                            String confirm = scanner.nextLine();
                            if (confirm.equalsIgnoreCase("y")) {
                                result = bankManager.withdraw(accNum, amount, true);
                            }
                        }
                        if(result == WithdrawResult.SUCCESS) {
                            System.out.println("Withdrawal successful.");
                        } else if (result == WithdrawResult.INSUFFICIENT_FUNDS) {
                            System.out.println("Insufficient funds.");
                        } else if (result == WithdrawResult.BELOW_MINIMUM_BALANCE) {
                            System.out.println("Withdrawal would breach minimum balance.");
                        }
                    }
                }
                case 4 -> {
                    System.out.print("Enter account number: ");
                    long accNum = scanner.nextLong();
                    System.out.println(bankManager.getBalance(accNum));
                }
                case 5 -> {
                    System.out.print("Enter account number: ");
                    long accNum = scanner.nextLong();
                    List<String> history = bankManager.getTransactionHistory(accNum);
                    if (history == null) {
                        System.out.println("Account not found.");
                    } else {
                        for (String line : history) {
                            System.out.println(line);
                        }
                    }
                }
                case 6 -> {
                    System.out.println("Goodbye. Signing Off");
                    running = false;
                }
                default -> System.out.println("Invalid option, try again.");
            }
        }
        scanner.close();
    }
}
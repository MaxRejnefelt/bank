package org.example;

import org.example.bank.Account;
import org.example.bank.CreditAccount;
import org.example.bank.SavingsAccount;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final List<Account> accounts = new ArrayList<>();
    private static SavingsAccount savingsAccount;
    private static CreditAccount creditAccount;



    public static void main(String[] args) {
        int option;

        do {
            option = runMainMenu();
            executeMenu(option);
        }while (option != 0);

    }


    private static int runMainMenu(){
        System.out.println("\n");
        System.out.println("----- Main menu -----");
        System.out.println("1. Open a account");
        System.out.println("2. Deposit money");
        System.out.println("3. Withdraw money");
        System.out.println("4. Transfer money");
        System.out.println("5. Show account information");
        System.out.println("0. Exit");
        System.out.print("Select option: ");
        
        int option = scanner.nextInt();
        scanner.nextLine();
        return option;
    }

   private static void showAccountInfo(Account account){

            if (account instanceof SavingsAccount savings) {
                System.out.println("Balance: " + savings.getBalance());
                System.out.println("Account number: " + savings.getAccountNumber());
                System.out.println("Interest rate: " + savings.getInterestRate() + "%");
                savings.calculateRate();

            } else if (account instanceof CreditAccount credit) {
                System.out.println("Balance: " + credit.getBalance());
                System.out.println("Account number: " + credit.getAccountNumber());
                creditAccount.showCreditLimit(credit.getBalance());

            } else System.out.println("No savings or credit account found");

   }

    private static void executeMenu(int option){
        switch (option){
            case 0:
                System.out.println("Exit program...");
                break;

            case 1:
                System.out.println("Do you want to open a savings or credit account? "); //check what account to open
                String whatAccount = scanner.nextLine();

                if (!whatAccount.equalsIgnoreCase("savings") && !whatAccount.equalsIgnoreCase("credit")) {
                    System.out.println("Invalid option. Please choose either 'savings' or 'credit'.");
                    break;
                }

                System.out.print("Enter account number: ");
                String accountNumber = scanner.nextLine();
                boolean accountExists = false;


                for (Account account : accounts){
                    if (account.getAccountNumber().equalsIgnoreCase(accountNumber)){
                        accountExists = true;
                        break;
                    }
                }
                if (accountExists){
                    System.out.println("Account already exists with account number " + accountNumber);
                    break;
                }

                /*Create account if no account already exists*/

                if (whatAccount.equalsIgnoreCase("savings")){
                    savingsAccount = new SavingsAccount(accountNumber,0,2); //open a saving
                    accounts.add(savingsAccount);
                    System.out.println("A account has been created with account number: " + accountNumber);

                }
                if (whatAccount.equalsIgnoreCase("credit")) {
                    creditAccount = new CreditAccount(accountNumber,0); //open a credit
                    accounts.add(creditAccount);
                    System.out.println("A account has been created with account number: " + accountNumber);
                }
                break;




                /*
                deposit to account
                */
            case 2:
                System.out.print("Enter account number for deposit: ");
                String depositAccountNumber = scanner.nextLine();
                boolean accountFoundDeposit = false;
                    for (Account account : accounts) {
                        if (depositAccountNumber.equalsIgnoreCase(account.getAccountNumber())) {
                            accountFoundDeposit = true;
                            System.out.print("Enter amount to deposit: ");
                            int deposit = scanner.nextInt();
                            scanner.nextLine();
                            account.depositMoney(deposit);
                            break;
                        }
                    }if (!accountFoundDeposit){
                        System.out.println("Account not found, try a different account number!");
                    }
                break;

                    /*
                     withdraw from account
                     */
            case 3:
                System.out.print("Enter account number for withdrawal: ");
                String withdrawAccountNumber = scanner.nextLine();
                boolean accountFoundWithdraw = false;
                for (Account account : accounts){
                    if (withdrawAccountNumber.equalsIgnoreCase(account.getAccountNumber())){
                        accountFoundWithdraw = true;
                        System.out.print("Enter amount to withdraw: ");
                        int withdraw = scanner.nextInt();
                        account.withdrawMoney(withdraw);
                        break;
                    }
                }if (!accountFoundWithdraw){
                System.out.println("Account not found, try a different account number!");

            }break;



                /*
                Transfer money between accounts
                */

            case 4:
                System.out.print("Enter account number to transfer from: ");
                String transferFromAccount = scanner.nextLine();
               Account fromAccount = null;
               Account toAccount = null;
               for (Account account : accounts){
                   if (account.getAccountNumber().equalsIgnoreCase(transferFromAccount)){
                       fromAccount = account;
                       break;
                   }
               }
               if (fromAccount == null){
                System.out.println("Account not found, try a different account number");
               break;
               }

                System.out.print("Enter account number to transfer to: ");
               String transferToAccount = scanner.nextLine();
                for (Account account : accounts){
                    if (transferToAccount.equalsIgnoreCase(account.getAccountNumber())){
                        toAccount = account;
                        break;
                    }
                }
                if (toAccount == null){
                System.out.println("Account not found, try a different account number");
                break;
                }

                System.out.print("Enter amount to transfer: ");
                int transfer = scanner.nextInt();
                fromAccount.transferMoney(transfer,toAccount,fromAccount);
                break;


                /*
                Show account information
                */

            case 5:
                System.out.print("Enter account number: ");
                String accountInfo = scanner.nextLine();
                boolean accountFound = false;
                for (Account account : accounts){
                    if (accountInfo.equals(account.getAccountNumber())){
                       showAccountInfo(account);
                       accountFound = true;
                       break;
                    }

                }
                if (!accountFound){
                    System.out.println("Account not found, try a different account number");
                }
                break;


        }
    }
}

package org.example.bank;

public abstract class Account {

    private String accountNumber;
    private int balance;




    public Account(String accountNumber, int balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;

    }

    public String getAccountNumber() {
        return accountNumber;
    }




    public int getBalance() {
        return balance;
    }



    public void depositMoney(int deposit){
        if (deposit > 0){
            balance += deposit;
            System.out.println("Deposited: " + deposit + ". New balance is: " + balance);
        }else System.out.println("Invalid deposit, try again!");

    }

    public void withdrawMoney(int withdraw){
        if (balance > 0 && balance >= withdraw){
            balance -= withdraw;
            System.out.println("Withdrew: " + withdraw + ". New balance is: " + balance);
        }else System.out.println("Invalid withdraw amount or insufficient funds, try again!");

    }

    public void transferMoney(int transfer, Account transferAccount, Account transferFromAccount){
        if (transfer > 0 && transfer <= transferFromAccount.getBalance()){
            transferFromAccount.balance -= transfer;
            transferAccount.balance += transfer;
            System.out.println("Transferred " + transfer + " from account " + transferFromAccount.getAccountNumber() +
                    ". New balance is: " +
                    transferFromAccount.getBalance());
            System.out.print("Transferred " + transfer + " to account " + transferAccount.getAccountNumber() +
                    ". New balance is: " +
                   transferAccount.getBalance());

        }
        else System.out.println("Transfer failed, try again!");

    }






   
}


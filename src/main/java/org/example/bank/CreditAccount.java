package org.example.bank;

public class CreditAccount extends Account{

    private int creditLimit;


    public CreditAccount(String accountNumber, int balance) {
        super(accountNumber, balance);

    }

        public void showCreditLimit(int balance){
        if (balance > 20000){
            creditLimit = balance / 2;
            System.out.println("Your credit limit is: " + creditLimit);
            
        } else {

           creditLimit = balance / 5;
            System.out.println("Your credit limit is: " + creditLimit);

        }
    }


}

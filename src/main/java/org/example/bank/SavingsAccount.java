package org.example.bank;

public class SavingsAccount extends Account{
 private  double interestRate;

    public SavingsAccount(String accountNumber, int balance, double interestRate) {
        super(accountNumber, balance);
        this.interestRate = interestRate;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void calculateRate(){

        double rate = (getBalance() * getInterestRate()) / 100;
        System.out.println("Your rate for a year is: " + rate + " sek");

    }




}

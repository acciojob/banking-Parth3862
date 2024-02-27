package com.driver;

import java.util.Random;

public class BankAccount {

    private String name;
    private double balance;
    private double minBalance;

    public BankAccount(String name, double balance, double minBalance) {
            this.name=name;
            this.balance=balance;
            this.minBalance=minBalance;
    }

    public double getBalance(){
        return balance;
    }
    public void setBalance(double balance){
        this.balance=balance;
    }

    public String generateAccountNumber(int digits, int sum) throws Exception{
        //Each digit of an account number can lie between 0 and 9 (both inclusive)
        //Generate account number having given number of 'digits' such that the sum of digits is equal to 'sum'
        //If it is not possible, throw "Account Number can not be generated" exception
        if(sum<0 || sum>9*digits){
            throw new Exception("Account Number can not be generated");
        }
        StringBuilder accountNo = new StringBuilder();
        Random random = new Random();
        int remainingSum = sum;
        for(int i=0;i<digits;i++){
            int maxDigit=Math.min(9,remainingSum);
            int digit = random.nextInt(maxDigit+1);
            accountNo.append(digit);
            remainingSum-=digit;
        }
        return accountNo.toString();
    }

    public void deposit(double amount) {
        //add amount to balance
        balance+=amount;
    }

    public void withdraw(double amount) throws Exception {
        // Remember to throw "Insufficient Balance" exception, if the remaining amount would be less than minimum balance
        if(balance-amount<minBalance){
            throw new Exception("Insufficient Balance");
        }
        balance-=amount;
    }

}
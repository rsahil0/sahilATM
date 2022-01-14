package com.company;

import java.text.DecimalFormat;
import java.util.Scanner;

public class atmMachine {
    Scanner sc = new Scanner(System.in);
    DecimalFormat moneyFormats = new DecimalFormat("'$'###,##0.000");
    private int customerNumber;
    private int pinNumber;
    private double currentBalance;
    private double savingBalance;

    public int setCustomerNumber(int customerNumber) {
        this.customerNumber = customerNumber;
        return customerNumber;
    }

    public int setPinNumber(int pinNumber) {
        this.pinNumber = pinNumber;
        return pinNumber;
    }

    public int getCustomerNumber() {
        return customerNumber;
    }

    public int getPinNumber() {
        return pinNumber;
    }

    public double getCurrentBalance() {
        return currentBalance;
    }

    public double getSavingBalance() {
        return savingBalance;
    }

    //Calculating Current Amount Withdrawal
    public double calcCurrentWithdrawal(double amount) {
        currentBalance = (currentBalance - amount);
        return currentBalance;
    }

    //Calculating Saving Account Withdrawal
    public double calcSavingWithdrawal(double amount) {
        savingBalance = (savingBalance - amount);
        return savingBalance;
    }

    //Calculating Current Amount Deposit
    public double calcCurrentDeposit(double amount) {
        currentBalance = (currentBalance + amount);
        return currentBalance;
    }

    //Calculating Saving Amount Deposit
    public double calcSavingDeposit(double amount) {
        savingBalance = (savingBalance + amount);
        return savingBalance;
    }

    //Customer Current Account Withdrawal Input
    public void getCurrentWithdrawalInput() {
        System.out.println("CURRENT Account Balance is: " + moneyFormats.format(currentBalance));
        if (currentBalance == 0) {
            System.out.println("your balance is 00.000" + "\n");
        }
        else {
            System.out.println("Please Enter The Amount you want to Withdrawal from CURRENT Account: ");
            double amount = sc.nextDouble();
            if ((currentBalance + amount) > 0) {
                calcCurrentWithdrawal(amount);
                System.out.println("New CURRENT account Balance: " + currentBalance);
            } else if ((currentBalance + amount) == 0) {
                System.out.println("Please Enter The Valid Amount" + "\n");
            } else {
                System.out.println("Balance can not be !(-) Negative" + "\n");
            }
        }
    }



    //Customer Saving Account Withdraw Input
    public void getSavingWithdrawInput() {
        System.out.println("SAVING account balance is: " + moneyFormats.format(savingBalance));
        if (savingBalance == 0) {
            System.out.println("your balance is 00.000" + "\n");
        }
        else {
            System.out.println("Please Enter The Amount you want to Withdraw form SAVING Account: ");
            double amount = sc.nextDouble();
            if ((savingBalance + amount) > 0) {
                calcSavingWithdrawal(amount);
                System.out.println("New SAVING Account " + savingBalance + "\n");
            } else if ((savingBalance + amount) == 0) {
                System.out.println("Please Enter The Valid Amount" + "\n");
            } else {
                System.out.println("Balance can not be !(-) Negative" + "\n");
            }
        }
    }

    //Customer Current Account Deposit Input
    public void getCurrentDepositInput() {
        System.out.println("CURRENT Account Balance is: " + moneyFormats.format(currentBalance));
        System.out.println("Please Enter The Amount you want to Deposit in CURRENT Account: ");
        double amount = sc.nextDouble();
        if ((currentBalance + amount) > 0) {
            calcCurrentDeposit(amount);
            System.out.println("New CURRENT Account Balance" + moneyFormats.format(currentBalance));
        } else if (amount  ==0) {
            System.out.println("Please Enter The Valid Amount"+ "\n");
        }
        else {
            System.out.println("Balance can not be !(-) negative" + "\n");
        }
    }

    //Customer Saving Account Deposit Input
    public void getSavingDepositInput() {
        System.out.println("SAVING account balance is : " + moneyFormats.format(savingBalance));
        System.out.println("Please Enter The Amount you want to Deposit in SAVING Account: ");
        double amount = sc.nextDouble();
        if ((savingBalance + amount) > 0) {
            calcSavingDeposit(amount);
            System.out.println("New SAVING Account " + moneyFormats.format(savingBalance) + "\n");
       }
        else if (amount==0){
            System.out.println("Please Enter The Valid Amount"+ "\n");
        }
        else {
            System.out.println("Balance can not be !(-) Negative" + "\n");
        }
    }
}

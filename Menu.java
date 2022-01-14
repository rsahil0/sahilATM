package com.company;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

public class Menu extends atmMachine {
    Scanner menuInput = new Scanner(System.in);
    DecimalFormat money = new DecimalFormat("'$'###,##0.00");
    HashMap<Integer,Integer> data = new HashMap<Integer,Integer>();
    public void getLogin()throws IOException {
        int x = 1;
        do {
            try {
                data.put(123, 123);
                data.put(212212, 212);
                System.out.println("Welcome To The ATM Project");
                System.out.println("Enter your Customer Number");
                setCustomerNumber(menuInput.nextInt());
                System.out.println("Enter your Pin Number");
                setPinNumber(menuInput.nextInt());
            } catch (Exception e) {
                System.out.println("Invalid character, Enter only Number " + "\n");
                x = 2;
            }

            for (Entry<Integer, Integer> entry : data.entrySet()) {
                if (entry.getKey() == getCustomerNumber() && entry.getValue() == getPinNumber()) {
                    getAccountType();
                }
            }
            System.out.println("Wrong customer Number or ID" + "\n");
        }while (x==1);
    }
    int selection;

    //To Display Account Menu
    public void getAccountType (){
        System.out.println("Select the Account you want to Access");
        System.out.println("Type 1: CURRENT Account");
        System.out.println("Type 2: SAVING Account");
        System.out.println("Type 3: Exit");
        System.out.print("Choice : ");
        selection = menuInput.nextInt();

        switch (selection){
            case 1:
                getChecking();
                break;
            case 2 :
                getSaving();
                break;
            case 3:
                System.out.println("  **** Thank you For Using This ATM ****  ");
                System.exit(0);

                break;
            default:
                System.out.println("Invalid Choice"+ "\n");
                getAccountType();
        }
    }
    //Display Current Account Menu with selection
    public void getChecking(){
        System.out.println("CURRENT Account");
        System.out.println("Type 1: View Balance");
        System.out.println("Type 2: Withdraw Funds");
        System.out.println("Type 3: Deposit Funds");
        System.out.println("Type 4: Exit");
        System.out.println("Choice : "+ "\n");
        selection = menuInput.nextInt();
        switch (selection){
            case 1:
                System.out.println("CURRENT Account Balance is: "+ money.format(getCurrentBalance()));
                getAccountType();
                break;
            case 2:
                getCurrentWithdrawalInput();
                getAccountType();
                break;
            case 3:
                getCurrentDepositInput();
                getAccountType();
                break;
            case 4:
                System.out.println("  **** Thank you For Using This ATM ****  ");
            System.exit(0);

                break;
            default:
                System.out.println("\n"+ "Invalid Choice " + "\n");
                getChecking();
        }
    }
    //Display Saving Account Menu With selection
    public void getSaving(){
        System.out.println("SAVING Account");
        System.out.println("Type 1: View Balance");
        System.out.println("Type 2: Withdraw Funds");
        System.out.println("Type 3: Deposit Funds");
        System.out.println("Type 4: Exit");
        System.out.println("Choice : "+ "\n");
        selection = menuInput.nextInt();
        switch (selection){
            case 1:
                System.out.println("SAVING Account Balance is: "+ money.format(getSavingBalance()));
                getAccountType();
                break;
            case 2:
                getSavingWithdrawInput();
                getAccountType();
                break;
            case 3:
                getSavingDepositInput();
                getAccountType();
                break;
            case 4:
                System.out.println("  **** Thank you For Using This ATM ****  ");
                System.exit(0);

                break;
            default:
                System.out.println("\n"+ "Invalid Choice "+ "\n");
                getSaving();
        }
    }
}

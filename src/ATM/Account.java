package ATM;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Account {

    private Scanner input;
    private DecimalFormat moneyFormat;

    private int customerNumber;
    private int pinNumber;
    private double checkingBalance = 0;
    private double savingBalance = 0;

    public Account() {
        input = new Scanner(System.in);
        moneyFormat = new DecimalFormat("'$' ###,##0.00");
    }

    /* Set the customer number */
    public void setCustomerNumber(int customerNumber) {
        this.customerNumber = customerNumber;
    }

    /* Get the customer number */
    public int getCustomerNumber() {
        return customerNumber;
    }

    /* Set the pin number */
    public void setPinNumber(int pinNumber) {
        this.pinNumber = pinNumber;
    }

    /* Get the pin number */
    public int getPinNumber() {
        return pinNumber;
    }

    /* Get Checking Account balance */
    public double getCheckingBalance() {
        return checkingBalance;
    }

    /* Get Saving Account balance */
    public double getSavingBalance() {
        return savingBalance;
    }

    /* Calculate Checking Account withdrawal */
    public void calcCheckingWithdraw(double amount) {
        checkingBalance -= amount;
    }

    /* Calculate Saving Account withdrawal */
    public void calcSavingWithdraw(double amount) {
        savingBalance -= amount;
    }

    /* Calculate Checking Account deposit */
    public void calcCheckingDeposit(double amount) {
        checkingBalance += amount;
    }

    /* Calculate Saving Account deposit */
    public void calcSavingDeposit(double amount) {
        savingBalance += amount;
    }

    /* Customer Checking Account Withdraw input */
    public void getCheckingWithdrawInput() {
        System.out.println("Checking Account Balance: " + moneyFormat.format(checkingBalance));
        System.out.println("Amount you want to withdraw from Checking Account:");

        double amount = input.nextDouble();

        if ((checkingBalance - amount) >= 0) {
            calcCheckingWithdraw(amount);
            System.out.println("New Checking Account balance: " + moneyFormat.format(checkingBalance));
        } else {
            System.out.println("Balance cannot be negative." + "\n");
        }
    }

    /* Customer Saving Account Withdraw input */
    public void getSavingWithdrawInput() {
        System.out.println("Saving Account Balance: " + moneyFormat.format(savingBalance));
        System.out.println("Amount you want to withdraw from Saving Account:");

        double amount = input.nextDouble();

        if ((savingBalance - amount) >= 0) {
            calcSavingWithdraw(amount);
            System.out.println("New Saving Account balance: " + moneyFormat.format(savingBalance));
        } else {
            System.out.println("Balance cannot be negative." + "\n");
        }
    }

    /* Customer Checking Account Deposit input */
    public void getCheckingDepositInput() {
        System.out.println("Checking Account Balance: " + moneyFormat.format(checkingBalance));
        System.out.println("Amount you want to Deposit from Checking Account:");

        double amount = input.nextDouble();

        if ((checkingBalance + amount) >= 0) {
            calcCheckingDeposit(amount);
            System.out.println("New Checking Account balance: " + moneyFormat.format(checkingBalance));
        } else {
            System.out.println("Balance cannot be negative." + "\n");
        }
    }

    /* Customer Saving Account Deposit input */
    public void getSavingDepositInput() {
        System.out.println("Saving Account Balance: " + moneyFormat.format(savingBalance));
        System.out.println("Amount you want to Deposit from Saving Account:");

        double amount = input.nextDouble();

        if ((savingBalance + amount) >= 0) {
            calcSavingDeposit(amount);
            System.out.println("New Saving Account balance: " + moneyFormat.format(savingBalance));
        } else {
            System.out.println("Balance cannot be negative." + "\n");
        }
    }
}

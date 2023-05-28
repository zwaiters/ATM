package ATM;

/* Main Class */

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class OptionMenu extends Account {
    Scanner menuInput = new Scanner(System.in);
    DecimalFormat moneyFormat = new DecimalFormat("'$'###,##0.00");

    Map<Integer, Integer> data = new HashMap<>();

    /* Validate Login information customer number and pin */

    public void getLogin() throws IOException {
        int x = 1;

        do {
            try {

                data.put(111111, 1111);
                data.put(222222, 2222);
                data.put(333333, 3333);

                System.out.println("Welcome to the ATM Project!");

                System.out.println("Enter Your Customer Number");
                setCustomerNumber(menuInput.nextInt());

                System.out.println("Enter Your Pin Number:");
                setPinNumber(menuInput.nextInt());


            } catch (Exception e) {
                System.out.println("\n" + "Invalid character(s). Only Numbers." + "\n");
                x = 2;
            }
            for (Map.Entry<Integer, Integer> entry : data.entrySet()) {
                if (entry.getKey() == getCustomerNumber() && entry.getValue() == getPinNumber()) {
                    getAccountType();
                }
            }

            System.out.println("\n" + "Wrong Customer Number or Pin." + "\n");
        } while (x == 1);
    }

    /* Display Account Type Menu with Selection */

    public void getAccountType() {

        System.out.println("Select the Account you wish to access:");
        System.out.println("Type 1 - Checking Account");
        System.out.println("Type 2 - Saving Account");
        System.out.println("Type 3 - Exit");
        System.out.println("Choice: ");

        int selection = menuInput.nextInt();

        switch (selection) {

            case 1:
                getChecking();
                break;

            case 2:
                getSaving();
                break;

            case 3:
                System.out.println("Thank You for using this ATM, goodbye!");
                break;

            default:
                System.out.println("\n" + "Invalid Choice" + "\n");
                getAccountType(); // Prompt for account type again
        }
    }

    private void getSaving() {
    }

    /* Display Checking Account menu with selections */

    public void getChecking() {

        System.out.println("Checking Account:");
        System.out.println("Type 1 - View Balance");
        System.out.println("Type 2 - Withdraw Funds");
        System.out.println("Type 3 - Deposit Funds");
        System.out.println("Type 4 - Exit");
        System.out.println("Choice");

        int selection = menuInput.nextInt();

        switch (selection) {

            case 1:
                System.out.println("Checking Account Balance: " + moneyFormat.format(getCheckingBalance()));
                getAccountType();
                break;

            case 2:
                getCheckingWithdrawInput();
                getAccountType();
                break;

            case 3:
                getCheckingDepositInput();
                getAccountType();
                break;

            case 4:
                System.out.println("Thank You for using this ATM, goodbye!");
                break;

            default:
                System.out.println("\n" + "Invalid choice." + "\n");
                getChecking(); // Prompt for checking account selection again
        }
    }
}

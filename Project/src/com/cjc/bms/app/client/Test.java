package com.cjc.bms.app.client;

import java.util.Scanner;

import com.cjc.bms.app.service.Rbi;
import com.cjc.bms.app.serviceImpl.Sbi;

public class Test {

    public static void main(String[] args) {
        Rbi bank = new Sbi(); // Bank service
        Scanner sa = new Scanner(System.in);
        char ch = 0;

        do {
            try {
                System.out.println("\n========================================");
                System.out.println("Welcome to the Bank Management System");
                System.out.println("1. Create Account");
                System.out.println("2. Display All Details");
                System.out.println("3. Deposit Money");
                System.out.println("4. Withdraw Money");
                System.out.println("5. Check Balance");
                System.out.println("6. Exit");
                System.out.println("========================================");
                System.out.print("Please select an option: ");

                if (!sa.hasNextInt()) {
                    System.out.println("Invalid input. Please enter a number between 1 and 6.");
                    sa.next(); // Clear invalid input
                    continue;
                }

                int choice = sa.nextInt();

                switch (choice) {
                    case 1:
                        bank.createAccount();
                        break;
                    case 2:
                        bank.displayAllDetails();
                        break;
                    case 3:
                        bank.depositeMoney();
                        break;
                    case 4:
                        bank.withdrawal();
                        break;
                    case 5:
                        bank.balanceCheck();
                        break;
                    case 6:
                        System.out.print("Are you sure you want to exit? (Y/N): ");
                        char confirm = sa.next().charAt(0);
                        if (confirm == 'Y' || confirm == 'y') {
                            System.out.println("Thank you for using the Bank Management System. Goodbye!");
                            sa.close();
                            return; // Exit the program
                        }
                        break;
                    default:
                        System.out.println("Invalid choice. Please enter a number between 1 and 6.");
                }

            } catch (Exception e) {
                System.out.println("An error occurred: " + e.getMessage());
                e.printStackTrace();
            }

            System.out.print("\nDo you want to perform another operation? (Y/N): ");
            ch = sa.next().charAt(0);

        } while (ch == 'Y' || ch == 'y');

        System.out.println("Thank you for using the Bank Management System. Goodbye!");
        sa.close();
    }
}

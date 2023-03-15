// AUTHOR: AVISHEK BARUA
// EMAIL: abarua3@toromail.csudh.edu
// DATE: 03/14/2023
import java.io.IOException;
import java.util.Scanner;

public class UserInterface {

	public static void main(String[] args) {

		Scanner scnr = new Scanner(System.in);

		int choice;

		mainMenu();
		choice = scnr.nextInt();
		scnr.nextLine();

		while (choice < 1 || choice > 9) {
			System.out.println();
			System.out.print("INVALID INPUT. PLEASE SELECT AN OPTION FROM THE LIST.");
			System.out.println();
			mainMenu();
			choice = scnr.nextInt();
			scnr.nextLine();
		}

		while (choice != 9) {
			switch (choice) {

			// OPENING CHECKING ACCOUNT
			case 1:
				System.out.println();
				System.out.print("Enter First Name: ");
				String fName = scnr.nextLine();
				System.out.print("Enter Last Name: ");
				String lName = scnr.nextLine();
				System.out.print("Enter Social Security Number: ");
				String SSN = scnr.nextLine();
				System.out.print("Enter Overdraft Limit: ");
				double overdraftLimit = scnr.nextDouble();
				scnr.nextLine();

				Bank.openCheckingAccount(fName, lName, SSN, overdraftLimit);

				mainMenu();
				choice = scnr.nextInt();
				scnr.nextLine();
				while (choice < 1 || choice > 9) {
					System.out.println();
					System.out.print("INVALID INPUT. PLEASE SELECT AN OPTION FROM THE LIST.");
					System.out.println();
					mainMenu();
					choice = scnr.nextInt();
					scnr.nextLine();
				}
				break;

			// OPENING SAVINGS ACCOUNT
			case 2:
				System.out.println();
				System.out.print("Enter First Name: ");
				fName = scnr.nextLine();
				System.out.print("Enter Last Name: ");
				lName = scnr.nextLine();
				System.out.print("Enter Social Security Number: ");
				SSN = scnr.nextLine();

				Bank.openSavingsAccount(fName, lName, SSN);

				mainMenu();
				choice = scnr.nextInt();
				scnr.nextLine();
				while (choice < 1 || choice > 9) {
					System.out.println();
					System.out.print("INVALID INPUT. PLEASE SELECT AN OPTION FROM THE LIST.");
					System.out.println();
					mainMenu();
					choice = scnr.nextInt();
					scnr.nextLine();
				}
				break;

			// LIST ACCOUNTS
			case 3:

				Bank.printAccounts();
				mainMenu();
				choice = scnr.nextInt();
				scnr.nextLine();
				while (choice < 1 || choice > 9) {
					System.out.println();
					System.out.print("INVALID INPUT. PLEASE SELECT AN OPTION FROM THE LIST.");
					System.out.println();
					mainMenu();
					choice = scnr.nextInt();
					scnr.nextLine();
				}
				break;

			// PRINT STATEMENT
			case 4:
				System.out.print("Enter Account Number: ");
				int accNumber = scnr.nextInt();
				scnr.nextLine();

				try {
					Bank.printStatements(accNumber);
				}

				catch (NoSuchAccountException e) {
					System.out.println(e.getMessage());
				}
				mainMenu();
				choice = scnr.nextInt();
				scnr.nextLine();
				while (choice < 1 || choice > 9) {
					System.out.println();
					System.out.print("INVALID INPUT. PLEASE SELECT AN OPTION FROM THE LIST.");
					System.out.println();
					mainMenu();
					choice = scnr.nextInt();
					scnr.nextLine();
				}
				break;

			// DEPOSITING MONEY
			case 5:

				System.out.print("Enter Account Number: ");
				accNumber = scnr.nextInt();
				scnr.nextLine();
				System.out.print("Enter Deposit Amount: ");
				double depositAmount = scnr.nextDouble();
				scnr.nextLine();
				try {
					Bank.deposityMoney(accNumber, depositAmount);
				}

				catch (AccountClosedException | NoSuchAccountException e) {
					System.out.print(e.getMessage());
				}
				mainMenu();
				choice = scnr.nextInt();
				scnr.nextLine();
				while (choice < 1 || choice > 9) {
					System.out.println();
					System.out.print("INVALID INPUT. PLEASE SELECT AN OPTION FROM THE LIST.");
					System.out.println();
					mainMenu();
					choice = scnr.nextInt();
					scnr.nextLine();
				}
				break;

			// WITHDRAWING MONEY
			case 6:
				System.out.print("Enter Account Number: ");
				accNumber = scnr.nextInt();
				scnr.nextLine();
				System.out.print("Enter Withdrawal Amount: ");
				double withdrawAmount = scnr.nextDouble();
				scnr.nextLine();
				try {
					Bank.withdrawMoney(accNumber, withdrawAmount);
				}

				catch (AccountClosedException | NoSuchAccountException | InsufficientBalanceException e) {
					System.out.print(e.getMessage());
				}
				mainMenu();
				choice = scnr.nextInt();
				scnr.nextLine();
				while (choice < 1 || choice > 9) {
					System.out.println();
					System.out.print("INVALID INPUT. PLEASE SELECT AN OPTION FROM THE LIST.");
					System.out.println();
					mainMenu();
					choice = scnr.nextInt();
					scnr.nextLine();
				}
				break;

			// CLOSING AN ACCOUNT
			case 7:

				System.out.print("Enter Account Number to Close: ");
				accNumber = scnr.nextInt();
				scnr.nextLine();

				try {
					Bank.closeAccount(accNumber);
				}

				catch (NoSuchAccountException e) {
					System.out.println(e.getMessage());
				}
				mainMenu();
				choice = scnr.nextInt();
				scnr.nextLine();
				while (choice < 1 || choice > 9) {
					System.out.println();
					System.out.print("INVALID INPUT. PLEASE SELECT AN OPTION FROM THE LIST.");
					System.out.println();
					mainMenu();
					choice = scnr.nextInt();
					scnr.nextLine();
				}
				break;
				
			// SAVING TRANSACTION
			case 8:

				System.out.print("Enter Account Number to Close: ");
				accNumber = scnr.nextInt();
				scnr.nextLine();

				try {
					Bank.saveStatements(accNumber);
				}

				catch (NoSuchAccountException|IOException e) {
					System.out.println(e.getMessage());
				}
				mainMenu();
				choice = scnr.nextInt();
				scnr.nextLine();
				while (choice < 1 || choice > 9) {
					System.out.println();
					System.out.print("INVALID INPUT. PLEASE SELECT AN OPTION FROM THE LIST.");
					System.out.println();
					mainMenu();
					choice = scnr.nextInt();
					scnr.nextLine();
				}
				break;
			}

			if (choice == 9) {
				System.out.println("THANK YOU FOR USING BANKING APPLICATION. GOODBYE.");
			}
		
		}
		scnr.close();
	}

	public static void mainMenu() {

		System.out.println("1 - Open Checking Acount");
		System.out.println("2 - Open Savings Account");
		System.out.println("3 - List Accounts");
		System.out.println("4 - Account Statement");
		System.out.println("5 - Deposit Funds");
		System.out.println("6 - Withdraw Funds");
		System.out.println("7 - Close An Account");
		System.out.println("8 - Save Transactions");
		System.out.println("9 - Exit");
		System.out.println();
		System.out.print("Please Enter Your Choice: ");
	}


}
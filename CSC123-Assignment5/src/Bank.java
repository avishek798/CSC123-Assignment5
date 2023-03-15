// AUTHOR: AVISHEK BARUA
// EMAIL: abarua3@toromail.csudh.edu
// DATE: 03/14/2023
import java.util.Map;
import java.util.TreeMap;
import java.io.File;
import java.io.IOException;
import java.io.FileOutputStream;

public class Bank {

	static Map<Integer, Account> accounts= new TreeMap<Integer, Account>();

	public static void openCheckingAccount(String fName, String lName, String SSN, double overdraftLimit) {
		Customer customer = new Customer(fName, lName, SSN);
		Account checkAcc = new CheckingAccount(customer, overdraftLimit);
		accounts.put(checkAcc.returnAccNumber(), checkAcc);

		System.out.println("Thank You, The Account Number is: " + checkAcc.returnAccNumber());
	}

	public static void openSavingsAccount(String fName, String lName, String SSN) {
		Customer customer = new Customer(fName, lName, SSN);
		Account savingsAcc = new SavingsAccount(customer);
		accounts.put(savingsAcc.returnAccNumber(), savingsAcc);

		System.out.println("Thank You, The Account Number is: " + savingsAcc.returnAccNumber());
	}

	public static Account findAccount(int accountNumber) throws NoSuchAccountException {

		if (accounts.containsKey(accountNumber)) {
			return accounts.get(accountNumber);
		}
		throw new NoSuchAccountException("ACCOUNT DOES NOT EXIST.\n");

	}

	public static void printAccounts() {

		for (Account a: accounts.values()) {
			System.out.println(a);
		}

	}

	public static void deposityMoney(int accNumber, double amount)
			throws AccountClosedException, NoSuchAccountException {

		if (findAccount(accNumber).deposit(amount) == true)

		{
			System.out.println("DEPOSIT SUCCESSFUL, THE NEW BALANCE IS: " + findAccount(accNumber).getBalance());
		} else {
			System.out.println("DEPOSIT FAILED, THE BALANCE IS: " + findAccount(accNumber).getBalance());
		}

	}

	public static void withdrawMoney(int accNumber, double amount)
			throws AccountClosedException, InsufficientBalanceException, NoSuchAccountException {

		if (findAccount(accNumber).withdraw(amount) == true)

		{
			System.out.println("WITHDRAW SUCCESSFUL, THE NEW BALANCE IS: " + findAccount(accNumber).getBalance());
		} else {
			System.out.println("WITHDRAW FAILED, THE BALANCE IS: " + findAccount(accNumber).getBalance());
		}

	}

	public static void saveStatements(int accNumber) throws NoSuchAccountException, IOException {

		byte[] bytes;

		File f = new File("transactions.txt");
		f.createNewFile();

		FileOutputStream out = new FileOutputStream(f);

		for (Transactions T : findAccount(accNumber).transactions) {

			bytes = T.toString().getBytes();

			for (byte b : bytes) {
				out.write(b);
			}
			out.write("\n".getBytes());

		}
		out.flush();
		out.close();
	}

	public static void printStatements(int accNumber) throws NoSuchAccountException {

		for (Transactions T : findAccount(accNumber).transactions) {
			System.out.println(T);

		}
	}

	public static void closeAccount(int accNumber) throws NoSuchAccountException {

		findAccount(accNumber).closeAccount();
		System.out.printf(
				"ACCOUNT IS CLOSED. THE CURRENT BALANCE IS: " + "%.2f, REGULAR DEPOSITS ARE NO LONGER POSSIBLE.\n",
				findAccount(accNumber).getBalance());
		System.out.println();
	}

}

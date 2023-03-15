// AUTHOR: AVISHEK BARUA
// EMAIL: abarua3@toromail.csudh.edu
// DATE: 03/14/2023
import java.util.ArrayList;

public class Account  {

	ArrayList<Transactions> transactions = new ArrayList<Transactions>();

	private static int counter = 0;
	private int accNumber = 100;;
	private String accountType;
	private Customer accCustomer;
	private boolean accountOpen = true;

	public Account(Customer accCustomer) {
		this.accNumber += counter;
		this.accCustomer = accCustomer;
		counter++;
	}

	public boolean withdraw(double amount) throws AccountClosedException, InsufficientBalanceException {

		Transactions dTransaction = new DebitTransactions(amount);
		transactions.add(dTransaction);

		return true;
	}

	public boolean deposit(double amount) throws AccountClosedException {

		Transactions cTransaction = new CreditTransactions(amount);
		transactions.add(cTransaction);

		return true;
	}

	public double getBalance() {
		double workingBalance = 0.0;
		for (Transactions txn : transactions) {
			if (txn instanceof DebitTransactions) {
				workingBalance -= txn.getAmount();
			} else {
				workingBalance += txn.getAmount();
			}
		}

		return workingBalance;
	}

	public void setAccountTypetoC() {

		this.accountType = "(Checking)";
	}

	public void setAccountTypetoS() {

		this.accountType = "(Savings)";
	}

	public int returnAccNumber() {

		return accNumber;
	}

	public Customer returnAccCustomer() {
		return accCustomer;
	}

	public void closeAccount() {
		accountOpen = false;
	}

	public boolean accountOpen() {
		return this.accountOpen;
	}

	public String toString() {
		if (accountOpen == true) {
			return returnAccNumber() + " : " + accountType + " : " + returnAccCustomer() + " : " + getBalance()
					+ " : Account Open";
		} else
			return returnAccNumber() + " : " + accountType + " : " + returnAccCustomer() + " : " + getBalance()
					+ " : Account Closed";
	}

}

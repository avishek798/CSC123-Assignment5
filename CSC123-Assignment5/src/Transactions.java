// AUTHOR: AVISHEK BARUA
// EMAIL: abarua3@toromail.csudh.edu
// DATE: 03/14/2023
public class Transactions {

	private static int counter = 0;
	private int transactionID = 120;
	private String transactionType;
	private double amount;

	public Transactions(double amount) {
		this.transactionID += counter;
		counter++;
		this.amount = amount;

	}

	public void setTransactionTypetoC() {
		this.transactionType = "Credit";
	}

	public void setTransactionTypetoD() {
		this.transactionType = "Debit";
	}

	public double getAmount() {
		return amount;
	}

	public String toString() {

		return transactionID + " : " + transactionType + " : " + amount;
	}

}

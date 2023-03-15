// AUTHOR: AVISHEK BARUA
// EMAIL: abarua3@toromail.csudh.edu
// DATE: 03/14/2023
public class CheckingAccount extends Account {

	private double overdraftLimit;

	public CheckingAccount(Customer accCustomer, double overdraftLimit) {
		super(accCustomer);
		this.overdraftLimit = overdraftLimit;
		setAccountTypetoC();

	}

	@Override
	public boolean deposit(double amount) throws AccountClosedException {

		if (super.accountOpen() == false && getBalance() + amount > 0) {
			throw new AccountClosedException("ACCOUNT IS CLOSED. DEPOSIT UNSUCCESSFUL.\n");

		} else {
			super.deposit(amount);
			return true;

		}

	}

	@Override
	public boolean withdraw(double amount) throws AccountClosedException, InsufficientBalanceException {

		if ((getBalance() <= 0 && super.accountOpen() == false)) {
			throw new AccountClosedException("ACCOUNT IS CLOSED. WITHDRAW UNSUCCESSFUL.\n");

		} 
		else if (getBalance() - amount < (0 - overdraftLimit)) {
			throw new InsufficientBalanceException("INSUFFICIENT BALANCE. WITHDRAW UNSUCCESSFUL.\n");
			
		}
		else {
			super.withdraw(amount);
			return true;

		}

	}

}

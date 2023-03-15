// AUTHOR: AVISHEK BARUA
// EMAIL: abarua3@toromail.csudh.edu
// DATE: 03/14/2023
public class SavingsAccount extends Account {

	public SavingsAccount(Customer accCustomer) {
		super(accCustomer);
		setAccountTypetoS();

	}

	@Override
	public boolean deposit(double amount) throws AccountClosedException {

		if (super.accountOpen() == false) {
			throw new AccountClosedException("ACCOUNT IS CLOSED. DEPOSIT UNSUCCESSFUL.\n");
		} else {
			super.deposit(amount);
			return true;

		}

	}

	@Override
	public boolean withdraw(double amount) throws AccountClosedException, InsufficientBalanceException {

		if ((getBalance() - amount < 0) && super.accountOpen() == false) {
			throw new AccountClosedException("ACCOUNT IS CLOSED. WITHDRAW UNSUCCESSFUL.\n");

		} else if ((getBalance() - amount < 0)) {
			throw new InsufficientBalanceException("INSUFFICIENT BALANCE. WITHDRAW UNSUCCESSFUL.\n");
		}

		else {
			super.withdraw(amount);
			return true;

		}

	}

}

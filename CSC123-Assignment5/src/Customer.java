// AUTHOR: AVISHEK BARUA
// EMAIL: abarua3@toromail.csudh.edu
// DATE: 03/14/2023
public class Customer {

	private String fName;
	private String lName;
	private String SSN;

	public Customer(String fName, String lName, String SSN) {

		this.fName = fName;
		this.lName = lName;
		this.SSN = SSN;

	}

	public String toString() {
		return fName + " : " + lName + " : " + SSN;
	}

}

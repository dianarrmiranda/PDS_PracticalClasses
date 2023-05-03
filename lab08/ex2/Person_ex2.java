
class Person_ex2 {
	
private String name;
private BankAccount bankAccount;

	public Person_ex2(String n) {
		name = n;
		bankAccount = new BankAccountImpl("PeDeMeia", 0);
	}

	public String getName() {
		return name;
	}
	
	public BankAccount getBankAccount() {
		return new BankAccountProxy(bankAccount);
	}
}
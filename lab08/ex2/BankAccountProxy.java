public class BankAccountProxy implements BankAccount{
    private BankAccount bank;

	BankAccountProxy(BankAccount bank) {
		this.bank = bank;
	}

    private Boolean isUser() {
        return (Company_ex2.user == User.OWNER);
    }
	
	@Override public void deposit(double amount) {
        bank.deposit(amount);
	}

	@Override public boolean withdraw(double amount) {
        if(isUser())
            return bank.withdraw(amount);
        else
            System.out.println("You can't perform this operation");
            return false;
    }

	@Override public double balance() {
		if(isUser())
            return bank.balance();
        else
            System.out.println("You can't perform this operation");
            return Double.NaN;
	}
}

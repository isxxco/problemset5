import java.util.Scanner;

public class BankAccount {
	
	private long accountNumber;
	private Database acctNumFinder = new Database();
	private static long maxNum;
	private double balance;
	private User user;
	
	/**
	 * Constructor for BankAccount class.
	 * 
	 * @param balance
	 * @param user
	 */
	

	
	public BankAccount(long accountNumber, double balance, User user) {
		this.accountNumber = accountNumber;
		this.balance = balance;
		this.user = user;
	}
	
	/////////////////////////////////// GETTERS AND SETTERS ///////////////////////////////////
	


	public long getMax(Database database) {
		maxNum = database.maxNumber() + 1;
		return maxNum;
	}
	
	public BankAccount(Scanner in) {
		this.user = new User(in);
		this.accountNumber = getMax(acctNumFinder);
		this.balance = 0.00;
	}
	
	public long getAccountNumber() {
		return accountNumber; 
	}
	
	
	public double getBalance() {
		return balance;
	}
	

	
	public User getUser() {
		return user;
	}
	

	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}
	

	
	public void setBalance(double balance) {
		this.balance = balance;
	}
	

	public void setUser(User user) {
		this.user = user;
	}
	
	/////////////////////////////////// INSTANCE METHODS ///////////////////////////////////
	

	public void transfer() {
		
	}
	
	public int deposit(double amount) {
		if (amount <= 0) {
			return 0;
		} else {
			balance = balance + amount;
			
			return 1;
		}
	}
	
	
	public int withdraw(double amount) {
		if (amount > balance) {
			return 0;
		} else if (amount <= 0) {
			return 1;
		} else {
			balance = balance - amount;
			return 2;
		}
	}
	
	@Override
	public String toString() {
		String account = String.format("%-9s", Long.toString(getAccountNumber()));
		account += String.format("%-4s", Integer.toString(this.user.getPIN()));
		account += String.format("%-15s", Double.toString(this.getBalance()));
		account += String.format("%-20s", this.user.getlastName());
		account += String.format("%-15s", this.user.getfirstName());
		account += String.format("%-8s", this.user.getDOB());
		account += String.format("%-10s", this.user.getPhone());
		account += String.format("%-30s", this.user.getstreetAddress());
		account += String.format("%-30s", this.user.getCity());
		account += String.format("%-2s", this.user.getState());
		account += String.format("%-5s", this.user.getpostalCode());
		account += String.format("%-1s", Character.toString(this.user.getStatus()));
		return account;
	}
}
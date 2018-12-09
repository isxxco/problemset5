import java.io.*;
import java.util.Arrays;
/**
 * This class will serve as the intermediary between our ATM program and
 * the database of BankAccounts. It'll be responsible for fetching accounts
 * when users try to login, as well as updating those accounts after any
 * changes are made.
 */

public class Database {
	private String[] accounts;
	
	public String[] getAllAccounts() throws IOException {
		String[] accounts = new String[10];
		
		int index = 0;
		try(BufferedReader br = new BufferedReader(new FileReader("accounts-db.txt"))) {
			String line;
			
			while ((line = br.readLine()) != null) {
				if (index >= accounts.length) {
					accounts = Arrays.copyOf(accounts, accounts.length + 10);
				}
				
				accounts[index++] = line;
			}
		}
		
		return Arrays.copyOf(accounts, index);
	}
	
	public BankAccount getAccount(long accountNumber) throws Exception {
		BankAccount account = null;
		
		try(BufferedReader br = new BufferedReader(new FileReader("accounts-db.txt"))) {
			String line;
			while ((line = br.readLine()) != null) {
				long acctNum = Long.parseLong(line.substring(0,9));
				
				if (acctNum == accountNumber && line.charAt(148) == 'Y') {
					int pin = Integer.parseInt(line.substring(9, 13));
					double balance = Double.parseDouble(line.substring(13, 28));
					String lname = line.substring(28, 48).trim();
					String fname = line.substring(48, 63).trim();
					String dob = line.substring(63, 71);
					long phone = Long.parseLong(line.substring(71, 81));
					String address = line.substring(81, 111).trim();
					String city = line.substring(111, 141).trim();
					String state = line.substring(141, 143);
					String postalcode = line.substring(143, 148);
					char status = line.charAt(148);
					
					account = new BankAccount(acctNum, balance, new User(pin, fname, lname, dob, phone, address, city, state, postalcode, status));
					break;
				}
			}
		}
		catch(IOException e) {
			System.out.print(e.getMessage());
		}
				
		return account;
	}
	
	public void updateAccount(BankAccount account, BankAccount destination) throws IOException {
		accounts = getAllAccounts();
		
		try (BufferedWriter bw = new BufferedWriter(new FileWriter("accounts-db.txt"))) {
			
			if (account != null) {
				boolean newAccount = true;
				
				for (int i = 0; i < accounts.length; i++) {
					if (accounts[i].startsWith(String.valueOf(account.getAccountNumber()))) {
						accounts[i] = account.toString();
						newAccount = false;
					}
				}
				
				if (newAccount == true) {
					accounts = Arrays.copyOf(accounts, accounts.length + 1);
					accounts[accounts.length - 1] = account.toString();
				}
			}
			
			if(destination != null) {
				for (int i = 0; i < accounts.length; i++) {
					if (accounts[i].startsWith(String.valueOf(account.getAccountNumber()))) {
						accounts[i] = destination.toString();
					}
				}
			}
			
			for (int i = 0; i < accounts.length; i++) {
				bw.write(accounts[i]);
				bw.newLine();
			}
		}
	
	}
	
	public long maxNumber() {
		try (BufferedReader br = new BufferedReader(new FileReader("accounts-db.txt"))) {
			String line;
			long max = 100000001;
			while ((line = br.readLine()) != null) {
				if (Long.parseLong(line.substring(0, 9)) > max) {
					max = Long.parseLong(line.substring(0, 9));
				}
			}
			return max;
		}
		catch (IOException e) {
			System.out.println("No accounts.");
			return 100000001;
		}
	}
}
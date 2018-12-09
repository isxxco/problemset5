import java.util.InputMismatchException;
import java.util.Scanner;
/**
 * Just like last time, the User class is responsible for retrieving
 * (i.e., getting), and updating (i.e., setting) user information.
 * This time, though, you'll need to add the ability to update user
 * information and display that information in a formatted manner.
 * 
 * Most of the functionality for this class should have already been
 * implemented last time. You can always reference my Github repository
 * for inspiration (https://github.com/rwilson-ucvts/java-sample-atm).
 */

public class User {
	
	private int pin;
	private String firstName;
	private String lastName;
	private String dob;
	private long phone;
	private String streetAddress;
	private String city;
	private String state;
	private String postalCode;
	private char status = 'Y';
	
	/**
	 * Constructor for User class.
	 * 
	 * @param name
	 * @param dob
	 * @param address
	 */
	
	public User(int pin, String firstName, String lastName, String dob, long phone, String streetAddress, String city, String state, String postalCode, char status) {
		this.pin = pin;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
		this.phone = phone;
		this.streetAddress = streetAddress;
		this.city = city;
		this.state = state;
		this.postalCode = postalCode;
		this.status = status;
	}
	
	/////////////////////////////////// GETTERS AND SETTERS ///////////////////////////////////
	
	/**
	 * Retrieves the user's PIN.
	 * 
	 * @return pin
	 */
	User (Scanner in) {
		System.out.print("First Name: ");
		in.nextLine();
		firstName = in.nextLine();
		System.out.print("Last Name: ");
		lastName = in.nextLine();
		while (String.valueOf(dob).length() != 8) {
			System.out.print("Date of Birth (YYYYMMDD): ");
				dob = in.nextLine();
				if (dob.length() != 8) {
					System.out.println("Please Type DOB Again.");
				}
		}
		while (String.valueOf(phone).length() != 10 || String.valueOf(phone).charAt(0) == '0') {
			System.out.print("Phone (10 digits): ");
			phone = in.nextLong();
			if (String.valueOf(phone).length() != 10 || String.valueOf(phone).charAt(0) == '0') {
				System.out.println("Please Type PHONE Again.");
			}
		}
		System.out.print("Street Address: ");
		in.nextLine();
		streetAddress = in.nextLine();
		System.out.print("City: ");
		city = in.nextLine();
		while (String.valueOf(state).length() != 2) {
			System.out.print("State: ");
			state = in.nextLine();
			if (state.length() != 2) {
				System.out.println("Please Type STATE Again.");
			}
		}
		while (String.valueOf(postalCode).length() != 5) {
			System.out.print("Postal Code: ");
			postalCode = in.nextLine();
			if (postalCode.length() != 5) {
				System.out.println("Please Type POSTAL CODE Again.");
			}
		}
		
		while (String.valueOf(pin).length() != 4) {
			try {
				System.out.print("PIN (4 digits): ");
				pin = in.nextInt();
				if (String.valueOf(pin).length() != 4) {
					System.out.println("Invalid PIN");
				}
			} catch (InputMismatchException e) {
				System.out.println("Invalid PIN");
			}
			finally {
				in.nextLine();
			}
		}
		status = 'Y';
	}
	
	public int getPIN() {
		return pin;
	}
	
	
	public String getfirstName() {
		return firstName;
	}
	
	public String getlastName() {
		return lastName;
	}
	
	public String getDOB() {
		return dob;
	}
	
	public long getPhone() {
		return phone;
	}

	
	public String getstreetAddress() {
		return streetAddress;
	}
	
	public String getCity() {
		return city;
	}
	
	public String getState() {
		return state;
	}
	
	public String getpostalCode() {
		return postalCode;
	}
	
	public char getStatus() {
		return status;
	}
	
	public void setPIN(int pin) {
		this.pin = pin;
	}
	
	public void setfirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public void setlastName(String lastName) {
		this.lastName = lastName;
	}
	
	public void setDOB(String dob) {
		this.dob = dob;
	}
	
	public void setPhone(long phone) {
		this.phone = phone;
	}
	
	public void setstreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	public void setState(String state) {
		this.state = state;
	}
	
	public void setpostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	
	public void close() {
		this.status = 'N';
	}
}
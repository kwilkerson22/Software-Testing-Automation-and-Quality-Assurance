/**********
 *Name: Kenneth Wilkerson
 *Class: CS 320
 *Date: September 29, 2024
 *Description: Contact class objects have a contact ID, first name, last name, phone and address
 **********/

package contact;
import java.util.Random;


public class Contact {
	
	private final String contactID; // not updatable
	private String firstName; // updatable
	private String lastName; // updatable
	private String phone; // updatable
	private String address; // updatable
	
	
	//constructor with randomly generated contactID by default
	public Contact (String firstName, String lastName, String phone, String address) {
		
		//random ID number assigned
		this.contactID = generateRandNum();
		
		//validate all variables
		if (contactID == null || contactID.length() > 10) {
			throw new IllegalArgumentException("Invalid ID");
		}
		
		if (firstName == null || firstName.length() > 10) {
			throw new IllegalArgumentException("Invalid First Name");
		}
		
		if (lastName == null || lastName.length() > 10) {
			throw new IllegalArgumentException("Invalid Last Name");
		}
		
		if (phone == null || phone.length() != 10) {
			throw new IllegalArgumentException("Invalid Phone");
		}
		
		if (address == null || address.length() > 30) {
			throw new IllegalArgumentException("Invalid Address");
		}
		
		//assign variables once validated
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.address = address;
}

	//method to generate a random 10 character ID string
	public String generateRandNum() {
		Random random = new Random();
		long randNumber = Math.abs(random.nextLong() % 1000000000);
		String uniqueID = String.format("%10d", randNumber);
		
		return uniqueID;
	}
	
	//getter for contactId
	public String getContactID () {
		return contactID;
	}
	
	//getter for firstName
	public String getFirstName ( ) {
		return firstName;
	}
	
	//getter for lastName
	public String getLastName() {
		return lastName;
	}
	
	//getter for phone
	public String getPhone () {
		return phone;
	}
	
	//getter for address
	public String getAddress () {
		return address;
	}
	
	//setter for firstName with validation
	public void setFirstName (String firstName) {
		if (firstName != null && firstName.length() <=10) {
			this.firstName = firstName;
		}
		
		else {
			throw new IllegalArgumentException("Invalid First Name");
		}
	}
	
	//setter for lastName with validation
	public void setLastName (String lastName) {
		if (lastName != null && lastName.length() <= 10) {
			this.lastName = lastName;
		}
		
		else {
			throw new IllegalArgumentException("Invalid Last Name");
		}
	}
	
	//setter for phone with validation
	public void setPhone (String phone) {
		if (phone != null && phone.length() == 10) {
			this.phone = phone;
		}
		
		else {
			throw new IllegalArgumentException("Invalid Phone");
		}
	}
	
	//setter for address with validation
	public void setAddress (String address) {
		if (address != null && address.length() <= 30) {
			this.address = address;
		}
		
		else {
			throw new IllegalArgumentException("Invalid Address");
		}
	}
}

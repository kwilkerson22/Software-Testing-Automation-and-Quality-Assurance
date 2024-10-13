/**********
 *Name: Kenneth Wilkerson
 *Class: CS 320
 *Date: September 29, 2024
 *Description: ContactService creates a hash map of contacts which can be added, deleted or updated
 *based on their unique contactID. For updates, only first name, last name, phone and address can 
 *be updated.
 **********/

package contact;
import java.util.HashMap;
import java.util.Map;

public class ContactService {
	
	//tracking contactIDs that are in use to ensure uniqueness
	public Map<String, Contact> contactLog = new HashMap<>();
	
	//method to add new contact when contactID is not in use
	public void addContact(Contact contact) {
		if (contactLog.containsKey(contact.getContactID())){
			throw new IllegalArgumentException("Contact ID Already Used");	
		}
		
		else {
			contactLog.put(contact.getContactID(), contact);
		}
	}
		
	//method to delete contact when contactID is located
	public void deleteContact (String contactID) {
		if (contactLog.containsKey(contactID)) {
			contactLog.remove(contactID);
		}
		
		else {
			throw new IllegalArgumentException("Contact ID Does Not Exist");
		}
	}
	
	// method to update firstName when contactID is located
	public void updateFirstName(String contactID, String firstName) {
		Contact contact = contactLog.get(contactID);
		
		if (contact == null) {
			throw new IllegalArgumentException("No Contact Found");
		}
		
		contact.setFirstName(firstName);
	}
	
	// method to update lastName when contactID is located
	public void updateLastName(String contactID, String lastName) {
		Contact contact = contactLog.get(contactID);
		
		if (contact == null) {
			throw new IllegalArgumentException("No Contact Found");
		}
		
		contact.setLastName(lastName);
	}
	
	// method to update phone when contactID is located
	public void updatePhone(String contactID, String phone) {
		Contact contact = contactLog.get(contactID);
		
		if (contact == null) {
			throw new IllegalArgumentException("No Contact Found");
		}

		contact.setPhone(phone);
		}
	
	
	// method to update address when contactID is located
	public void updateAddress(String contactID, String address) {
		Contact contact = contactLog.get(contactID);
		
		if (contact == null) {
			throw new IllegalArgumentException("No Contact Found");
		}
		
		contact.setAddress(address);
	}							
}

/**********
 *Name: Kenneth Wilkerson
 *Class: CS 320
 *Date: September 29, 2024
 *Description: Unit tests for ContactService
 **********/


package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import contact.Contact;
import contact.ContactService;

class ContactServiceTest {
	
	private ContactService contactService;
	
	@BeforeEach
	public void initializeContactService() {
		contactService = new ContactService();
	}

	
	@Test
	public void testAddContact() {
		Contact contact = new Contact("Kenny","Wilkerson","1234567890","369 Mango St");
		contactService.addContact(contact);
		assertNotNull(contactService);
		assertEquals(1, contactService.contactLog.size());	
	}
	
	@Test
	public void testAddDuplicateContact() {
		Contact contact = new Contact("Kenny","Wilkerson","1234567890","369 Mango St");
		contactService.addContact(contact);
		assertThrows(IllegalArgumentException.class, ()-> {
			contactService.addContact(contact);
		});
	}
		
	@Test
	public void testDeleteContact() {
		Contact contact = new Contact("Kenny","Wilkerson","1234567890","369 Mango St");
		contactService.addContact(contact);
		assertNotNull(contactService.contactLog);
		contactService.deleteContact(contact.getContactID());
		assertEquals(0, contactService.contactLog.size());	
	}
	
	@Test
	public void testDeleteNullContact() {
		Contact contact = new Contact("Kenny","Wilkerson","1234567890","369 Mango St");
		contactService.addContact(contact);
		assertNotNull(contactService.contactLog);
		assertThrows(IllegalArgumentException.class, ()-> {
			contactService.deleteContact(null);
		});
	}
	
	@Test
	public void testUpdateFirstName() {
		Contact contact = new Contact("Kenny","Wilkerson","1234567890","369 Mango St");
		contactService.addContact(contact);
		assertNotNull(contactService);
		contactService.updateFirstName(contact.getContactID(), "Kenneth");
		assertEquals("Kenneth", contact.getFirstName());
	}
	
	@Test
	public void testUpdateFirstNameNullObject() {
		Contact contact = new Contact("Kenny","Wilkerson","1234567890","369 Mango St");
		contactService.addContact(contact);
		assertNotNull(contactService);
		assertThrows(IllegalArgumentException.class,()-> {
			contactService.updateFirstName(null , "Kenneth");
			});
	}
	
	@Test
	public void testUpdateLastName() {
		Contact contact = new Contact("Kenny","Wilkerson","1234567890","369 Mango St");
		contactService.addContact(contact);
		assertNotNull(contactService);
		contactService.updateLastName(contact.getContactID(), "W");
		assertEquals("W", contact.getLastName());
	}
	
	@Test
	public void testUpdateLastNameNullObject() {
		Contact contact = new Contact("Kenny","Wilkerson","1234567890","369 Mango St");
		contactService.addContact(contact);
		assertNotNull(contactService);
		assertThrows(IllegalArgumentException.class,()-> {
			contactService.updateLastName(null , "W");
			});
	}
	
	@Test
	public void testUpdatePhone() {
		Contact contact = new Contact("Kenny","Wilkerson","1234567890","369 Mango St");
		contactService.addContact(contact);
		assertNotNull(contactService);
		contactService.updatePhone(contact.getContactID(), "0000000000");
		assertEquals("0000000000", contact.getPhone());
	}
	
	@Test
	public void testUpdatePhoneNullObject() {
		Contact contact = new Contact("Kenny","Wilkerson","1234567890","369 Mango St");
		contactService.addContact(contact);
		assertNotNull(contactService);
		assertThrows(IllegalArgumentException.class,()-> {
			contactService.updatePhone(null , "0000000000");
			});
	}
	
	@Test
	public void testUpdateAddress() {
		Contact contact = new Contact("Kenny","Wilkerson","1234567890","369 Mango St");
		contactService.addContact(contact);
		assertNotNull(contactService);
		contactService.updateAddress(contact.getContactID(), "2 Cookie Road");
		assertEquals("2 Cookie Road", contact.getAddress());
	}
	
	@Test
	public void testUpdateAddressNullObject() {
		Contact contact = new Contact("Kenny","Wilkerson","1234567890","369 Mango St");
		contactService.addContact(contact);
		assertNotNull(contactService);
		assertThrows(IllegalArgumentException.class,()-> {
			contactService.updateAddress(null , "2 Cookie Road");
			});
	}
}

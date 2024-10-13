/**********
 *Name: Kenneth Wilkerson
 *Class: CS 320
 *Date: September 29, 2024
 *Description: Unit tests for Contact
 **********/


package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import contact.Contact;



class ContactTest {
	
	@Test
	public void testProperContact() {
		Contact contact = new Contact("Kenny","Wilkerson","1234567890","369 Mango St");
		assertNotNull(contact);
		assertEquals("Kenny", contact.getFirstName());
		assertEquals("Wilkerson", contact.getLastName());
		assertEquals("1234567890", contact.getPhone());
		assertEquals("369 Mango St", contact.getAddress());			
	}
	
	@Test
	public void testNullFirstNameContact( ) {
		assertThrows(IllegalArgumentException.class,()-> {
			new Contact(null ,"Wilkerson","1234567890","369 Mango St");
			});
	}
	
	@Test
	public void testTooLongFirstNameContact( ) {
		assertThrows(IllegalArgumentException.class,()-> {
			new Contact("AAAAAAAAAAA" ,"Wilkerson","1234567890","369 Mango St");
			});
	}
	
	@Test
	public void testNullLastNameContact( ) {
		assertThrows(IllegalArgumentException.class,()-> {
			new Contact("Kenny" ,null ,"1234567890","369 Mango St");
			});
	}
	
	@Test
	public void testTooLongLastNameContact( ) {
		assertThrows(IllegalArgumentException.class,()-> {
			new Contact("Kenny" ,"AAAAAAAAAAA" ,"1234567890","369 Mango St");
			});
	}
	
	@Test
	public void testNullPhoneContact( ) {
		assertThrows(IllegalArgumentException.class,()-> {
			new Contact("Kenny" ,"Wilkerson" ,null ,"369 Mango St");
			});
	}
	
	@Test
	public void testTooShortPhoneContact( ) {
		assertThrows(IllegalArgumentException.class,()-> {
			new Contact("Kenny" ,"Wilkerson" ,"1" ,"369 Mango St");
			});
	}
	
	@Test
	public void testTooLongPhoneContact( ) {
		assertThrows(IllegalArgumentException.class,()-> {
			new Contact("Kenny" ,"Wilkerson" ,"11111111111" ,"369 Mango St");
			});
	}
	
	@Test
	public void testNullAddressContact( ) {
		assertThrows(IllegalArgumentException.class,()-> {
			new Contact("Kenny" ,"Wilkerson" ,"1234567890" ,null);
			});
	}
	
	@Test
	public void testTooLongAddressContact( ) {
		assertThrows(IllegalArgumentException.class,()-> {
			new Contact("Kenny" ,"Wilkerson" ,"1234567890" ,"AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
			});
	}
	
	@Test
	public void testSetFirstName() {
		Contact contact = new Contact("Kenny","Wilkerson","1234567890","369 Mango St");
		assertNotNull(contact);
		contact.setFirstName("Kenneth");
		assertEquals("Kenneth", contact.getFirstName());
	}
	
	@Test
	public void testSetTooLongFirstName() {
		Contact contact = new Contact("Kenny","Wilkerson","1234567890","369 Mango St");
		assertNotNull(contact);
		assertThrows(IllegalArgumentException.class,()-> {
			contact.setFirstName("Over 10 Characters");
			});
	}
	
	@Test
	public void testSetNullFirstName() {
		Contact contact = new Contact("Kenny","Wilkerson","1234567890","369 Mango St");
		assertNotNull(contact);
		assertThrows(IllegalArgumentException.class,()-> {
			contact.setFirstName(null);
			});
	}
	
	@Test
	public void testSetLastName() {
		Contact contact = new Contact("Kenny","Wilkerson","1234567890","369 Mango St");
		assertNotNull(contact);
		contact.setLastName("W");
		assertEquals("W", contact.getLastName());
	}
	
	@Test
	public void testSetTooLongLastName() {
		Contact contact = new Contact("Kenny","Wilkerson","1234567890","369 Mango St");
		assertNotNull(contact);
		assertThrows(IllegalArgumentException.class,()-> {
			contact.setLastName("Also Over 10 Characters");
			});
	}
	
	@Test
	public void testSetNullLastName() {
		Contact contact = new Contact("Kenny","Wilkerson","1234567890","369 Mango St");
		assertNotNull(contact);
		assertThrows(IllegalArgumentException.class,()-> {
			contact.setLastName(null);
			});
	}
	
	@Test
	public void testSetPhone() {
		Contact contact = new Contact("Kenny","Wilkerson","1234567890","369 Mango St");
		assertNotNull(contact);
		contact.setPhone("0000000000");
		assertEquals("0000000000", contact.getPhone());
	}
	
	@Test
	public void testSetTooShortPhone() {
		Contact contact = new Contact("Kenny","Wilkerson","1234567890","369 Mango St");
		assertNotNull(contact);
		assertThrows(IllegalArgumentException.class,()-> {
			contact.setPhone("9");
			});
	}
	
	@Test
	public void testSetTooLongPhone() {
		Contact contact = new Contact("Kenny","Wilkerson","1234567890","369 Mango St");
		assertNotNull(contact);
		assertThrows(IllegalArgumentException.class,()-> {
			contact.setPhone("99999999999");
			});
	}
	
	@Test
	public void testSetNullPhone() {
		Contact contact = new Contact("Kenny","Wilkerson","1234567890","369 Mango St");
		assertNotNull(contact);
		assertThrows(IllegalArgumentException.class,()-> {
			contact.setPhone(null);
			});
	}
	
	@Test
	public void testSetAddress() {
		Contact contact = new Contact("Kenny","Wilkerson","1234567890","369 Mango St");
		assertNotNull(contact);
		contact.setAddress("123 Gold Coast Road");
		assertEquals("123 Gold Coast Road", contact.getAddress());
	}
	
	@Test
	public void testSetTooLongAddress() {
		Contact contact = new Contact("Kenny","Wilkerson","1234567890","369 Mango St");
		assertNotNull(contact);
		assertThrows(IllegalArgumentException.class,()-> {
			contact.setAddress("This Address Is Over 30 Characters");
			});
	}
	
	@Test
	public void testSetNullAddress() {
		Contact contact = new Contact("Kenny","Wilkerson","1234567890","369 Mango St");
		assertNotNull(contact);
		assertThrows(IllegalArgumentException.class,()-> {
			contact.setAddress(null);
			});
	}
}

/**********
 *Name: Kenneth Wilkerson
 *Class: CS 320
 *Date: October 13, 2024
 *Description: Unit tests for Appointment
 **********/

package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import java.util.Date;
import java.util.Calendar;
import appointment.Appointment;


class AppointmentTest {

	
	@Test
	public void testCorrectAppointment() {
		Calendar calendar = Calendar.getInstance(); 
		calendar.set(2024, 11,15); 
		Date dateInFuture = calendar.getTime(); 
		
		Appointment appointment = new Appointment(dateInFuture, "Doctor's Appointment");
		assertNotNull(appointment);
		assertEquals(dateInFuture, appointment.getAppointmentDate());
		assertEquals("Doctor's Appointment", appointment.getAppointmentDescription());
		}
	
	@Test
	public void testPastDateAppointment() {
		Calendar calendar = Calendar.getInstance(); 
		calendar.set(2000, 1 ,1); 
		Date dateInPast = calendar.getTime(); 
		
		assertThrows(IllegalArgumentException.class,()-> {
			new Appointment(dateInPast, "Doctor's Appointment");
		});	
		}
	
	@Test
	public void testNullDateAppointment() {
		Date nullDate = null;
		
		assertThrows(IllegalArgumentException.class,()-> {
			new Appointment(nullDate, "Doctor's Appointment");
		});	
		}
	
	@Test
	public void testTooLongDescriptionAppointment() {
		Calendar calendar = Calendar.getInstance(); 
		calendar.set(2025, 7 , 7); 
		Date dateInFuture = calendar.getTime(); 
		
		assertThrows(IllegalArgumentException.class,()-> {
			new Appointment(dateInFuture, "Exceeding The 50 Character Limit For The Description Field");
		});	
		}
	
	@Test
	public void testNullDescriptionAppointment() {
		Calendar calendar = Calendar.getInstance(); 
		calendar.set(2025, 7 , 7);
		Date dateInFuture = calendar.getTime(); 
		
		assertThrows(IllegalArgumentException.class,()-> {
			new Appointment(dateInFuture, null);
		});	
		}

}

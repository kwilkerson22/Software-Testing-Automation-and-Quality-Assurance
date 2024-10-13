/**********
 *Name: Kenneth Wilkerson
 *Class: CS 320
 *Date: October 13, 2024
 *Description: Unit tests for AppointmentService
 **********/

package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Date;
import java.util.Calendar;
import appointment.Appointment;
import appointment.AppointmentService;




class AppointmentServiceTest {
	
	private AppointmentService appointmentService;
	
	@BeforeEach
	public void initializeAppointmentService() {
		appointmentService = new AppointmentService();
	}

	@Test
	public void testAddAppointment() {
		Calendar calendar = Calendar.getInstance(); 
		calendar.set(2025, 1,1); 
		Date dateInFuture = calendar.getTime(); 
				
				
		Appointment appointment = new Appointment(dateInFuture, "Contact Lens Appointment");
		appointmentService.addAppointment(appointment);
		assertNotNull(appointmentService);
		assertEquals(1, appointmentService.appointmentLog.size());	
	}
	
	@Test
	public void testAddAppointmentIDInUse() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(2025,  2, 2);
		Date dateInFuture = calendar.getTime();
		
		Appointment appointment = new Appointment(dateInFuture, "Dentist Appointment");
		appointmentService.addAppointment(appointment);
		assertThrows(IllegalArgumentException.class, ()-> {
			appointmentService.addAppointment(appointment);
		});
	}
	
	@Test
	public void testDeleteAppointment() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(2025,  3, 3);
		Date dateInFuture = calendar.getTime();
		
		Appointment appointment = new Appointment(dateInFuture, "Dentist Appointment");
		appointmentService.addAppointment(appointment);
		assertNotNull(appointmentService);
		appointmentService.deleteAppointment(appointment.getAppointmentID());
		assertEquals(0, appointmentService.appointmentLog.size());	
	}
	
	@Test
	public void testDeleteAppointmentNoIDExist() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(2025,  4, 4);
		Date dateInFuture = calendar.getTime();
		
		Appointment appointment = new Appointment(dateInFuture, "Dentist Appointment");
		appointmentService.addAppointment(appointment);
		assertNotNull(appointmentService);
		assertThrows(IllegalArgumentException.class, ()-> {
			appointmentService.deleteAppointment("-1000000000");
		});
	}
}

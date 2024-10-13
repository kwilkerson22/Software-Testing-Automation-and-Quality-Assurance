/**********
 *Name: Kenneth Wilkerson
 *Class: CS 320
 *Date: October 13, 2024
 *Description: AppointmentService creates a hash map of appointments which can be added or deleted
 *based on their unique taskID. 
 **********/

package appointment;

import java.util.HashMap;
import java.util.Map;

public class AppointmentService {
	
	// implement HashMap to track objects by taskID
	public final Map<String, Appointment> appointmentLog = new HashMap<>();
	
	// method adds new appointment when appointmentID is not already used
	public void addAppointment(Appointment appointment) {
		if (appointmentLog.containsKey(appointment.getAppointmentID())) {
			throw new IllegalArgumentException("Appointment Already Exists For ID");
		}
		
		appointmentLog.put(appointment.getAppointmentID(), appointment);
	}
	
	// method deletes appointment from HashMap when appointmentID is located
	public void deleteAppointment (String appointmentID) {
		if (appointmentLog.containsKey(appointmentID)) {
			appointmentLog.remove(appointmentID);
		}
		
		else {
			throw new IllegalArgumentException ("No Appointment Exists For ID");
		}
	}

}

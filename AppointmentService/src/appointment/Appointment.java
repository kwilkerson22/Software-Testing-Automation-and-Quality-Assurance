/**********
 *Name: Kenneth Wilkerson
 *Class: CS 320
 *Date: October 13, 2024
 *Description: Appointment class objects have an appointment ID, date and description.
 **********/

package appointment;

import java.util.Random;
import java.util.Date;


public class Appointment {
	
	private final String appointmentID;
	private Date appointmentDate;
	private String appointmentDescription;
	
	// class constructor with name and description as parameters -- taskID generated within
	public Appointment (Date appointmentDate, String appointmentDescription) {
		
		// random ID number assigned
		this.appointmentID = generateRandNum();
		
		// validate all variables
		if (appointmentID == null || appointmentID.length() > 10) {
			throw new IllegalArgumentException("Invalid Appointment ID");
		}
		
		if (appointmentDate == null || appointmentDate.before(new Date())){
			throw new IllegalArgumentException("Invalid Date");
		}
		
		if (appointmentDescription == null || appointmentDescription.length() > 50) {
			throw new IllegalArgumentException("Invalid Description");
		}
		
		// assign variables once validated
		this.appointmentDate = appointmentDate;
		this.appointmentDescription = appointmentDescription;
	}
	
		//method to generate a random 10 character ID string
		public String generateRandNum() {
			Random random = new Random();
			int randNumber = Math.abs(random.nextInt(1000000000));
			String uniqueID = String.format("%10d", randNumber);
				
			return uniqueID;
		}
		
		// getter for appointmentID
		public String getAppointmentID () {
			return appointmentID;
		}
		
		// getter for appointmentDate
		public Date getAppointmentDate () {
			return appointmentDate;
		}
		
		// getter for appointmentDescription
		public String getAppointmentDescription ( ) {
			return appointmentDescription;
		}	
}

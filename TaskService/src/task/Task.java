/**********
 *Name: Kenneth Wilkerson
 *Class: CS 320
 *Date: October 6, 2024
 *Description: Task class objects have a task ID, name and description
 **********/

package task;
import java.util.Random;

public class Task {
	
	private final String taskID; // not updatable
	private String name; // updatable
	private String description; // updatable
	
	// class constructor with name and description as parameters -- taskID generated within
	public Task (String name, String description) {
		
		// random ID number assigned
		this.taskID = generateRandNum();
		
		// validate all variables
		if (taskID == null || taskID.length() > 10) {
			throw new IllegalArgumentException("Invalid ID");
		}
		
		if (name == null || name.length() > 20) {
			throw new IllegalArgumentException("Invalid Name");
		}
		
		if (description == null || description.length() > 50) {
			throw new IllegalArgumentException("Invalid Description");
		}
		
		// assign variables once validated
		this.name = name;
		this.description = description;
	}
	
	//method to generate a random 10 character ID string
	public String generateRandNum() {
		Random random = new Random();
		int randNumber = Math.abs(random.nextInt(1000000000));
		String uniqueID = String.format("%10d", randNumber);
			
		return uniqueID;
	} 
	
	// getter for taskID
	public String getTaskID() {
		return taskID;
	}
	
	// getter for name
	public String getName() {
		return name;
	}
	
	// getter for description
	public String getDescription() {
		return description;
	}
	
	// setter for name with validation
	public void setName(String name) {
		if (name != null && name.length() <= 20) {
			this.name = name;
		}
		
		else {
			throw new IllegalArgumentException("Invalid Name");	
		}
	}
	
	// setter for description with validation
	public void setDescription (String description) {
		if (description != null && description.length() <= 50) {
			this.description = description;
		}
		
		else {
			throw new IllegalArgumentException("Invalid Description");
		}
	}
}

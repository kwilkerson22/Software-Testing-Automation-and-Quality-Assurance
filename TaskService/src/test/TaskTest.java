/**********
 *Name: Kenneth Wilkerson
 *Class: CS 320
 *Date: October 6, 2024
 *Description: Unit tests for Task
 **********/

package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import task.Task;

class TaskTest {

	@Test
	public void testProperTask() {
		Task task = new Task("Complete Homework", "Module 4 Milestone and Journal due on Sunday");
		assertNotNull(task);
		assertEquals("Complete Homework", task.getName());
		assertEquals("Module 4 Milestone and Journal due on Sunday", task.getDescription());
		}
	
	@Test
	public void testTaskWithNullName() {
		assertThrows(IllegalArgumentException.class,()-> {
			new Task(null,"Module 4 Milestone and Journal due on Sunday");
		});		
		}
	
	@Test
	public void testTaskWithNullDescription() {
		assertThrows(IllegalArgumentException.class,()-> {
			new Task("Complete Homework", null);
		});		
		}
	
	@Test
	public void testTaskWithTwoNulls() {
		assertThrows(IllegalArgumentException.class,()-> {
			new Task(null, null);
		});		
		}
	
	@Test
	public void testTaskWithTooLongName() {
		assertThrows(IllegalArgumentException.class,()-> {
			new Task("21 characters!!!!!!!!", "Module 4 Milestone and Journal due on Sunday");
		});		
		}
	
	@Test
	public void testTaskWithTooLongDescription() {
		assertThrows(IllegalArgumentException.class,()-> {
			new Task("Complete Homework", "51 characters!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		});		
		}
	
	@Test
	public void testTaskWithBothTooLong() {
		assertThrows(IllegalArgumentException.class,()-> {
			new Task("21 characters!!!!!!!!", "51 characters!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		});		
		}
	
	@Test
	public void testSetValidName() {
		Task task = new Task("Complete Homework", "Module 4 Milestone and Journal due on Sunday");
		assertNotNull(task);
		task.setName("New Task Name");
		assertEquals("New Task Name", task.getName());
		}
	
	@Test
	public void testSetTooLongName() {
		Task task = new Task("Complete Homework", "Module 4 Milestone and Journal due on Sunday");
		assertThrows(IllegalArgumentException.class,()-> {
			task.setName("21 characters!!!!!!!!");
		});		
		}
	
	@Test
	public void testSetNullName() {
		Task task = new Task("Complete Homework", "Module 4 Milestone and Journal due on Sunday");
		assertThrows(IllegalArgumentException.class,()-> {
			task.setName(null);
		});		
		}
	
	@Test
	public void testSetValidDescription() {
		Task task = new Task("Complete Homework", "Module 4 Milestone and Journal due on Sunday");
		assertNotNull(task);
		task.setDescription("New Task Description");
		assertEquals("New Task Description", task.getDescription());
		}
	
	@Test
	public void testSetTooLongDescription() {
		Task task = new Task("Complete Homework", "Module 4 Milestone and Journal due on Sunday");
		assertThrows(IllegalArgumentException.class,()-> {
			task.setDescription("51 characters!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		});		
		}
	
	@Test
	public void testSetNullDescription() {
		Task task = new Task("Complete Homework", "Module 4 Milestone and Journal due on Sunday");
		assertThrows(IllegalArgumentException.class,()-> {
			task.setDescription(null);
		});		
		}	
}

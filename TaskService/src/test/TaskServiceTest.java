/**********
 *Name: Kenneth Wilkerson
 *Class: CS 320
 *Date: October 6, 2024
 *Description: Unit tests for TaskService
 **********/

package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import task.Task;
import task.TaskService;

class TaskServiceTest {
	
	private TaskService taskService;
	
	@BeforeEach
	public void initializeContactService() {
		taskService = new TaskService();
	}

	@Test
	public void testAddTask() {
		Task task = new Task("Valid Name", "Valid Description");
		taskService.addTask(task);
		assertNotNull(taskService);
		assertEquals(1, taskService.taskLog.size());	
	}
	
	@Test
	public void testAddDuplicateTask() {
		Task task = new Task("Valid Name", "Valid Description");
		taskService.addTask(task);
		assertThrows(IllegalArgumentException.class, ()-> {
			taskService.addTask(task);
		});
	}
	
	@Test
	public void testDeleteTask() {
		Task task = new Task("Valid Name", "Valid Description");
		taskService.addTask(task);
		assertNotNull(taskService.taskLog);
		taskService.deleteTask(task.getTaskID());
		assertEquals(0, taskService.taskLog.size());	
	}
	
	@Test
	public void testIncorrectDeleteTask() {
		Task task = new Task("Valid Name", "Valid Description");
		taskService.addTask(task);
		assertNotNull(taskService.taskLog);
		assertThrows(IllegalArgumentException.class, ()-> {
			taskService.deleteTask("-1000000000");
		});
	}
	
	@Test
	public void testUpdateTaskName() {
		Task task = new Task("Valid Name", "Valid Description");
		taskService.addTask(task);
		assertNotNull(taskService.taskLog);
		taskService.updateTaskName(task.getTaskID(), "Kenneth's HW");
		assertEquals("Kenneth's HW", task.getName());	
		}
	
	@Test
	public void testUpdateNullTaskName() {
		Task task = new Task("Valid Name", "Valid Description");
		taskService.addTask(task);
		assertNotNull(taskService.taskLog);
		assertThrows(IllegalArgumentException.class, ()-> {
			taskService.updateTaskName(task.getTaskID(), null);
		});	
		}
	
	@Test
	public void testUpdateNameNullObject() {
		Task task = new Task("Valid Name", "Valid Description");
		taskService.addTask(task);
		assertNotNull(taskService.taskLog);
		assertThrows(IllegalArgumentException.class, ()-> {
			taskService.updateTaskName(null, "Kenneth's HW");
		});	
		}
	
	@Test
	public void testUpdateTooLongTaskName() {
		Task task = new Task("Valid Name", "Valid Description");
		taskService.addTask(task);
		assertNotNull(taskService.taskLog);
		assertThrows(IllegalArgumentException.class, ()-> {
			taskService.updateTaskName(task.getTaskID(), "21 characters!!!!!!!!");
		});	
		}
	
	@Test
	public void testUpdateDescription() {
		Task task = new Task("Valid Name", "Valid Description");
		taskService.addTask(task);
		assertNotNull(taskService.taskLog);
		taskService.updateTaskDescription(task.getTaskID(), "Module 4 Coding Assignment");
		assertEquals("Module 4 Coding Assignment", task.getDescription());	
		}
	
	@Test
	public void testUpdateNullDescription() {
		Task task = new Task("Valid Name", "Valid Description");
		taskService.addTask(task);
		assertNotNull(taskService.taskLog);
		assertThrows(IllegalArgumentException.class, ()-> {
			taskService.updateTaskDescription(task.getTaskID(), null);
		});	
		}
	
	@Test
	public void testUpdateDescriptionNullObject() {
		Task task = new Task("Valid Name", "Valid Description");
		taskService.addTask(task);
		assertNotNull(taskService.taskLog);
		assertThrows(IllegalArgumentException.class, ()-> {
			taskService.updateTaskDescription(null, "Module 4 Coding Assignment");
		});	
		}
	
	@Test
	public void testUpdateTooLongTaskDescription() {
		Task task = new Task("Valid Name", "Valid Description");
		taskService.addTask(task);
		assertNotNull(taskService.taskLog);
		assertThrows(IllegalArgumentException.class, ()-> {
			taskService.updateTaskDescription(task.getTaskID(), "51 characters!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		});	
		}
}

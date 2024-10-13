/**********
 *Name: Kenneth Wilkerson
 *Class: CS 320
 *Date: October 6, 2024
 *Description: TaskService creates a hash map of tasks which can be added, deleted or updated
 *based on their unique taskID. For updates, only name and description can 
 *be updated based on their taskID.
 **********/


package task;

import java.util.HashMap;
import java.util.Map;


public class TaskService {
	
	// implement HashMap to track objects by taskID
	public final Map<String, Task> taskLog = new HashMap<>();
	
	// method adds new task when taskID is not already stored
	public void addTask(Task task) {
		if (taskLog.containsKey(task.getTaskID())) {
			throw new IllegalArgumentException("Task ID Currently In Use");
		}
		
		else {
			taskLog.put(task.getTaskID(), task);
		}
	}
	
	// method deletes existing task when taskID is located in taskLog HashMap
	public void deleteTask (String taskID) {
		if (taskLog.containsKey(taskID)) {
			taskLog.remove(taskID);
		}
		
		else {
			throw new IllegalArgumentException("Task ID Not In Use Currently");
		}
	}
	
	// method updates name field in task object when taskID is located in taskLog HashMap
	public void updateTaskName (String taskID, String name) {
		Task task = taskLog.get(taskID);
		
		if (task == null) {
			throw new IllegalArgumentException("Task ID Not In Use Currently");
		}
		
		task.setName(name);
		}
	
	// method updates description field in task object when taskID is located in taskLog HashMap
	public void updateTaskDescription (String taskID, String description) {
		Task task = taskLog.get(taskID);
		
		if (task == null) {
			throw new IllegalArgumentException("Task ID Not In Use Currently");
		}
		
		task.setDescription(description);
		}
	}


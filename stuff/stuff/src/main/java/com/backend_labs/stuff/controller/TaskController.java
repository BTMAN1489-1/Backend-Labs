package com.backend_labs.stuff.controller;

import com.backend_labs.stuff.dto.TaskDTO;
import com.backend_labs.stuff.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api_v1/tasks")
public class TaskController {
	@Autowired
	private TaskService service;

	@GetMapping("")
	public List<TaskDTO> getTasksByUser(@RequestParam(name="user_id") Long userId){
		return service.getTasksByUser(userId);
	}

	@PostMapping("create_task")
	public String createUserTask(@RequestBody TaskDTO dto){
		return service.createTask(dto);
	}

	@GetMapping("/{task_id}")
	public TaskDTO getTask(@PathVariable(name="task_id") Long taskId) {
		return service.getTask(taskId);
	}

	@PutMapping("update_task")
	public String updateTask(@RequestBody TaskDTO dto) {
		return service.updateTask(dto);
	}

	@DeleteMapping("delete_task/{task_id}")
	public String deleteTask(@PathVariable(name="task_id") Long taskId){
		return service.deleteTask(taskId);
	}


}

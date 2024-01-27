package com.backend_labs.stuff.service;

import com.backend_labs.stuff.dto.TaskDTO;
import com.backend_labs.stuff.dto.UserDTO;
import com.backend_labs.stuff.exceptions.DoesntExistsException;
import com.backend_labs.stuff.exceptions.EmptyFieldException;
import com.backend_labs.stuff.models.Task;
import com.backend_labs.stuff.models.User;
import com.backend_labs.stuff.repository.TaskRepository;
import com.backend_labs.stuff.utils.Mapper;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class TaskService{

	@Autowired
	private TaskRepository repository;
	@Autowired
	private Mapper mapper;
	public List<TaskDTO> getTasksByUser(Long userId) {

		return repository.findAll().stream().map(x -> mapper.CreateTaskDTOFromTask(x)).collect(Collectors.toList());
	}

	public String createTask(TaskDTO dto) {
		repository.save(mapper.CreateTaskFromTaskDTO(dto));
		return "Task successfully created";
	}

	public TaskDTO getTask(Long taskId) {
		Task task = repository.findTaskById(taskId);

		if(task == null)
			throw new DoesntExistsException(String.format("Task(id=%d) doesnt exist", taskId));

		return mapper.CreateTaskDTOFromTask(task);

	}

	public String updateTask(TaskDTO dto) {
		Task task = repository.findTaskById(dto.getId());
		if (task != null) {
			task = mapper.UpdateTaskFromTaskDTO(dto, task);
			repository.save(task);
			return "Task successfully updated";
		}
		throw new EmptyFieldException("Non-validated field");
	}


	public String deleteTask(Long taskId) {
		Long status = repository.deleteTaskById(taskId);
		if(status == 0)
			throw new DoesntExistsException("Task does not exists");
		return "Task successfully deleted";

	}
}

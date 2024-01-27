package com.backend_labs.stuff.utils;
import com.backend_labs.stuff.dto.TaskDTO;
import com.backend_labs.stuff.dto.UserDTO;
import com.backend_labs.stuff.models.Task;
import com.backend_labs.stuff.models.User;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class Mapper {
	public TaskDTO CreateTaskDTOFromTask(Task task){
		return new TaskDTO(
				task.getId(),
				task.getName(),
				task.getDescription(),
				task.getStatus(),
				task.getUser_id()
		);
	}

	public Task CreateTaskFromTaskDTO(TaskDTO dto){
		return new Task(
				dto.getId(),
				dto.getTask_name(),
				dto.getTask_description(),
				dto.getStatus(),
				dto.getUser_id()
		);
	}

	public UserDTO CreateUserDTOFromUser(User user){
		String full_name = String.join(" ", List.of(user.getSecond_Name(), user.getFirst_Name(), user.getThird_name()));
		return new UserDTO(
				user.getId(),
				full_name,
				user.getSex(),
				user.getTaskList()
		);
	}

	public User CreateUserFromUserDTO(UserDTO dto){
		String[] names = dto.getFull_name().split(" ");

		if(names.length==3 && SexChoice.getChoices().contains(dto.getSex()))
			return new User(
			dto.getId(),
			names[1],
			names[0],
			names[2],
			dto.getSex(),
			dto.getTaskList()
			);
		return null;
	}

	public User UpdateUserFromUserDTO(UserDTO dto, User user){
		if(dto.getFull_name() != null){
			String[] names = dto.getFull_name().split(" ");
			if(names.length==3){
				user.setFirst_Name(names[1]);
				user.setSecond_Name(names[0]);
				user.setThird_name(names[2]);
			}
		}
		if (dto.getSex() != null) {
			if (SexChoice.getChoices().contains(dto.getSex()))
				user.setSex(dto.getSex());
		}

		return user;
	}

	public Task UpdateTaskFromTaskDTO(TaskDTO dto, Task task){
		if(dto.getTask_name() != null){
			task.setName(dto.getTask_name());
		}
		if(dto.getTask_description() != null){
			task.setDescription(dto.getTask_description());
		}
		if(dto.getStatus() != null){
			task.setStatus(dto.getStatus());
		}


		return task;
	}
}

package com.backend_labs.stuff.dto;

import com.backend_labs.stuff.models.Task;
import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;

@Data
@AllArgsConstructor
public class UserDTO {
	private Long id;
	private String full_name;
	private String sex;
	private List<Task> taskList;
}

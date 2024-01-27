package com.backend_labs.stuff.dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class TaskDTO {
	private Long id;
	private String task_name;
	private String task_description;
	private Boolean status;
	private Long user_id;
}

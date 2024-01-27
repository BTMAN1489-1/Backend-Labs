package com.backend_labs.stuff.models;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Entity
@Table(name = "task")
public class Task {
	public Task(){}

	@Column(name = "id")
	@jakarta.persistence.Id
	@GeneratedValue
	private Long Id;

	@Column(nullable = false)
	private String name;

	@Column()
	private String description;

	@Column(nullable = false)
	private Boolean status;

	@Column(nullable = false)
	private Long user_id;
}

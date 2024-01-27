package com.backend_labs.stuff.models;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@Entity
@Table(name = "user_info")
public class User {
	public User(){}

	@Column(name="id")
	@jakarta.persistence.Id
	@GeneratedValue
	private Long Id;

	@Column(nullable = false)
	private String first_Name;

	@Column(nullable = false)
	private String second_Name;

	@Column(nullable = false)
	private String third_name;

	@Column(name = "sex")
	private String sex;

	@OneToMany
	@JoinColumn(name = "user_id")
	private List<Task> taskList;
}

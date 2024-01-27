package com.backend_labs.stuff.repository;

import com.backend_labs.stuff.models.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
	Task findTaskById(Long taskId);
	Long deleteTaskById(Long id);
}

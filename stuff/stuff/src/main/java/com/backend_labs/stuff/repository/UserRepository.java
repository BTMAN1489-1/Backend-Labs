package com.backend_labs.stuff.repository;

import com.backend_labs.stuff.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
	User findUserById(Long id);

	Long deleteUserById(Long id);

}

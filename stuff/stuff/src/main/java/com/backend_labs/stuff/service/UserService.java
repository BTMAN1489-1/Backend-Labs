package com.backend_labs.stuff.service;

import com.backend_labs.stuff.dto.UserDTO;
import com.backend_labs.stuff.exceptions.DoesntExistsException;
import com.backend_labs.stuff.exceptions.EmptyFieldException;
import com.backend_labs.stuff.models.User;
import com.backend_labs.stuff.repository.UserRepository;
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
public class UserService {

	@Autowired
	private UserRepository repository;
	@Autowired
	private Mapper mapper;

	public List<UserDTO> list() {
		return repository.findAll().stream().map(x -> mapper.CreateUserDTOFromUser(x)).collect(Collectors.toList());
	}

	public String create(UserDTO dto) {
		User user = mapper.CreateUserFromUserDTO(dto);
		if (user != null) {
			repository.save(user);
			return "User successfully updated";
		}
		throw new EmptyFieldException("Non-validated field");
	}

	public UserDTO get(Long id) {
		User user = repository.findUserById(id);
		if (user != null)
			return mapper.CreateUserDTOFromUser(user);
		throw new DoesntExistsException(String.format("User(id=%d) doesnt exists", id));
	}

	public String update(UserDTO dto) {
		User user = repository.findUserById(dto.getId());
		if (user != null) {
			user = mapper.UpdateUserFromUserDTO(dto, user);
			repository.save(user);
			return "User successfully updated";
		}
		throw new EmptyFieldException("Non-validated field");
	}

	public String delete(Long id) {
		Long status = repository.deleteUserById(id);
		if (status == 0)
			throw new DoesntExistsException("User does not exists");

		return "User successfully deleted";
	}
}

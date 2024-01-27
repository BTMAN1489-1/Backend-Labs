package com.backend_labs.stuff.controller;


import com.backend_labs.stuff.dto.UserDTO;
import com.backend_labs.stuff.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api_v1/user_info")
public class UserController {

	@Autowired
	private UserService service;

	@GetMapping("")
	public List<UserDTO> list(){
		return service.list();
	}

	@PostMapping("create")
	public String create(@RequestBody UserDTO dto){
		return service.create(dto);
	}

	@GetMapping("/{user_id}")
	public UserDTO get(@PathVariable(name="user_id") Long id){
		return service.get(id);
	}

	@PutMapping("update")
	public String update(@RequestBody UserDTO dto){
		return service.update(dto);
	}

	@DeleteMapping("delete")
	public String delete(@RequestParam(name="user_id") Long id){
		return service.delete(id);
	}



}

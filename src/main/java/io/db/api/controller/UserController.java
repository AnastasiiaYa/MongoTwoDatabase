package io.db.api.controller;
import static io.db.api.transf.UserTransformer.transform;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.db.api.dataTransfObj.UserDataTransfObj;
import io.db.entity.User;
import io.db.service.UserService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {
	
	@Autowired
	private final UserService userService;
	
	@PostMapping
	public UserDataTransfObj create(@RequestBody UserDataTransfObj userDto) {
		User user = userService.create(transform(userDto, userDto.getId()));
		return transform(user, user.getId());
	}

	@GetMapping("/{id}")
	public UserDataTransfObj getUser(@PathVariable("id") String id) {
		return transform(userService.getById(id), id);
	}

	@PutMapping("/{id}")
	public UserDataTransfObj update(@PathVariable("id") String id, @RequestBody UserDataTransfObj userDto) {
		return transform(userService.update(transform(userDto, id)), id);
	}


	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") String id) {
		userService.delete(id);
	}
}

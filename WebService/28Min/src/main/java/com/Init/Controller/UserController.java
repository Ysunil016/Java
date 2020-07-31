package com.Init.Controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.LinkBuilder;
import org.springframework.hateoas.server.mvc.ControllerLinkBuilder;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.Init.Bean.User;
import com.Init.Dao.UserDao;
import com.Init.Exceptions.UserNotFoundException;

@RestController
public class UserController {

	@Autowired
	private UserDao userService;

	@GetMapping(value = "/users")
	private List<User> getAllUsers() {
		return userService.findAll();
	}

	@GetMapping(value = "/user/{id}")
	private EntityModel<User> getUser(@PathVariable("id") Integer id) {
		User Userfound = userService.findOne(id);
		if (Userfound == null)
			throw new UserNotFoundException("Id + " + id);

		EntityModel<User> resource = new EntityModel<User>(Userfound);
		Link link = linkTo(UserController.class).withRel("all-users");
		resource.add(link);

		return resource;
	}

	@PostMapping(value = "/user")
	private ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
		User savedUser = userService.save(user);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId())
				.toUri();

		return ResponseEntity.created(location).build();
	}

	@DeleteMapping(value = "/user/{id}")
	private User deleteById(@PathVariable("id") Integer id) {
		User Userfound = userService.deleteById(id);
		if (Userfound == null)
			throw new UserNotFoundException("Id + " + id);

		return Userfound;
	}

}

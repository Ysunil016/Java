package com.Init.Controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.Init.Bean.Post;
import com.Init.Bean.User;
import com.Init.Dao.UserDao;
import com.Init.Exceptions.UserNotFoundException;
import com.Init.Repository.PostJPARepository;
import com.Init.Repository.UserJPARepository;

@RestController
public class UserJPAController {

	@Autowired
	private UserJPARepository userRepository;
	@Autowired
	private PostJPARepository postRepository;

	@GetMapping(value = "/JPA/users")
	private List<User> getAllUsers() {
		return userRepository.findAll();
	}

	@GetMapping(value = "/JPA/user/{id}")
	private EntityModel<User> getUser(@PathVariable("id") Integer id) {
		Optional<User> Userfound = userRepository.findById(id);
		if (Userfound.isEmpty())
			throw new UserNotFoundException("Id + " + id);

		EntityModel<User> resource = new EntityModel<User>(Userfound.get());
		Link link = linkTo(UserJPAController.class).withRel("all-users");
		resource.add(link);

		return resource;
	}

	@PostMapping(value = "/JPA/user")
	private ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
		User savedUser = userRepository.save(user);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId())
				.toUri();

		return ResponseEntity.created(location).build();
	}

	@DeleteMapping(value = "/JPA/user/{id}")
	private HttpStatus deleteById(@PathVariable("id") Integer id) {
		try {
			userRepository.deleteById(id);
		} catch (Exception e) {
			throw new UserNotFoundException("Id + " + id);
		}
		return HttpStatus.OK;
	}

	@GetMapping(value = "/JPA/user/{id}/post")
	private List<Post> getAllPostByUser(@PathVariable("id") Integer id) {
		Optional<User> user = userRepository.findById(id);
		if (!user.isPresent()) {
			throw new UserNotFoundException("User Not Found " + id);
		}
		return user.get().getPosts();
	}

	@PostMapping(value = "/JPA/user/{id}/post")
	private ResponseEntity<Object> createPost(@PathVariable("id") Integer id, @RequestBody Post post) {
		Optional<User> user = userRepository.findById(id);
		if (!user.isPresent()) {
			throw new UserNotFoundException("User Not Found " + id);
		}

		post.setUser(user.get());
		postRepository.save(post);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(post.getId())
				.toUri();

		return ResponseEntity.created(location).build();
	}
}

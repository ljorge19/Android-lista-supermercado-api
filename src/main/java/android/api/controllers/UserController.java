package android.api.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import android.api.model.User;
import android.api.persistence.UserRepository;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	 
	// QueryParam
	@GetMapping
	public ResponseEntity<List<User>> getList() {
		List<User> users = new ArrayList<>();
		
		userRepository.findAll().forEach(users::add);

 		return new ResponseEntity<List<User>>(users, HttpStatus.OK);
	}

	@GetMapping("/{login}")
	public ResponseEntity<User> getUser(
			@PathVariable("login") 
			String login) {
		System.out.println("Get user "+login);
		User user = userRepository.findByLogin(login);
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<User> postUser
			(@RequestBody 
			User user) {
		System.out.println("Post user "+user);
		User user2 = userRepository.findByLogin(user.getLogin());
		if (user2 == null) {
		userRepository.save(user);
		return new ResponseEntity<User>(user, HttpStatus.OK);
		}
		else {
			user2.setPassword("******");
			return new ResponseEntity<User>(user2, HttpStatus.CONFLICT);
		}
	}
	
	@PutMapping
	public ResponseEntity<User> putUser
			(@RequestBody 
			User user) {
		System.out.println("Put user "+user);
		if (user.getId() == null) {
			User user2 = userRepository.findByLogin(user.getLogin());
			user.setId(user2.getId());
		}
		userRepository.save(user);
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
	
	@DeleteMapping
	public ResponseEntity<User> deleteUser(@RequestBody 
			User user) {
		System.out.println("Delete user "+user);
		if (user.getId() == null) {
			User user2 = userRepository.findByLogin(user.getLogin());
			user.setId(user2.getId());
		}
		userRepository.delete(user);
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
	
	@DeleteMapping("/{login}")
	public ResponseEntity<User> deleteUser(
			@PathVariable("login") 
			String login) {
		System.out.println("Get user "+login);
		User user = userRepository.findByLogin(login);
		userRepository.delete(user);
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
	
}

package com.springrest.pfe.controlleur;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springrest.pfe.model.User;
import com.springrest.pfe.service.UserServiceImpl;

@RestController
@RequestMapping("api/app")
@CrossOrigin("*")
public class UserController {
	
	@Autowired
	private UserServiceImpl userServiceImpl;
	
	@GetMapping("/users/all")
	public List<User> afficherUsers(){
		return userServiceImpl.findall();
	}

	@GetMapping("/users/{id}")
	public User afficherUsers(@PathVariable(name="id") Long id){
		return userServiceImpl.findbyid(id);
	}
	
	@PostMapping("/users/user")
	public User inscrire(@RequestBody User user) {
		return	userServiceImpl.inscrire(user);
	}
	// tester user
	@PostMapping("/users")
	public User testeUser(@RequestBody User user) {
		return	userServiceImpl.testeUser(user.getEmail(), user.getPassword());
	}
	@CrossOrigin("*")
	@DeleteMapping("/users/supprimer/{id}")
	public void supprimer(@PathVariable(name="id")Long  Id) {
		userServiceImpl.supprimer(Id);
	}
	
	

}

package com.Back.controllere;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Back.exception.ResourceNotFoundException;
import com.Back.model.User;
import com.Back.repository.UserRepository;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/V1")
public class UserController {
	
	@Autowired
	private UserRepository userRepository ;
	
	@GetMapping("/users")
	public  List<User> getAllUser(){
		return userRepository.findAll();
		
	}
	
	@PostMapping("/users")
	public User createUser(@RequestBody User user) {
		return userRepository.save(user);
	}
	@GetMapping("/users/{id}")
	public ResponseEntity<User> getUserById(@PathVariable int id){
		User user = userRepository.findById(id)
				.orElseThrow(()->new ResourceNotFoundException("user with this id is not found please enter valid id "));
		return ResponseEntity.ok(user) ;
	}
	
	@PutMapping("/user/{id}")
	public ResponseEntity<User> updateUser(@PathVariable int id,@RequestBody User userDetaits){
		User user = userRepository.findById(id)
				.orElseThrow(()->new ResourceNotFoundException("user with this id is not found please enter valid id "));
		if (userDetaits.getFirstName() !=null ){
		user.setFirstName(userDetaits.getFirstName());}
		if (userDetaits.getLastName()!=null ){
		user.setLastName(userDetaits.getLastName());}
		if (userDetaits.getMatrecule()!=null ){
		user.setMatrecule(userDetaits.getMatrecule());}
		if (userDetaits.getEmails()!=null ){
		user.setEmails(userDetaits.getEmails());}
		if (userDetaits.getCompany()!=null ){
		user.setCompany(userDetaits.getCompany());}
		if (userDetaits.getPassword()!= null) {
			user.setPassword(userDetaits.getPassword());
		}
		
		User updateUser = userRepository.save(user);
		
		return ResponseEntity.ok(updateUser) ;
	}
	
	@DeleteMapping("/users/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteUser(@PathVariable int id){
		
		User user = userRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("user with this id is not found : "+ id));
		
		userRepository.delete(user);
		Map<String,Boolean> response = new HashMap<>();
		response.put("deleted",Boolean.TRUE);
		return ResponseEntity.ok(response);
		
		
	}
}

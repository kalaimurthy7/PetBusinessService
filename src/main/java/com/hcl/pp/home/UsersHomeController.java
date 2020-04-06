package com.hcl.pp.home;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.hcl.pp.model.Pet;
import com.hcl.pp.model.User;

@RestController
@RequestMapping("/users")
public class UsersHomeController {
	
	@Autowired
	RestTemplate restTemplate;
	
	@Autowired	
	public UsersHomeController(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}
	
	@RequestMapping("/getAllUsers")
	public List<User> getAllusers(){
		List<User> users = restTemplate.exchange("http://localhost:7071/users/getAllUsers", HttpMethod.GET, null, new ParameterizedTypeReference<List<User>>(){}).getBody();
		return users;
	}
	
	@RequestMapping("/{byName}")
	public User byName(@PathVariable String byName) {
		User user = restTemplate.exchange("http://localhost:7071/users/{byName}", HttpMethod.GET, null, new ParameterizedTypeReference<User>() {}, byName).getBody();
		return user;
	}
	
	@PostMapping(value = "/addUser", consumes =MediaType.APPLICATION_JSON_VALUE)
	public String addUser(@RequestBody User user) {
		return restTemplate.postForObject("http://localhost:7071/users/addUser", user, String.class);
	}
	
	@PutMapping("/buyPet/{petid}/{ownerid}")
	public String buyPet(@PathVariable long petid, @PathVariable long ownerid) {
		return restTemplate.exchange("http://localhost:7071/users/buyPet/{petid}/{ownerid}", HttpMethod.PUT, null, new ParameterizedTypeReference<String>() {}, petid, ownerid).getBody();
	}
	
	@GetMapping("/myPets/{ownerid}")
	public List<Pet> myPets(@PathVariable long ownerid){
		return restTemplate.exchange("http://localhost:7071/users/myPets/{ownerid}", HttpMethod.GET, null, new ParameterizedTypeReference<List<Pet>>(){}, ownerid).getBody();
	}
	
}

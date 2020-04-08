package com.hcl.pp.home;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
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
	
	@RequestMapping("/getAllUsers")
	public List<User> getAllusers(){
		List<User> users = restTemplate.exchange("http://pet-domainservice/users/getAllUsers", HttpMethod.GET, null, new ParameterizedTypeReference<List<User>>(){}).getBody();
		return users;
	}
	
	@RequestMapping("/{byName}")
	public User byName(@PathVariable String byName) {
		User user = restTemplate.exchange("http://pet-domainservice/users/{byName}", HttpMethod.GET, null, new ParameterizedTypeReference<User>() {}, byName).getBody();
		return user;
	}
	
	@PostMapping(value = "/addUser", consumes =MediaType.APPLICATION_JSON_VALUE)
	public String addUser(@RequestBody User user) {
		return restTemplate.postForObject("http://pet-domainservice/users/addUser", user, String.class);
	}
	
	@PutMapping("/buyPet/{petid}/{ownerid}")
	public String buyPet(@PathVariable long petid, @PathVariable long ownerid) {
		return restTemplate.exchange("http://pet-domainservice/users/buyPet/{petid}/{ownerid}", HttpMethod.PUT, null, new ParameterizedTypeReference<String>() {}, petid, ownerid).getBody();
	}
	
	@GetMapping("/myPets/{ownerid}")
	public List<Pet> myPets(@PathVariable long ownerid){
		return restTemplate.exchange("http://pet-domainservice/users/myPets/{ownerid}", HttpMethod.GET, null, new ParameterizedTypeReference<List<Pet>>(){}, ownerid).getBody();
	}
	
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
	
}

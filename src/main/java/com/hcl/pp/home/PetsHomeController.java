package com.hcl.pp.home;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.hcl.pp.model.Pet;

@RestController
@RequestMapping("/pets")
public class PetsHomeController {
	
	@Autowired
	RestTemplate restTemplate;
	
	@Autowired	
	public PetsHomeController(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}
	
	@RequestMapping("/getAllPets")
	public List<Pet> getAllpets(){
		List<Pet> pets = restTemplate.exchange("http://localhost:7071/pets/getAllPets", HttpMethod.GET, null, new ParameterizedTypeReference<List<Pet>>(){}).getBody();
		return pets;
	}
	
	@RequestMapping("/{petid}")
	public Pet home(@PathVariable long petid) {
		Pet pet = restTemplate.exchange("http://localhost:7071/pets/{petid}", HttpMethod.GET, null, new ParameterizedTypeReference<Pet>() {}, petid).getBody();
		return pet;
	}
	
	@PostMapping(value = "/addPet", consumes = MediaType.APPLICATION_JSON_VALUE)
	public String addPet(@RequestBody Pet pet) {
		return restTemplate.postForObject("http://localhost:7071/pets/addPet", pet, String.class);
	}
	
}

package ibm.teal.services.banque.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import ibm.teal.services.banque.beans.Application;
import ibm.teal.services.banque.repositories.ApplicationRepo;

@RestController
public class ApplicationController {

	@Autowired
	private ApplicationRepo applicationRepo;
	
	@GetMapping("/applications")
	public List<Application> displayApplication(){
		return applicationRepo.findAll();
	}
	@PostMapping("/createapplication")
	public ResponseEntity<Object> createApplication(@RequestBody Application application) {
		Application savedCompte=applicationRepo.save(application);
		URI location= ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedCompte.getId_application()).toUri();
		
		
		return ResponseEntity.created(location).build();
	}
	
	@DeleteMapping("/deleteapplication/{id}")
public void deleteAccount(@PathVariable Long id) {
		applicationRepo.deleteById(id);
	}
	
	@PutMapping("/updateapplication/{id}")
	public ResponseEntity<Object> updateApplication(@RequestBody Application application, @PathVariable Long id){
		
		Optional<Application> ApplicationOptional= applicationRepo.findById(id);
		if(!ApplicationOptional.isPresent())
			return ResponseEntity.notFound().build();
		application.setId_application(id);
		applicationRepo.save(application);
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping("/findapplication/{id}")
	public Application findApplication(@PathVariable long id) {
		return applicationRepo.findById(id).orElse(null);
				
	}
}

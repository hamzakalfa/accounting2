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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import ibm.teal.services.banque.beans.Client;
import ibm.teal.services.banque.repositories.ClientRepo;

@RestController
public class ClientController {
	@Autowired
	private ClientRepo clientRepo;
	
	@GetMapping("/clients")
	public List<Client> displayClients(){
		return clientRepo.findAll();
	}
	
	@PostMapping("/createclient")
	public ResponseEntity<Object> createClient(@RequestBody Client client) {
		Client savedClient=clientRepo.save(client);
		URI location= ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedClient.getId_Client()).toUri();
		
		
		return ResponseEntity.created(location).build();
	}
	
	@DeleteMapping("/deleteclient/{id}")
public void deleteClient(@PathVariable Long id) {
		clientRepo.deleteById(id);
	}
	
	@PutMapping("/updateclient/{id}")
	public ResponseEntity<Object> updateClient(@RequestBody Client client, @PathVariable Long id){
		Optional<Client> ClientOptional= clientRepo.findById(id);
		if(!ClientOptional.isPresent())
			return ResponseEntity.notFound().build();
		client.setId_Client(id);
		clientRepo.save(client);
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping("/findclientnom")
	public String findClientnom(@RequestParam long id) {
		return clientRepo.findById(id).orElse(null).getNom_Client();
	}
	
	@GetMapping("/findclientjson")
	public Client findClientjson(@RequestParam long id) {
		return clientRepo.findById(id).orElse(null);
	}
	
	@GetMapping("/findclient/cin/{id}")
	public Client findClientByCIN(@PathVariable String id) {
		return clientRepo.findByIDNumber(id);
	}
	
	/*@GetMapping("/findByAccount/{id}")
	public Client findByAccount(@PathVariable String id) {
		return clientRepo.findByAccount(id);
	}*/
}

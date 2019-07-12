package ibm.teal.services.banque.controller;

import java.io.IOException;
import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.json.JSONException;

import org.json.JSONObject;
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

import antlr.ParserSharedInputState;

import org.codehaus.jackson.map.ObjectMapper;

import ibm.teal.services.banque.beans.Client;
import ibm.teal.services.banque.beans.Compte;
import ibm.teal.services.banque.repositories.CompteRepo;

@RestController
public class CompteController {

	@Autowired
	private CompteRepo compteRepo;
	@Autowired
	private ClientController clientRepo;
	@GetMapping("/accounts")
	public List<Compte> displayAccounts(){
		return compteRepo.findAll();
	}
//	@PostMapping("/createaccount")
//	public Compte createAccount(@RequestBody String jsonBody) throws IOException, JSONException {
//		JSONObject jsonObj=new JSONObject(jsonBody);
//		String clientString=jsonObj.get("client").toString();
//		String compteString=jsonObj.get("compte").toString();
//		ObjectMapper mapper = new ObjectMapper();   
//		Client client =mapper.readValue(clientString, Client.class);
//		Compte compte=mapper.readValue(compteString, Compte.class);
//		compte.setClient(client);
//		System.out.print(compte.getClient().getNom_Client()+"    pk");
//		Compte savedCompte=compteRepo.save(compte);
//		URI location= ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedCompte.getId_compte()).toUri();
//		
//
//		return savedCompte;
////		return ResponseEntity.created(location).build();
////		 return new ResponseEntity<String>(t.getClass()., responseHeaders, HttpStatus.CREATED);
//	}
	
	@PostMapping("/createaccount")
	public Compte createAccount(@RequestBody String jsonBody) throws IOException, JSONException {
		JSONObject jsonObj=new JSONObject(jsonBody);
		String clientString=jsonObj.get("iDNumber").toString();
		String soldeString=jsonObj.get("solde").toString();
		
		Client client= clientRepo.findClientByCIN(clientString);
		Compte compte= new Compte();
		compte.setClient(client);
		compte.setSolde(soldeString);

		System.out.print(compte.getClient().getNom_Client()+"    pk");
		Compte savedCompte=compteRepo.save(compte);
		URI location= ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedCompte.getId_compte()).toUri();
		

		return savedCompte;
//		return ResponseEntity.created(location).build();
//		 return new ResponseEntity<String>(t.getClass()., responseHeaders, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/deleteaccount/{id}")
public void deleteAccount(@PathVariable Long id) {
		compteRepo.deleteById(id);
	}
	
	@PutMapping("/updateaccount/{id}")
	public ResponseEntity<Object> updateAccount(@RequestBody Compte compte, @PathVariable Long id){

	Compte c=compteRepo.findById(id).orElse(null);
		Optional<Compte> CompteOptional= compteRepo.findById(id);
		if(!CompteOptional.isPresent())
			return ResponseEntity.notFound().build();
		compte.setId_compte(id);
		compte.setNumerodecompte(c.getNumerodecompte());
		compte.setClient(c.getClient());
		compteRepo.save(compte);
		return ResponseEntity.noContent().build();
	} 
	
	@GetMapping("/findaccount/{id}")
	public Compte findAccount(@PathVariable long id) {
		return compteRepo.findById(id).orElse(null);
				
	}
	
	@GetMapping("/findClient/{numCompte}")
	public Client findClientAccount(@PathVariable long numCompte) {
		return compteRepo.findClientByAccount(numCompte);
				
	}
	
	@GetMapping("/findaccountbyNC/{numerodecompte}")
	public Compte findAccountByNumDeCompte(@PathVariable long numerodecompte) {
		return compteRepo.findByNumerodecompte(numerodecompte);
				
	}
	
	@GetMapping("/findClientByAccount/{numerodecompte}")
	public Client findClientByAccount(@PathVariable long numerodecompte) {
		System.out.println(numerodecompte);
		return compteRepo.findClientByAccount(numerodecompte);
				
	}
}

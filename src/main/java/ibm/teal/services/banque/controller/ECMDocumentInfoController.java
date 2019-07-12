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

import ibm.teal.services.banque.beans.ECMDocumentInfo;
import ibm.teal.services.banque.repositories.ECMDocumentInfoRepo;

@RestController
public class ECMDocumentInfoController {

	@Autowired
	private ECMDocumentInfoRepo documentRepo;
	
	@GetMapping("/ECMDocumentInfos")
	public List<ECMDocumentInfo> displayECMDocumentInfo(){
		return documentRepo.findAll();
	}
	@PostMapping("/createECMDocumentInfo")
	public ResponseEntity<Object> createECMDocumentInfo(@RequestBody ECMDocumentInfo ECMDocumentInfo) {
		ECMDocumentInfo savedDocument=documentRepo.save(ECMDocumentInfo);
		URI location= ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedDocument.getId_document()).toUri();
		
		
		return ResponseEntity.created(location).build();
	}
	
	@DeleteMapping("/deleteECMDocumentInfo/{id}")
public void deleteECMDocumentInfo(@PathVariable Long id) {
		documentRepo.deleteById(id);
	}
	
	@PutMapping("/updateECMDocumentInfo/{id}")
	public ResponseEntity<Object> updateECMDocumentInfo(@RequestBody ECMDocumentInfo ECMDocumentInfo, @PathVariable Long id){
		
		Optional<ECMDocumentInfo> ECMDocumentInfoOptional= documentRepo.findById(id);
		if(!ECMDocumentInfoOptional.isPresent())
			return ResponseEntity.notFound().build();
		ECMDocumentInfo.setId_document(id);
		documentRepo.save(ECMDocumentInfo);
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping("/findECMDocumentInfo/{id}")
	public ECMDocumentInfo findECMDocumentInfo(@PathVariable long id) {
		return documentRepo.findById(id).orElse(null);
				
	}
}

package tp.bank.controller.api;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tp.bank.exception.ResourceNotFoundException;
import tp.bank.model.Client;
import tp.bank.model.Compte;
import tp.bank.repository.CompteRepository;

@RestController
@RequestMapping("/api")
public class CompteController {
	
    @Autowired
    CompteRepository compteRepository;

	@GetMapping("/comptes")
	 public List<Compte> getAllComptes(){
		 return compteRepository.findAll();
	 }
	 
	@PostMapping("/comptes")
	 public Compte createCompte(@RequestBody Compte compte) {
		 return compteRepository.save(compte);
	 }
	 
	@GetMapping("/compte/{id}")
	 public Compte getCompteById(@PathVariable(value = "id") Long id) {
		return compteRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Compte", "id", id));
	 }
	 
	@PutMapping("/compte/{id}")
	 public Compte updateCompte(@PathVariable(value = "id") Long id,
             @Valid @RequestBody Compte compteDetails) {
		
		Compte compte = compteRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Compte", "id", id));
		
		compte.setBalance(compte.getBalance());
		compte.setClient(compte.getClient());
		
        Compte updatedCompte = compteRepository.save(compte);
        return updatedCompte;
	 }
	 
	@DeleteMapping("/comptes")
	 public ResponseEntity<?> deleteCompte(Long id){
		  Compte compte = compteRepository.findById(id)
	                .orElseThrow(() -> new ResourceNotFoundException("Compte", "id", id));

	        compteRepository.delete(compte);

	        return ResponseEntity.ok().build();	 
	        }
	
}

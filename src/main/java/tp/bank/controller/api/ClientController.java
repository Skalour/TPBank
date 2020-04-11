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
import tp.bank.repository.ClientRepository;

@RestController
@RequestMapping("/api")
public class ClientController {
	
    @Autowired
    ClientRepository clientRepository;
    
    // Get All Clients
    @GetMapping("/clients")
    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    // Create a new Client
    @PostMapping("/clients")
    public Client createClient(@Valid @RequestBody Client client) {
        return clientRepository.save(client);
    }

    // Get a Single Client
    @GetMapping("/clients/{id}")
    public Client getClientById(@PathVariable(value = "id") Long clientId) {
        return clientRepository.findById(clientId)
                .orElseThrow(() -> new ResourceNotFoundException("Client", "id", clientId));
    }
    
	@GetMapping("/clients/{id}/compte")
	 public Compte getCompteByCientId(@PathVariable(value = "id") Long clientId) {
		return clientRepository.findById(clientId).get().getCompte();
	 }

    // Update a Client
    @PutMapping("/clients/{id}")
    public Client updateClient(@PathVariable(value = "id") Long clientId,
                                            @Valid @RequestBody Client clientDetails) {

        Client client = clientRepository.findById(clientId)
                .orElseThrow(() -> new ResourceNotFoundException("Client", "id", clientId));

        client.setLastname(clientDetails.getLastname());
        client.setFirstname(clientDetails.getFirstname());
        client.setPostalAddress(clientDetails.getPostalAddress());
        client.setPostalCode(clientDetails.getPostalCode());
        client.setCity(clientDetails.getCity());
        client.setEmail(clientDetails.getEmail());
        client.setPhoneNumber(clientDetails.getPhoneNumber());

        Client updatedClient = clientRepository.save(client);
        return updatedClient;
    }

    // Delete a Client
    @DeleteMapping("/notes/{id}")
    public ResponseEntity<?> deleteClient(@PathVariable(value = "id") Long clientId) {
        Client client = clientRepository.findById(clientId)
                .orElseThrow(() -> new ResourceNotFoundException("Client", "id", clientId));

        clientRepository.delete(client);

        return ResponseEntity.ok().build();
    }

}

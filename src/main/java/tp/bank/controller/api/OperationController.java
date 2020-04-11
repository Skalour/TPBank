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
import tp.bank.model.Operation;
import tp.bank.repository.OperationRepository;

@RestController
@RequestMapping("/api")
public class OperationController {
	
    @Autowired
    OperationRepository operationRepository;

	@GetMapping("/operations")
	 public List<Operation> getAllOperations(){
		 return operationRepository.findAll();
	 }
	 
	@PostMapping("/operations")
	 public Operation createOperation(@RequestBody Operation operation) {
		 return operationRepository.save(operation);
	 }
	 
	@GetMapping("/operation/{id}")
	 public Operation getOperationById(@PathVariable(value = "id") Long id) {
		return operationRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Operation", "id", id));
	 }
	 
	@PutMapping("/operation/{id}")
	 public Operation updateOperation(@PathVariable(value = "id") Long id,
             @Valid @RequestBody Operation operationDetails) {
		
		Operation operation = operationRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Operation", "id", id));
		
		operation.setDetails(operationDetails.getDetails());
		operation.setType(operationDetails.getType());
		
        Operation updatedOperation = operationRepository.save(operation);
        return updatedOperation;
	 }
	 
	@DeleteMapping("/operations")
	 public ResponseEntity<?> deleteOperation(Long id){
		  Operation operation= operationRepository.findById(id)
	                .orElseThrow(() -> new ResourceNotFoundException("Operation", "id", id));

	        operationRepository.delete(operation);

	        return ResponseEntity.ok().build();	 
	        }
	
}
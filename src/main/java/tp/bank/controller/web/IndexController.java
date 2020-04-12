package tp.bank.controller.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import tp.bank.MainUser;
import tp.bank.model.Client;
import tp.bank.model.Compte;
import tp.bank.model.Operation;
import tp.bank.repository.ClientRepository;
import tp.bank.repository.OperationRepository;

@Controller
public class IndexController {

	@Autowired
	ClientRepository clientRepository;
	
	@Autowired
	OperationRepository operationRepository;
	
	@GetMapping("/index")
	public String index(Model model) {
		Object main = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Optional<Client> client = clientRepository.findById(((MainUser)main).getId());
        Compte compte = client.get().getCompte();
        List<Operation> inOperations = operationRepository.findAllInOperationsByCompteId(compte.getId());
        List<Operation> outOperations = operationRepository.findAllOutOperationsByCompteId(compte.getId());
        model.addAttribute("client", client.get());
        model.addAttribute("compte", compte);
        model.addAttribute("inOperations", inOperations);
        model.addAttribute("outOperations", outOperations);
        return "index";
	}
	
	
	
}

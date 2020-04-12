package tp.bank.controller.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import tp.bank.model.Client;
import tp.bank.repository.ClientRepository;

@Controller
public class LoginController {
	
	@Autowired
    private BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
    private ClientRepository clientRepository;
	
	@ModelAttribute("client")
	    public Client userRegistrationDto() {
	        return new Client();
	    }
	
    @GetMapping("/login")
    public String login() {
        return "login";
    }
    
    @PostMapping("/signup")
    public String registerUserAccount(@ModelAttribute("client")Client client,
                                      BindingResult result){

        //Client existing = userService.findByEmail(userDto.getEmail());

       /* if (existing != null){
            result.rejectValue("email", null, "Cet e-mail est déjà utilisé.");
        }

        if (result.hasErrors()){
            return "signup";
        }*/

        this.save(client);
        return "redirect:/login";
    }
    


	@GetMapping("/signup")
	public String showRegistrationForm(Model model) {
	    return "signup";
	}

	public Client save(Client newClient){
	     Client client = new Client();
	        client.setLastname(newClient.getLastname());
	        client.setFirstname(newClient.getFirstname());
	        client.setPostalAddress(newClient.getPostalAddress());
	        client.setPostalCode(newClient.getPostalCode());
	        client.setCity(newClient.getCity());
	        client.setBirthdate(newClient.getBirthdate());
	        client.setPhoneNumber(newClient.getPhoneNumber());
	        client.setEmail(newClient.getEmail());
	        client.setPassword(passwordEncoder.encode(newClient.getPassword()));
	        client = clientRepository.save(client);
	        return client;
	    }

}
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

	public Client save(Client registration){
	     Client user = new Client();
	        user.setLastname(registration.getLastname());
	        user.setFirstname(registration.getFirstname());
	        user.setEmail(registration.getEmail());
	        user.setPassword(passwordEncoder.encode(registration.getPassword()));
	        user = clientRepository.save(user);
	        return user;
	    }

}
package tp.bank.controller.web;

import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import tp.bank.MainUser;
import tp.bank.model.Client;
import tp.bank.repository.ClientRepository;

@Controller
public class IndexController {

	@Autowired
	ClientRepository clientRepository;
	
	
	@GetMapping("/index")
	public String index(Model model) {
		Object main = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Optional<Client> client = clientRepository.findById(((MainUser)main).getId());
        model.addAttribute("client", client.get());
        return "index";
	}
	
	@RequestMapping("/index")
	public ModelAndView thymeleafView(Map<String, Object> model) {
	    model.put("number", 1234);
	    model.put("message", "Hello from Spring MVC");
	    return new ModelAndView("index");
	}
	
	
}

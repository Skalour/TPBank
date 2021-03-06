package tp.bank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import tp.bank.MainUser;
import tp.bank.model.Client;
import tp.bank.repository.ClientRepository;

@Service
public class UserService implements UserDetailsService{
	
	@Autowired
	ClientRepository clientRepository;

	@Override
	public UserDetails loadUserByUsername(String usernameOrEmail) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Client client = clientRepository.findByEmail(usernameOrEmail);
        return MainUser.create(client);
	}
	
}

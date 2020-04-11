package tp.bank.repository;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import tp.bank.model.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long>{
	
	public Client findByEmail(String email);
	public Optional<Client> findById(Long id);

}

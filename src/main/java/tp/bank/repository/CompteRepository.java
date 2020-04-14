package tp.bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import tp.bank.model.Compte;

@Repository
public interface CompteRepository extends JpaRepository<Compte, Long> {
	

}
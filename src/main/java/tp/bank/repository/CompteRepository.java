package tp.bank.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tp.bank.model.Compte;

@Repository
public interface CompteRepository extends JpaRepository<Compte, Long> {


}
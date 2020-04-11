package tp.bank.repository;

import java.util.List;

import javax.validation.Valid;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import tp.bank.model.Operation;

@Repository
public interface OperationRepository extends JpaRepository<Operation, Long>{
	
	
}
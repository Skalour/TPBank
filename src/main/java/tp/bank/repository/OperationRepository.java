package tp.bank.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tp.bank.model.Operation;

@Repository
public interface OperationRepository extends JpaRepository<Operation, Long>{
	

	@Query(value = "SELECT * FROM operation o WHERE o.to_account_id = :compte", 
	  nativeQuery = true)
	List<Operation> findAllInOperationsByCompteId(@Param("compte") Long compteId);
	
	@Query(value = "SELECT * FROM operation o WHERE o.from_account_id = :compte", 
	  nativeQuery = true)
	List<Operation> findAllOutOperationsByCompteId(@Param("compte") Long compteId);
}
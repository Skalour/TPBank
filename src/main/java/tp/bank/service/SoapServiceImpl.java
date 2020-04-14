package tp.bank.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tp.bank.model.Compte;
import tp.bank.model.Operation;
import tp.bank.repository.CompteRepository;
import tp.bank.repository.OperationRepository;

@Service
public class SoapServiceImpl implements SoapService{
	
	@Autowired
	CompteRepository compteRepository;

	@Autowired
	OperationRepository operationRepository;
	
	@Override
	public Boolean refundAccountRequest(Long accountId, double amount, Long accountIdOrigin, String details) {
		// TODO Auto-generated method stub
		Optional<Compte> toRefundOptional = compteRepository.findById(accountId);
		Optional<Compte> fromRefundOptional = compteRepository.findById(accountIdOrigin);
		if(fromRefundOptional != null && toRefundOptional != null) {
			Compte toRefund = toRefundOptional.get();
			Compte fromRefund = fromRefundOptional.get();
			Operation transaction = new Operation();
			transaction.setFromAccount(fromRefund);
			transaction.setToAccount(toRefund);
			transaction.setAmount(amount);
			transaction.setDetails(details);
			toRefund.setBalance(toRefund.getBalance() + amount);
			fromRefund.setBalance(fromRefund.getBalance() - amount);
			operationRepository.save(transaction);
			compteRepository.save(toRefund);
			compteRepository.save(fromRefund);
			return true;
		}
		else return false;
	}

	@Override
	public Boolean chargeAccountRequest(Long accountId, double amount, Long accountIdOrigin, String details) {
		// TODO Auto-generated method stub
		Optional<Compte> toChargeOptional = compteRepository.findById(accountId);
		Optional<Compte> fromChargeOptional = compteRepository.findById(accountIdOrigin);
		if(fromChargeOptional != null && toChargeOptional != null) {
			Compte toCharge = toChargeOptional.get();
			Compte fromCharge = fromChargeOptional.get();
			Operation transaction = new Operation();
			transaction.setFromAccount(toCharge);
			transaction.setToAccount(fromCharge);
			transaction.setAmount(amount);
			transaction.setDetails(details);
			toCharge.setBalance(toCharge.getBalance() - amount);
			fromCharge.setBalance(fromCharge.getBalance() + amount);
			operationRepository.save(transaction);
			compteRepository.save(toCharge);
			compteRepository.save(fromCharge);
			return true;
		}
		else return false;
	}
	
}

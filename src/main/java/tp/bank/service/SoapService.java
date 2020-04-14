package tp.bank.service;

public interface SoapService {
	
	public Boolean refundAccountRequest(Long accountId, double amount, Long accountIdOrigin, String details);
	public Boolean chargeAccountRequest(Long accountId, double amount, Long accountIdOrigin, String details);

}


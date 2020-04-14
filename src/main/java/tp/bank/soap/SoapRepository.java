package tp.bank.soap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import tp.bank.service.SoapService;


@Component
public class SoapRepository {
	
	@Autowired
    SoapService soapService;

    public Boolean refundAccountRequest(Long accountId, double amount, Long accountIdOrigin, String details) {
        Boolean result = soapService.refundAccountRequest(accountId, amount, accountIdOrigin, details);
        return result;
    }

    public Boolean chargeAccountRequest(Long accountId, double amount, Long accountIdOrigin, String details) {
        Boolean result = soapService.chargeAccountRequest(accountId, amount, accountIdOrigin, details);
        return result;
    }

}

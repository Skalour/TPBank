package tp.bank.soap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class SoapServiceEndPoint {
 
    private static final String NAMESPACE_URI = "http://localhost:8080/BankWebService";
 
    private SoapRepository soapRepository;
 
    @Autowired
    public SoapServiceEndPoint(SoapRepository soapRepository) {
        this.soapRepository = soapRepository;
    }
 
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "chargeAccountRequest")
    @ResponsePayload
    public ChargeAccountResponse chargeAccount(@RequestPayload ChargeAccountRequest chargeAccountRequest) {
    	Boolean result = soapRepository.chargeAccountRequest(chargeAccountRequest.getAccount(), chargeAccountRequest.getAmount(), chargeAccountRequest.getOrigin(), chargeAccountRequest.getDetails());
    	ChargeAccountResponse response = new ChargeAccountResponse();
    	response.setStatus(result);
        return response;
    }
    
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "refundAccountRequest")
    @ResponsePayload
    public RefundAccountResponse refundAccount(@RequestPayload RefundAccountRequest refundAccountRequest) {
    	Boolean result = soapRepository.refundAccountRequest(refundAccountRequest.getAccount(), refundAccountRequest.getAmount(), refundAccountRequest.getOrigin(), refundAccountRequest.getDetails());
    	RefundAccountResponse response = new RefundAccountResponse();
        response.setStatus(result);
        return response;
    }
}
package cxf.democxf;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService(targetNamespace="http://demo-cxf/")
public interface IPolicyService {
	
	// in order to test the service in SOAP-UI
	// add the wsdl, http://localhost:8000/soap/policyService
	// add the basic auth. and input the username and password defined in the AuthInterceptor
	// use Authenticate pre-emptively

	@WebMethod
	PolicyVO getPolicyByPolicyNumber(@WebParam(name = "policyNumber") String policyNumber);
	
	
	@WebMethod
	boolean addPolicy(@WebParam(name = "policy") PolicyVO policy);
	
	
}

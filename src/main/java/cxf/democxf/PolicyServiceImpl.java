package cxf.democxf;

import javax.jws.WebService;

import org.apache.cxf.interceptor.InInterceptors;
import org.springframework.stereotype.Component;

@InInterceptors(interceptors={"cxf.democxf.AuthInterceptor"})
@WebService(serviceName = "PolicyService", targetNamespace = "http://demo-cxf/", endpointInterface = "cxf.democxf.IPolicyService")
@Component
public class PolicyServiceImpl implements IPolicyService {

	@Override
	public PolicyVO getPolicyByPolicyNumber(String policyNumber) {

		// need to create and implement the IPolicyDAO for access the data of the policy
		// dummy data is used in the following for the demo
		
		PolicyVO data = new PolicyVO();
		
		data.setClientID("12345678");
		data.setPolicyNumber("2190000001");
		data.setPlanCode("VHIS");
				
		return data;
	}

	@Override
	public boolean addPolicy(PolicyVO policy) {
		// TODO Auto-generated method stub
		return false;
	}

}

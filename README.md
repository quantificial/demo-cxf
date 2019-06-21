# demo-cxf

use SoapUI to test

add the WSDL and make request to http://localhost:8000/soap/policyService?wsdl



*Request*


```
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:demo="http://demo-cxf/">
   <soapenv:Header/>
   <soapenv:Body>
      <demo:getPolicyByPolicyNumber>
         <!--Optional:-->
         <policyNumber>D12345678</policyNumber>
      </demo:getPolicyByPolicyNumber>
   </soapenv:Body>
</soapenv:Envelope>

```

*Response*

```

<soap:Envelope xmlns:soap="http://schemas.xmlsoap.org/soap/envelope/">
   <soap:Body>
      <ns2:getPolicyByPolicyNumberResponse xmlns:ns2="http://demo-cxf/">
         <return>
            <clientID>12345678</clientID>
            <planCode>VHIS</planCode>
            <policyNumber>D12345678</policyNumber>
         </return>
      </ns2:getPolicyByPolicyNumberResponse>
   </soap:Body>
</soap:Envelope>


```



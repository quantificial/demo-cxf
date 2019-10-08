# demo-cxf

use SoapUI to test

add the WSDL and make request to http://localhost:8000/soap/policyService?wsdl


need to add basic authenication in SoapUI and set the username/password to be, for example, dummy/123456 and use Authenticate pre-emptively


to change xml node name, use @XmlType(propOrder=....

```java
	@WebMethod
	@XmlElement(name="policy")
	PolicyVO getPolicyByPolicyNumber(@WebParam(name = "policyNumber") String policyNumber);
```

to perform date conversion, need to create XmlAdapter and then apply to the field by using @XmlJavaTypeAdapter

to change the order of the xml node, use 

```java
public class DateAdapter extends XmlAdapter<String, Date> {
	
	//private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
	private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");  

    @Override   
    public String marshal(Date v) throws Exception {   
        return dateFormat.format(v);   
    }   
   
    @Override   
    public Date unmarshal(String v) throws Exception {   
        return dateFormat.parse(v);   
    }   

}
```

```java
@Data
@XmlRootElement(name = "policy")  
@XmlAccessorType(XmlAccessType.FIELD) 
@XmlType(propOrder={"issueDate", "policyNumber", "planCode"})
public class PolicyVO {
	
	String policyNumber;
	
	@XmlElement(name="plan")
	String planCode;
	
	@XmlAttribute(name="client")
	String clientID;
	
	@XmlJavaTypeAdapter(DateAdapter.class)  
	Date issueDate;
	
}
```

## Request


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

## Response


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



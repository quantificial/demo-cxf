package cxf.democxf;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


import javax.xml.bind.annotation.XmlAccessType;
import lombok.Data;

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

package cxf.democxf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan 
public class DemoCxfApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoCxfApplication.class, args);
	}

}

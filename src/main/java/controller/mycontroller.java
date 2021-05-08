package controller;

import java.io.File;
import java.util.List;

import model.EmployeeEntity;

import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.impl.DefaultCamelContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import Service.EmployeeService;
import routes.fileroutebuilder;

@RestController
public class mycontroller {
	
	@GetMapping("/spring")
	public ResponseEntity<String> myGetMethod() throws Exception
	{
		CamelContext ctx = new DefaultCamelContext();
		fileroutebuilder routeBuilder = new fileroutebuilder();
		ctx.addRoutes(routeBuilder);
		ctx.start();
		ProducerTemplate template = ctx.createProducerTemplate();
		 File file = new File("C:\\project\\src\\main\\java\\vb.xml");
		String ret = template.requestBody("direct:processOrder", "C:\\project\\src\\main\\java\\vb.xml", String.class);
		System.out.print("ret"+ret);
		return new ResponseEntity<>(ret, HttpStatus.OK);
	}
	
	@GetMapping("/evenodd/{id}")
	public ResponseEntity<String> myProgram(@PathVariable int id) throws Exception
	{
		String result="";
		if(id/2==0)
		{
			result="apka number even hai";
		}else
		{
			result="apka number odd hai";
		}
		
		System.out.print(id);
		return new ResponseEntity<>(""+result, HttpStatus.OK);
		
	}
	
	@Autowired
    EmployeeService service;
 
    @GetMapping("/getEmployee")
    public ResponseEntity<List<EmployeeEntity>> getAllEmployees() {
        List<EmployeeEntity> list = service.getAllEmployees();
        
        System.out.println("hey"+list);
 
        return new ResponseEntity<List<EmployeeEntity>>(list, HttpStatus.OK);
    }
    
    
    
    
    @GetMapping("/getfactorial/{number}")
	public ResponseEntity<String> getfactorial(@PathVariable int number) throws Exception
	{
	  int ans=1;
    	while(number>0)
    	{
    		ans=ans*number;
    		number--;
    	}
    	System.out.println("fact"+ans);
    	
  
		return new ResponseEntity<>(""+ans, HttpStatus.OK);
		
	}
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
	
}
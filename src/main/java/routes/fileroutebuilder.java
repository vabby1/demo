package routes;

import org.apache.camel.builder.RouteBuilder;

import Processor.MyProcessor;

public class fileroutebuilder extends RouteBuilder  {

	@Override
	public void configure() throws Exception {
		// TODO Auto-generated method stub
		 from("direct:processOrder").process(new MyProcessor()).log("your log");
	}

}

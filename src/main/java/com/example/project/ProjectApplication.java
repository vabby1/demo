package com.example.project;

import org.apache.camel.CamelContext;
import org.apache.camel.impl.DefaultCamelContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import routes.fileroutebuilder;

@ComponentScan("./")
@EntityScan("model")
@EnableJpaRepositories("Repository")
@SpringBootApplication
public class ProjectApplication {

	public static void main(String[] args) {
//		fileroutebuilder routeBuilder = new fileroutebuilder();
//		CamelContext ctx = new DefaultCamelContext();
//		try {
//			ctx.addRoutes(routeBuilder);
//			ctx.start();
//		Thread.sleep(5 * 60 * 1000);
//		ctx.stop();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		
		SpringApplication.run(ProjectApplication.class, args);
	}

}

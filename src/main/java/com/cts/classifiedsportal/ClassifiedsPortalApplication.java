package com.cts.classifiedsportal;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
@EnableFeignClients
@Configuration
@EnableAutoConfiguration
@ComponentScan("com")
@SpringBootApplication
public class ClassifiedsPortalApplication extends SpringBootServletInitializer implements ServletContextInitializer{

	public static void main(String[] args) {
		SpringApplication.run(ClassifiedsPortalApplication.class, args);
	}

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		// TODO Auto-generated method stub
		servletContext.getSessionCookieConfig().setName("MySession");
		
	}
	 @Override
	 protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
	  return application.sources(ClassifiedsPortalApplication.class);
	 }

}

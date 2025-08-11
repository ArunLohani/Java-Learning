// ---------------------------------------------
// Main Spring Boot Application
// ---------------------------------------------
package com.example.myApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

/**
 *  @SpringBootApplication = @Configuration + @EnableAutoConfiguration + @ComponentScan
 *  This tells Spring Boot to scan this package (and sub-packages) for components and configs.
 */
@SpringBootApplication
public class MyAppApplication {

	public static void main(String[] args) {

		// Starting Spring Boot application
		// ApplicationContext = Spring IoC Container where all managed beans live
		ApplicationContext context = SpringApplication.run(MyAppApplication.class, args);

		/*
		 * :x: Manual object creation (not managed by Spring):
		 * Dev obj = new Dev();
		 * This creates a plain Java object that Spring does NOT manage — no DI will happen.
		 *
		 * :white_check_mark: Instead, we ask Spring for the bean:
		 * context.getBean(Dev.class);
		 */

		// Asking Spring container to give the 'Dev' bean (already created & dependencies injected)
		Dev obj = context.getBean(Dev.class);

		obj.build();
	}
}
package org.example;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
public class App {
    public static void main(String[] args) {
        // Load the Spring configuration file (spring.xml) from the classpath
        // ClassPathXmlApplicationContext reads bean definitions and creates objects (beans)
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        // Retrieve the 'dev' bean from the Spring container
        // Spring automatically returns an object of type Dev with all dependencies injected
        Dev obj = (Dev) context.getBean("dev");
        // Accessing the 'age' property of the Dev object
        System.out.println(obj.age);
        // Call a method of Dev (this will internally use the Laptop bean)
        obj.build();
        // System.out.println("Hello World!"); // Example of standard output without Spring
    }}
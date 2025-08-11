// ---------------------------------------------
// Developer class - Demonstrates Dependency Injection
// ---------------------------------------------
package com.example.myApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * @Component tells Spring to register this class as a bean in the IoC container.
 * Therefore, Spring will create and manage the object for you.
 */
@Component
public class Dev {

    /*
     * FIELD INJECTION (not recommended generally):
     * Directly injects dependency into the field.
     *
     * @Autowired
     * private Laptop laptop;
     */

    /*
     * SETTER INJECTION:
     * Dependency is injected through setter method.
     *
     * @Autowired
     * public void setLaptop(Laptop laptop) {
     *     this.laptop = laptop;
     * }
     */

    /*
     * CONSTRUCTOR INJECTION (Recommended):
     * Most preferred because the dependency is guaranteed to be initialized.
     * No need for @Autowired if there’s only 1 constructor.
     *
     * public Dev(Laptop laptop) {
     *     this.laptop = laptop;
     * }
     */

    /**
     * Loose Coupling: We depend on the 'Computer' interface, not on a specific class.
     * This allows easy switching between Laptop / Desktop implementations.
     *
     * Ambiguity: If multiple beans implement Computer, 
     * Spring doesn't know which one to inject unless:
     *   1) Remove @Component from unwanted implementation (Not preferred).
     *   2) Mark one implementation as @Primary (only one allowed).
     *   3) Use @Qualifier("beanName") to pick specifically.
     */
    @Autowired
    @Qualifier("laptop") // bean name is usually the lowercase class name unless overridden
    private Computer comp;

    public void build() {
        // Calls compile() of the injected Computer implementation
        comp.compile();
        System.out.println("We are building a Spring Boot Project.");
    }
}
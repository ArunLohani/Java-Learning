// ---------------------------------------------
// Laptop Implementation
// ---------------------------------------------


package com.example.myApp;
import org.springframework.stereotype.Component;
/**
 * @Component registers as a bean with default name "laptop".
 *
 * Can mark @Primary here if you want Laptop to be the default
 * for @Autowired when multiple Computer beans are present.
 */
@Component
public class Laptop implements Computer {
    @Override
    public void compile() {
        System.out.println("Compiled successfully (portable and battery-powered).");
    }
}
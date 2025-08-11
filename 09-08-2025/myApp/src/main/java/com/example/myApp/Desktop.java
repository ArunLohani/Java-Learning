// ---------------------------------------------
// Desktop Implementation
// ---------------------------------------------
package com.example.myApp;

import org.springframework.stereotype.Component;

/**
 * Another implementation of Computer.
 *
 * NOTE: Having both Laptop & Desktop as beans creates ambiguity 
 * unless @Qualifier or @Primary is used.
 */
@Component
public class Desktop implements Computer {

    @Override
    public void compile() {
        System.out.println("Compiled successfully (powerful and fast).");
    }
}
// ---------------------------------------------
// Computer Interface (loose coupling contract)
// ---------------------------------------------
        package com.example.myApp;

/**
 * Interface for a general 'Computer'. 
 * Future implementations can be swapped without changing dependent code.
 */
public interface Computer {
    void compile();
}
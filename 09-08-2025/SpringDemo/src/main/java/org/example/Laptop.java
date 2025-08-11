package org.example;
public class Laptop implements Computer {
    // Default constructor - called when Spring creates Laptop bean
    public Laptop() {
        System.out.println("LAPTOP constructor");
    }
    // Method to simulate compilation
    public void compile() {
        System.out.println("COMPILING IN LAPTOP");
    }
}
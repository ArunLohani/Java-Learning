package org.example;
public class Desktop implements Computer{
    // Default constructor - called when Spring creates Desktop bean
    public Desktop() {
        System.out.println("DESKTOP constructor");
    }
    // Method to simulate compilation
    public void compile() {
        System.out.println("COMPILING IN DESKTOP");
    }
}
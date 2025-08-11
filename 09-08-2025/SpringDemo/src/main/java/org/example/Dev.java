package org.example;
public class Dev {

    private Computer comp;

    public Computer getComp() {
        return comp;
    }

    public void setComp(Computer comp) {
        this.comp = comp;
    }

    // Dependency on another class (Laptop) - Spring will inject this
//    public Laptop laptop;



    // A simple property
    public int age;
    // Setter method for 'age' - used in Setter Injection
    public void setAge(int age) {
        this.age = age;
    }
    // Constructor Injection - Spring can use this to set 'age' during bean creation
    public Dev(int age) {
        this.age = age;
    }
    // Default constructor - will run no matter which injection type is used
    public Dev() {
        System.out.println("DEV Constructor");
    }
    // Getter method for laptop, not necessary for injection but good practice
//    public Laptop getLaptop() {
//        return laptop;
//    }
    // Setter Injection for laptop (property injection)
//    public void setLaptop(Laptop laptop) {
//        this.laptop = laptop;
//    }
    // Some business logic method
    public void build() {
        System.out.println("We are building a Spring Project.");
        // Calling method from the Laptop dependency
//        laptop.compile();

        comp.compile();
    }


}
**Java Learning Notes - 26/07/2025**
**1) Method Overloading**
Definition: Same method name with different parameter lists (type, number, or order).
Return type alone cannot distinguish overloaded methods.
Type promotion happens if no exact parameter match is found.
JVM always calls main(String[] args), but you can overload main with different signatures.
**2) Method Overriding**
Definition: Subclass provides its own implementation of a superclass method.
Method signature (name and parameters) must be the same.
Return type can be covariant (subtype of original return type).
Access modifier must be the same or more accessible.
Cannot override final or static methods.
**3) Interface**
Defines a contract with abstract method signatures that implementing classes must fulfill.
Supports multiple inheritance of types.
Can have default and static methods (Java 8+).
Enables loose coupling and polymorphism.
**4) Dynamic Binding (Runtime Polymorphism)**
Method calls are resolved at runtime based on the actual object type rather than reference type.
Fields/variables are resolved at compile time based on reference type.
Allows overridden methods to exhibit polymorphic behavior.
**5) Abstract Class**
Cannot be instantiated directly.
Contains abstract methods (without body) that subclasses must implement.
Can include concrete methods with default behavior.
Can have final methods which cannot be overridden.
Supports constructors and fields for encapsulation.






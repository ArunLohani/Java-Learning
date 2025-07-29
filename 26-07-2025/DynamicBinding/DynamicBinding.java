
// Base class Bike with a field and a method
class Bike {
    int speedlimit = 90;
    void vroom() {
        System.out.println("Bike go vroooom");
    }
}
// Subclass Honda extends Bike, overrides method and hides the field
class Honda extends Bike {
    int speedlimit = 150;
    @Override
    void vroom() {
        System.out.println("Pulsar go vroooom");
    }
    void applyBreak() {
        System.out.println("Pulsar stops");
    }
}
public class DynamicBinding {
    public static void main(String args[]) {
        // Reference type is Bike (parent), object is Honda (child)
        Bike obj = new Honda();
        // Field access: Java checks the reference type (Bike) first.
        // It finds speedlimit in Bike, so prints 90 (not 150).
        System.out.println(obj.speedlimit); // Output: 90
        // Method call: Java uses dynamic binding for overridden methods.
        // It checks actual object type (Honda), so vroom() in Honda is called.
        obj.vroom(); // Output: Pulsar go vroooom
        // If you try to call obj.applyBreak(); it will cause a compile error,
        // because applyBreak() is not defined in Bike class.
        // Variables are resolved at compile time by reference type,
        // while overridden methods are resolved at runtime by object type.
        // Comment summary:a
        // -> For variables, Java first checks in the parent class.
        //    If found, it will use that value even if a field of same name exists in subclass.
        //    If not found in parent, it throws a compilation error.
        // -> For overridden methods, Java will always use the method in the actual object's class (dynamic binding).

        // Icompatible types: Bike cannot be converted to Honda
// Honda b = new Bike();
    }



}







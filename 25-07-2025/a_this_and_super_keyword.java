
class Parent {

    Parent(){

        this(80,90);
        System.out.println("Parent Class no-parameter constructor is called.");

    }

    Parent(int a , int b){

        System.out.println("Parent class parameterized constructor is called");


    }


}

class Child extends Parent {

    Child(){

//        System.out.println("Child Class no Parameterized Constructor is called"); Error This or super must be in the first line of the constructor.
        this(80);
        System.out.println("Child Class no Parameterized Constructor is called");

    }

    Child(int a){

        super();
//        this();  Error only one of super or this can be called in a constructor
        System.out.println("Child class Parameterized Constructor is called");

    }




}


 class ThisAndSuper {

    public static void main(String[] args) {

        Child c = new Child();

    }
}
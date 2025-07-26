public class MethodOverloading {


    // Method Overloading by changing the number of parameters

     public int add(int a , int b){
         return a + b;
     }

     public int add(int a , int b , int c){
         return a + b + c;
     }




     //Method overloading by changing the type of parameters.
     public double add (double a , double b){
         return a + b;
     }

     //Method overloading cannot be done by changing the return type as java used method name and parameter for method signature and hence ambiguity error will be thrown.
//    public double add(int a , int b){
//         return a+b;
//    }



    //Type Promotion in Method Overloading

//    int promoted to long
    public long multiply (int a , long b){
        System.out.println("LONG MULTIPLY CALLED");
         return a*b;
    }

    public long multiply (long a , int b){

         return a*b;
    }

//    Ambiguity Error in the both multiply function


//    Main Function can be overloaded but the one with String [] args is run by the compiler.
    public static void main(String [] args){

System.out.println("Main function with String[] args");

        MethodOverloading m = new MethodOverloading();
//        System.out.println(m.multiply(20,20));



    }

    public static void main (){


System.out.println("Main function with No args");
    }


    public static void main(String args){

        System.out.println("Main function with String args");
    }

}
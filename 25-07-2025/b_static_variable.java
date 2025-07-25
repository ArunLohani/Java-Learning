

 class StaticParent {

    class InnerStatic {
        static int innerCounter = 100;
    }

    //Static Variable
    static int counter = 0;
    static boolean check = false;

    //Static Final Variable
    static final double PI = 3.1459;


    //Instance Variable
    int instanceVar = 10;

    public void instanceMethod(){

//        Error Static variable cannot be declared inside a non static Function
//        static int localStaticVariable = 10;

        counter+=1;
        instanceVar+=1;

    }

    static public void staticMethod(){

//        Error Static variable cannot be declared inside a static function also
//        static int localStaticVariable = 10;

        counter+=1;

//            Error Local variable cannot be accessed directly inside static variable;
//            instanceVar+=1;

        StaticParent obj = new StaticParent();
        obj.instanceVar+=1;



    }

    public static void main(String[] args) {

        ChildStatic c= new ChildStatic();
        System.out.println("PARENT CLASS COUNTER "+counter);
        System.out.println("INNER CLASS COUNTER "+InnerStatic.innerCounter);


    }
}

class ChildStatic extends StaticParent{

    static int counter = 10;

    ChildStatic(){
        counter++;

        System.out.println("CHILD CLASS COUNTER "+counter);


        System.out.println("CHILD CLASS CHECK "+check);




    }



}
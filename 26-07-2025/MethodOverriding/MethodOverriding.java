class Bank {


    //This cannot be final or static as final method cannot be inherited and static method cannot be overrided.
     long getROI(){
        return 0;
    }


    //The Return type of Non primitve return type methods can be overriden to same return type or its subclass
    Bank covariantReturnTypeExample(){
         return this;
    }

}

class SBI extends Bank{


//    The access modifier of the overriding method must be the same as or less restrictive than the access modifier of the overridden method in the superclass
//    private int getROI(){
//        return 8;
//    }

    @Override
    public long getROI(){
        return 9;
    }

    @Override
    SBI covariantReturnTypeExample(){
        return this;
    }

}


class ICICI extends Bank{


     @Override
    long getROI(){
        return 8;

    }

    @Override
    ICICI covariantReturnTypeExample(){
         return this;
    }

}








public class MethodOverriding {
    public static void main(String[] args) {

        System.out.println(new Bank().covariantReturnTypeExample().getROI());
        System.out.println(new SBI().covariantReturnTypeExample().getROI());
        System.out.println(new ICICI().covariantReturnTypeExample().getROI());

    }
}



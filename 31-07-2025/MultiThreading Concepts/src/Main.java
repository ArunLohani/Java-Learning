
class MyThread extends Thread{


    public void run(){

        for (int i=0;i<10;i++){
            System.out.println(i + " Child Thread");
        }


    }



}

class MyOtherThread extends Thread {

    public void run (){

        System.out.println("No Arg Run Method");

    }

    public void run (int i){

        System.out.println("Parameterized Run Method");

    }



}

class MyNewThread extends Thread{

    public void start(){  // New Thread will not be created as Thread class new Method is not Executing and has been overridden
        System.out.println("Start Method MyNewThread");
    }

    public void run(){
        System.out.println("Run Method MyNewThread");
    }

}


class MyOtherNewThread extends Thread{


    public void start(){
        super.start();
        System.out.println("Start Method MyOtherNewThread" );

    }
    public void run(){
        System.out.println("Run Method MyOtherNewThread");
    }

}

class MyRunnable implements Runnable{

    public void  run(){
        for (int i=0;i<3;i++) System.out.println("Runnable Child Thread");
    }

}

public class Main {
    public static void main(String[] args) {

        MyThread t = new MyThread();

        t.start(); // Main Thread and Thread t will run parallelly

//        t.run(); // Only Main thread will run and a new thread will not be created and
        // the t.run function will work as normal method called by Main thread



        for (int i=0;i<10;i++){
            System.out.println(i + " Main Thread");
        }

        System.out.println();
        System.out.println();



        MyOtherThread ot = new MyOtherThread();
        ot.start(); // No Arg Run Method will be called.

        System.out.println();
        System.out.println();
        System.out.println();

        MyNewThread nt = new MyNewThread();
        nt.start();

        System.out.println();
        System.out.println();
        System.out.println();

        MyOtherNewThread ont = new MyOtherNewThread();
        ont.start(); // Run will be executed by Child thread bcz of super.start() but sout start and sout main will be done by main thread in serial manner
        System.out.println(" Main Thread MyOtherNewThread");


//        ont.start(); Starting a already started thread gives IllegalThreadStateException


        MyRunnable r = new MyRunnable();

        Thread t1 = new Thread(r);

        t1.start();

        for (int i=0;i<3;i++)  System.out.println("Runnable - Main Thread");


        MyThread th1 = new MyThread();

        System.out.println("Initial Thread name : " + th1.getName());

        th1.setName("MyThread-th1");

        System.out.println("Initial Thread name : " + th1.getName());




    }
}
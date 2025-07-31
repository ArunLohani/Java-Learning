
class MyThread extends Thread{


    public void run(){

        for(int i=0;i<3;i++) System.out.println("CHILD THREAD");


    }





}


public class Main {
    public static void main(String[] args) {

        System.out.println("DEFAULT MAIN THREAD PRIORITY " + Thread.currentThread().getPriority());

        MyThread t = new MyThread();

        System.out.println("DEFAULT MYTHREAD PRIORITY " + t.getPriority());

//        t.setPriority(15); // Runtime Exception : IllegalArgumentException
        t.setPriority(10);

        t.start();

        for (int i = 0; i < 3; i++) {
            System.out.println("MAIN THREAD");
        }

    }
}
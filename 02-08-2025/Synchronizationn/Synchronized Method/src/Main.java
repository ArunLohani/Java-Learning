

class Display{



    public synchronized void wish(String name){

        for (int i = 0; i < 10; i++) {

            System.out.print("Good Morning : ");

            try{
                Thread.sleep(2000);
            }
            catch (InterruptedException e){
                System.out.println("Thread got Interrupted");
            }

            System.out.println(name);

        }



    }



}


class SynchronizedThreadDemo extends Thread{

    String name;

    Display d;

    SynchronizedThreadDemo(Display d , String name){
        this.d = d;
        this.name = name;
    }


    @Override
    public void run() {
        d.wish(name);
    }
}

public class Main{

    public static void main(String[] args) {

        Display d = new Display();
        SynchronizedThreadDemo sd = new SynchronizedThreadDemo(d,"Arun");


        SynchronizedThreadDemo s = new SynchronizedThreadDemo(d,"Lohani");

        //Since both thread are working on same display object with wish method not being synchronized
        //the thread will work simultaneously giving chance to each other by sleeping

        //But if wish method is synchronized the thread first acquire the lock on display object
        //will hold lock even on sleeping and other thread will not get the chance to execute wish method
        //untill first thread completed its execution.


        sd.start();
        s.start();



    }


}
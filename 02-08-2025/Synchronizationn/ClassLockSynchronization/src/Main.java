

class Display{


    //Class Level lock
    public static synchronized   void wish(String name){


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

        Display d1 = new Display();
        Display d2 = new Display();
        SynchronizedThreadDemo sd = new SynchronizedThreadDemo(d1,"Arun");
        SynchronizedThreadDemo s = new SynchronizedThreadDemo(d2,"Lohani");


        sd.start();
        s.start();



    }


}
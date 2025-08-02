

class Display{



    public  void wish(String name){
        System.out.println("........ 1 Lakh Line of code ");
        synchronized (this){
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
        System.out.println("........ 1 Lakh Line of code ");

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


        sd.start();
        s.start();



    }


}
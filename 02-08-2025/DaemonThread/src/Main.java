


class DaemonThread extends Thread{




    @Override
    public void run() {
       for (int i=0;i<100;i++){

           System.out.println("Child Thread " + i);

           try{
               Thread.sleep(1000);
           } catch (InterruptedException e) {
               throw new RuntimeException(e);
           }
       }
    }
}

public class Main{

    public static void main(String[] args) {


    DaemonThread d = new DaemonThread();

        System.out.println(d.isDaemon());
    d.setDaemon(true);
    d.start();

        System.out.println("End of Main Thread");




    }


}
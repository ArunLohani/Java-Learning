

class InterThreadCommunication extends Thread{

   public int total = 0;

    @Override
    public void run() {

        synchronized (this){
            System.out.println("Child Thread have started the calculation.");
            for (int i = 0; i <= 100; i++) {
                this.total+=i;
            }

            System.out.println("CHild thread trying to give the notification.");

            this.notify();
        }


    }
}

public class Main{

    public static void main(String[] args) throws InterruptedException {

        InterThreadCommunication itc = new InterThreadCommunication();

        itc.start();

        Thread.sleep(1000);
//        By doing this the program will pause as main thread sleeps the child thread gets the
        // opportunity to execute its work and it is done with its calculation and notify the main thread
        // but after this main thread calls the wait method but there will be no notify method called as child has finished
//        its execution and main will wait infintely.
        // we can solve this by itc.wait(10000)
        synchronized (itc){

            System.out.println("Main Thread trying to call wait method");

            itc.wait();

            System.out.println("Main Thread got the notification.");
            System.out.println(itc.total);
        }



    }


}
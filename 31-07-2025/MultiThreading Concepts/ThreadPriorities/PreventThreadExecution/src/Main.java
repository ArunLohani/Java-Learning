


class ThreadYieldDemo extends Thread{


    public void run(){

        for(int i=0;i<5;i++){
            System.out.println("CHILD THREAD");
            Thread.yield(); //Thread will pause and give chance to other threads of same priority.
        }



    }
}

class ThreadJoinDemo extends Thread  {

    public void run(){

        for (int i=0;i<10;i++){

            System.out.println("CHILD THREAD JOIN");
            try{
                Thread.sleep(2000);

            }
            catch (InterruptedException e){
                System.out.println(e.getMessage());
            }


        }




    }


}

class ThreadJoinDemo2 extends Thread {

    static Thread mt;

    public void run(){

        try {
            mt.join();
        }
        catch (InterruptedException e){
            System.out.println(e.getMessage());
        }
        for (int i=0;i<10;i++){



            System.out.println("CHILD THREAD JOIN 2");



        }



    }




}

public class Main   {

    public static void main (String[] args) throws InterruptedException{

        ThreadJoinDemo2.mt = Thread.currentThread();
        ThreadYieldDemo y = new ThreadYieldDemo();
        y.start();

        for (int i=0;i<5;i++){
            System.out.println("MAIN THREAD");
        }

        ThreadJoinDemo j = new ThreadJoinDemo();
        j.start();
//        j.join(); Main Thread will wait until j is completed
        j.join(10000);
        for (int i= 0;i<10;i++){
            System.out.println("MAIN THREAD JOIN");
        }

        System.out.println();
        System.out.println();
        System.out.println();



        ThreadJoinDemo2 j2 = new ThreadJoinDemo2();

        j2.start();

        for(int i=0;i<10;i++){
            System.out.println("MAIN THREAD JOIN2");
            try{
                Thread.sleep(2000);

            }
            catch (InterruptedException e){
                System.out.println(e.getMessage());
            }

        }


    }
}
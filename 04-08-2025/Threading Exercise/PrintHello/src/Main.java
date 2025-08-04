

class MyThread extends Thread{

    @Override
    public void run() {
        System.out.println("Hello World!!!");
    }
}

public class Main {

    public static void main(String[] args) {

        MyThread t = new MyThread();
        t.start();


    }
}
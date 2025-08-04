

class PrintNumber {

    public synchronized void print(int i){

        for (int j = i; j <=20 ; j+=2) {

            System.out.println(j);
        }

    }


}


class EvenThread extends Thread{

    PrintNumber p;

    EvenThread(PrintNumber p){
        this.p = p;
    }

    @Override
    public void run() {
        p.print(0);
    }
}

class OddThread extends Thread{

    PrintNumber p;

    OddThread(PrintNumber p){
        this.p = p;
    }

    @Override
    public void run() {
        p.print(1);
    }
}


public  class Main {
    public static void main(String[] args) {

        PrintNumber p =new PrintNumber();

        EvenThread e = new EvenThread(p);
        OddThread o = new OddThread(p);

        e.start();
        o.start();





    }
}
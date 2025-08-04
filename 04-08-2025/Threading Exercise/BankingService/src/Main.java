

class BankingService {

    private double balance = 0;

    public synchronized void deposit(double amount){

        System.out.println("Deposit Amount : " + amount);
        this.balance +=amount;

        System.out.println("Balance after deposit : " + this.balance);



    }

    public synchronized void withdraw(double amount){

        System.out.println("Withdrawal Amount : " + amount);

        if(amount > this.balance){
            System.out.println("Not enough Balance aval.");
            return;
        }

        this.balance-=amount;

        System.out.println("Balance after withdrawal : " + this.balance);



    }



}





public class Main{
    public static void main(String[] args) {

        BankingService account = new BankingService();
        Thread gpay = new Thread(() -> account.deposit(1000));
        Thread paytm = new Thread(() -> account.deposit(300));
        Thread phonePay = new Thread(() -> account.withdraw(150));
        Thread cred = new Thread(() -> account.withdraw(1200));
        gpay.start();
        paytm.start();
        phonePay.start();
        cred.start();



    }
}
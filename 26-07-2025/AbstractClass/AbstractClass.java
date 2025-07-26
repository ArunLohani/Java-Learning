
public class AbstractClass{
    public static void main(String[] args) {


        Vechile kia = new Car("Kia",2020,4);
        Vechile apache = new Bike("Apache",2023,5);

        kia.displayInfo();
        kia.startEngine();
        kia.stopEngine();
        

        apache.displayInfo();
        apache.startEngine();
        apache.stopEngine();


        
    }
}
abstract  class Vechile{

    private String brand;
    private int year;

    public Vechile(String brand , int year) {

        this.year = year;
        this.brand = brand;

    }

    public abstract void startEngine();
    public abstract void stopEngine();

    public void displayInfo(){
        System.out.println("Brand " + this.brand + " Year " + this.year);

    }

    public final void horn(){
        System.out.println("Beep Beep!!!");
    }

    public final String getBrand(){
        return brand;
    }

    public final int getYear(){
        return year;
    }
    


}

class Car extends Vechile {

private int seats;


Car(String brand , int year , int seats){
    super(brand,year);
    this.seats = seats;
}

public void startEngine(){
    System.out.println("Car " + this.getBrand()+"-"+this.getYear()+"-"+this.seats + " seats is starting...");
}

public void stopEngine(){
    System.out.println("Car " + this.getBrand()+"-"+this.getYear()+"-"+this.seats + " seats is stoping...");
}






}

class Bike extends Vechile {

private int gears;


Bike(String brand , int year , int gears){
    super(brand,year);
    this.gears = gears;
}


public void startEngine(){
    System.out.println("Car " + this.getBrand()+"-"+this.getYear()+"-"+this.gears + " gears is starting...");
}

public void stopEngine(){
    System.out.println("Car " + this.getBrand()+"-"+this.getYear()+"-"+this.gears + " gears is stoping...");
}






}




public class OddNumberException extends Exception {

    private int number;

    OddNumberException(int number){
        this.number = number;
    }


    public int getNumber(){
        return this.number;
    }




}
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {


    public static void checkEvenNumber(int number) {

        try{

            if((number & 1) == 1) throw new OddNumberException(number);

            System.out.println("Bravo!! Your Number is Even.");

        }
        catch (Exception e){

            System.out.println("Oops !! Your Number is Odd.");

        }



    }

    public static void openFile(String fileName){

        File file = new File(fileName);

        try{
            if(file.exists()){
                System.out.println("Your File exists.");
                return;
            }

            throw new FileNotFoundException();

        }
        catch (FileNotFoundException e){
            System.out.println("File does not exists.");
        }

    }

    public static void checkNegativeInteger(int number) throws IllegalArgumentException {

        if(number >= 0) {

            System.out.println("Oh No !!! Number is Positive or Zero.");
            throw new IllegalArgumentException("Number is Positive or Zero");
        }
        else System.out.println(" Yahoo !! Number is Negative!!!");


    }


    public static void printNegativeInteger(int number){

        try{

            checkNegativeInteger(number);

        }
        catch (IllegalArgumentException e){
            System.out.println("getMessage" + e.getMessage());
            System.out.println("getCause" +e.getCause());
            System.out.println("getClass" +e.getClass());
            System.out.println("getStackTrace" +e.getStackTrace());
            System.out.println("getLocalizedMessage" +e.getLocalizedMessage());

        }


    }

    public static void main(String[] args) {

        System.out.println("Enter an even Number : ");
        int number;
        Scanner sc = new Scanner(System.in);
        number = sc.nextInt();
        checkEvenNumber(number);
        System.out.println("Enter file name");
        String fileName = sc.next();

        openFile(fileName);

        System.out.println("Enter a Negative Number : ");

        number = sc.nextInt();
        printNegativeInteger(number);

    }
}
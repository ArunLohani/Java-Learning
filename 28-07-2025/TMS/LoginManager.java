import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class LoginManager {

    public static RegularAuthor loginRegularAuthor(){

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Your ID : ");
        String authorId = sc.nextLine();

        System.out.println("Enter Your password : ");
        String password = sc.nextLine();

        String fileName = "Authors/"+authorId + ".txt";
        RegularAuthor user = null;
        try(BufferedReader br = new BufferedReader(new FileReader(fileName))){

            String line = null;
            while((line = br.readLine())!=null){

                if(line.startsWith("Author_Type")){

                    String type = line.split(": ")[1];

                    if(type.equals("Regular")){
                        user = RegularAuthor.loadFromFile("Authors/"+authorId+".txt");
                    }else{
                        System.out.println("User not found. Please try again.");
                        break;

                    }

                } else if (line.startsWith("Password")) {

                    String pass = line.split(": ")[1];

                    if(pass.equals(password) == false){
                        System.out.println("Wrong Password. Please try again.");
                        break;
                    }



                }


            }





        }
        catch (IOException e){

            System.out.println("User not found. Please try again.");

        }

        System.out.println("Login Successfull. Welcome Back " + user.name + "." );

            System.out.println("You can view your personal and work Tasks.");

        return user;


    }

    public static BossAuthor loginBossAuthor(){

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Your ID : ");
        String authorId = sc.nextLine();

        System.out.println("Enter Your password : ");
        String password = sc.nextLine();

        String fileName = "Authors/"+authorId + ".txt";
        BossAuthor user = null;
        try(BufferedReader br = new BufferedReader(new FileReader(fileName))){

            String line = null;
            while((line = br.readLine())!=null){

                if(line.startsWith("Author_Type")){

                    String type = line.split(": ")[1];

                    if(type.equals("Boss")){
                        user = BossAuthor.loadFromFile("Authors/"+authorId+".txt");
                    }else{
                        System.out.println("User not found. Please try again.");
                        break;

                    }

                } else if (line.startsWith("Password")) {

                    String pass = line.split(": ")[1];

                    if(pass.equals(password) == false){
                        System.out.println("Wrong Password. Please try again.");
                        break;
                    }



                }


            }





        }
        catch (IOException e){

            System.out.println("User not found. Please try again.");

        }

        System.out.println("Login Successfull. Welcome Back " + user.name + "." );


            System.out.println("You can manage your company.");

        return user;


    }


}

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Company implements Storable   {

    static int companyCount=readCompanyCount();
    protected String companyId;
    protected List<Author> employees;
    protected String companyName;
    protected BossAuthor owner;

    Company(String name,BossAuthor owner){

        this.companyName = name;
        companyCount++;
        this.companyId = "C-"+companyCount;
        this.owner = owner;
        employees = new ArrayList<>();

    }

    void viewCompanyTasks(){
        for(Author a : employees){
            a.viewWorkTasks();
        }
        owner.viewWorkTasks();
    }

    void displayCompanyInfo(){
        System.out.println("Company ID :- " + companyId);
        System.out.println("CompanyName :- " + companyName);
        System.out.println("Owner " + owner.name);
        System.out.println("--------------EMPLOYEES---------------");
        for(Author a : employees)

        {        System.out.println();
            a.displayAuthorInfo();

        }

        System.out.println("--------------**********---------------");

    }


    public static int readCompanyCount() {

        try (BufferedReader br = new BufferedReader(
                new FileReader("Companies/CompanyCount.txt"))) {

            String line = br.readLine();

            if (line.startsWith("CompanyCount:")) {
                return Integer.parseInt(line.split(": ")[1]);


            }
            else return 0;


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void writeCompanyCount(){

        try(BufferedWriter br = new BufferedWriter(new FileWriter("Companies/CompanyCount.txt"))){

            br.write("CompanyCount: " + companyCount);

            br.flush();

        }
        catch (IOException e){

            e.printStackTrace();

        }



    }



    @Override
    public  void readFromFile(String fileName){
        try(BufferedReader br = new BufferedReader(new FileReader(fileName))){

            String line;

            while((line = br.readLine())!=null){

                if(line.startsWith("Company_Name:")){
                    this.companyName = line.split(": ")[1];

                }

                else if(line.startsWith("Company_id:")){
                    this.companyId = line.split(": ")[1];

                }
                else if(line.startsWith("Company_id:")){
                    this.companyId = line.split(": ")[1];

                }
                else if(line.startsWith("Owner:")){

                    String authorId = line.split(": ")[1];


                            BossAuthor owner =    BossAuthor.loadFromFile("Authors/"+authorId +".txt");
                            this.owner = owner;

                }
                else if(line.startsWith("Employees:")){
                    String authorFileName = "Authors/";
                    while((line = br.readLine())!=null){

                        String authorId = line;

                        try(BufferedReader br2 =
                                    new BufferedReader
                                            (new FileReader(authorFileName + authorId + ".txt"))
                        )
                        {
                            String newLine;
                            newLine = br2.readLine();
                            String authorType = newLine.split(": ")[1];

                            if(authorType.equals("Regular")){

                                RegularAuthor task =    RegularAuthor.loadFromFile("Authors/"+authorId +".txt");
                                employees.add(task);
                            }
                            else {

                                BossAuthor task =    BossAuthor.loadFromFile("Authors/"+authorId +".txt");
                                employees.add(task);
                            }

                        }
                        catch (IOException e){
                            e.printStackTrace();
                        }


                    }



                }


            }

        }
        catch (IOException e){

            e.printStackTrace();

        }



    }

    @Override
    public void writeToFile(String fileName)  {

        try(BufferedWriter br = new BufferedWriter(new FileWriter(fileName))){
            br.write("Company_Name: " + this.companyName);
            br.write("\nCompany_id: " + this.companyId);
            br.write("\nOwner: "+owner.authorId);
            br.write("\nEmployees: ");
            for (Author t : employees ){
                br.write("\n"+ t.authorId);
            }

            br.flush();

        }
        catch (IOException e){

            e.printStackTrace();

        }




    }

    public static Company loadFromFile(String fileName){

        Company company = new Company("",null);
        company.readFromFile(fileName);

        return company;


    }

    public void addEmployeeToCompany(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Author Id you want to Employee:");
        String authorId = sc.nextLine();

        RegularAuthor author =    RegularAuthor.loadFromFile("Authors/"+authorId+".txt");

        author.companyId = this.companyId;
        this.employees.add(author);
        author.writeToFile("Authors/"+authorId+".txt");
        this.writeToFile("Companies/"+this.companyId+".txt");


    }


}

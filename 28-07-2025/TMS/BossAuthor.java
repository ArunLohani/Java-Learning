import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class BossAuthor extends Author implements Storable{

    BossAuthor(String name,String password){
        super(name,password);
    }

    @Override
    void displayAuthorInfo() {
        System.out.println("Name :- " + name);

        System.out.println("Owner of Company :- " + companyId);
        System.out.println();
        System.out.println("Personal Tasks : ");
        this.viewPersonalTasks();

        System.out.println();
        System.out.println("Work Tasks : ");
        this.viewWorkTasks();
    }



    @Override
    public  void readFromFile(String fileName){
        try(BufferedReader br = new BufferedReader(new FileReader(fileName))){

            String line;

            while((line = br.readLine())!=null){

                if(line.startsWith("Name:")){
                    this.name = line.split(": ")[1];

                }

                else if(line.startsWith("Author_id:")){
                    this.authorId = line.split(": ")[1];

                }

                else if(line.startsWith("Password:")){
                    this.password = line.split(": ")[1];

                }
                else if(line.startsWith("Company_id:")){
                    this.companyId = line.split(": ")[1];

                }
                else if(line.startsWith("Tasks:")){
                    String taskFileName = "Tasks/";
                    while((line = br.readLine())!=null){

                        String TaskId = line;

                        try(BufferedReader br2 =
                                    new BufferedReader
                                            (new FileReader(taskFileName + TaskId + ".txt"))
                        )
                        {
                            String newLine;
                            newLine = br2.readLine();
                            String taskType = newLine.split(": ")[1];

                            if(taskType.equals("PersonalTask")){

                                PersonalTask task =    PersonalTask.loadFromFile("Tasks/"+TaskId +".txt");
                                authorTasks.add(task);
                            }
                            else {

                                WorkTask task =  WorkTask.loadFromFile("Tasks/"+TaskId +".txt");
                                authorTasks.add(task);
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


    public void createCompany(){

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Company Name : ");
        String name = sc.nextLine();

        Company company =    new Company(name,this);
        Company.companyCount++;
        companyId = company.companyId;
        company.writeToFile("Companies/"+company.companyId +".txt");


       Company.writeCompanyCount();



    }

    @Override
    public void writeToFile(String fileName)  {

        try(BufferedWriter br = new BufferedWriter(new FileWriter(fileName))){
            br.write("Author_Type: " + "Boss");
            br.write("\nAuthor_id: " + this.authorId);
            br.write("\nName: " + this.name);
            br.write("\nPassword: " + this.password);
            br.write("\nCompany_id: " + this.companyId);
            br.write("\nTasks: ");
            for (Task t : authorTasks ){
                br.write("\n"+ t.task_id);
            }
            br.flush();

        }
        catch (IOException e){

            e.printStackTrace();

        }




    }


    @Override
    void createPersonalTask(String assignee) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Task Title : ");
        String title = sc.nextLine();
        System.out.println("Enter Task Description : ");
        String desc = sc.nextLine();
        System.out.print("Enter due date (e.g., YYYY-MM-DD): ");
        String dateString = sc.nextLine();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate dueDate = LocalDate.parse(dateString, formatter);
        PersonalTask task =    new PersonalTask(title,desc,assignee,dueDate);
        Task.taskCounter++;
        Task.writeTaskCounter();
        task.writeToFile("Tasks/"+task.task_id +".txt");

        authorTasks.add(task);
        this.writeToFile("Authors/"+this.authorId+".txt");

    }

    @Override
    void createWorkTask(String assigner, String companyId) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Task Title : ");
        String title = sc.nextLine();
        System.out.println("Enter Task Description : ");
        String desc = sc.nextLine();
        System.out.print("Enter due date (e.g., YYYY-MM-DD): ");
        String dateString = sc.nextLine();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate dueDate = LocalDate.parse(dateString, formatter);
        System.out.println("Enter Task Assignee : ");
        String assignee = sc.nextLine();


        WorkTask task =  new WorkTask(title,desc,assigner,dueDate,assignee,companyId);
        Task.taskCounter++;
        Task.writeTaskCounter();
        task.writeToFile("Tasks/"+task.task_id +".txt");




        authorTasks.add(task);
        this.writeToFile("Authors/"+this.authorId+".txt");

    }

    public static BossAuthor createBossAuthor(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Your Name : ");
        String name = sc.nextLine();
        System.out.println("Enter Your Password : ");
        String password = sc.nextLine();
        BossAuthor author = new BossAuthor(name,password);
        authorCount++;
        Author.writeAuthorCounter();
        author.writeToFile("Authors/"+author.authorId+".txt");

        return author;

    }

    public static BossAuthor loadFromFile(String fileName){

        BossAuthor author = new BossAuthor("","");

        author.readFromFile(fileName);

        return author;


    }
}

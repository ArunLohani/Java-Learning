import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class RegularAuthor extends Author implements Storable  {

    RegularAuthor(String name,String password){
        super(name,password);
    }




    @Override
    void displayAuthorInfo() {
        System.out.println("Name :- " + name);

        System.out.println("Works in Company :- " + companyId);
        System.out.println();
        System.out.println("Personal Tasks : ");
        this.viewPersonalTasks();

        System.out.println();
        System.out.println("Work Tasks : ");
        this.viewWorkTasks();



    }

    public static RegularAuthor createRegularAuthor(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Your Name : ");
        String name = sc.nextLine();

        System.out.println("Enter Your password : ");
        String password = sc.nextLine();

        RegularAuthor author = new RegularAuthor(name,password);
        authorCount++;
        Author.writeAuthorCounter();
        author.writeToFile("Authors/"+author.authorId+".txt");

        return author;

    }

    @Override
    public void readFromFile(String fileName){
        try(BufferedReader br = new BufferedReader(new FileReader(fileName))){

            String line;

            while((line = br.readLine())!=null){

                if(line.startsWith("Name:")){
                    this.name = line.split(": ")[1];

                }

               else if(line.startsWith("Author_Type:")){


                }
                else if(line.startsWith("Password:")){
                this.password = line.split(": ")[1];

                }

                else if(line.startsWith("Author_id:")){
                    this.authorId = line.split(": ")[1];

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

    @Override
    public void writeToFile(String fileName)  {

        try(BufferedWriter br = new BufferedWriter(new FileWriter(fileName))){
            br.write("Author_Type: " + "Regular");
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

    public static RegularAuthor loadFromFile(String fileName){

        RegularAuthor author = new RegularAuthor("","");

        author.readFromFile(fileName);

        return author;


    }
}

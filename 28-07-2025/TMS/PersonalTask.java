import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class PersonalTask extends Task implements Storable {


    PersonalTask(String title, String desc, String assignedBy, LocalDate dueDate){

        super(title,desc,assignedBy,dueDate);
        this.assignedTo = assignedBy;
    }

    @Override

    void displayTaskInfo(){
        System.out.println("Title :- " + title);
        System.out.println("Desc :- " + desc);
        System.out.println("Status :- " + status);

        DateTimeFormatter dateformatter
                = DateTimeFormatter.ofPattern("MM dd, YYYY");
        System.out.println("Due Date :- " + dateformatter.format(dueDate));


    }

    @Override
    void updateTaskStatus() {

        Scanner sc = new Scanner(System.in);
        for(Status s : Status.values()){
            System.out.println(s);
        }

        System.out.println("Enter Your Task Status : ");
        String status = sc.nextLine();
        this.status = Status.valueOf(status.toUpperCase());


        this.writeToFile("Tasks/"+this.task_id +".txt");
    }

    @Override
    void editTask() {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Task Title : ");
        String title = sc.nextLine();
        System.out.println("Enter Task Description : ");
        String desc = sc.nextLine();
        System.out.print("Enter due date (e.g., YYYY-MM-DD): ");
        String dateString = sc.nextLine();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate dueDate = LocalDate.parse(dateString, formatter);

        this.title = title;
        this.desc = desc;
        this.dueDate = dueDate;

        this.writeToFile("Tasks/"+this.task_id +".txt");
    }


    @Override
  public  void readFromFile(String fileName){
        try(BufferedReader br = new BufferedReader(new FileReader(fileName))){

            String line;

            while((line = br.readLine())!=null){

                if(line.startsWith("Author_id:")){
                    this.assignedTo = line.split(": ")[1];
                    this.assignedBy = this.assignedTo;
                }

                else if(line.startsWith("Title:")){
                    this.title = line.split(": ")[1];

                }
               else if(line.startsWith("Task_id:")){
                    this.task_id = line.split(": ")[1];

                }
               else if(line.startsWith("Due Date:")){
                    this.dueDate = LocalDate.parse(line.split(": ")[1]);

                }
               else if(line.startsWith("Status:")){
                    this.status = Status.valueOf(line.split(": ")[1]);

                }
               else if(line.startsWith("Desc:")){
                    this.desc = line.split(": ")[1];

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
            br.write("Task_Type: " + "PersonalTask");
            br.write("\nTask_id: " + this.task_id);
            br.write("\nTitle: " + this.title);
            br.write("\nDesc: " + this.desc);
            br.write("\nStatus: " + this.status);
            br.write("\nDue Date: " + this.dueDate);
            br.write("\nAuthor_id: " + this.assignedTo);


        }
        catch (IOException e){

            e.printStackTrace();

        }



    }

    public static PersonalTask loadFromFile(String fileName){

        PersonalTask task = new PersonalTask("","","",LocalDate.now());

        task.readFromFile(fileName);

        return task;


    }
}

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public abstract class Author implements Storable {

    static int authorCount = readAuthorCounter();
    protected String authorId;
    protected String companyId;
    protected List<Task> authorTasks;
    protected String name;
    protected String password;


    Author(String name,String password){

        this.name = name;
        this.authorId = "A-" + authorCount;
        authorTasks = new ArrayList<>();
        companyId = "NA";
        this.password = password;

    }


    HashMap<Integer,String > displayTasksList(){

        System.out.println("Select a Task on which you want to perform the operation.");
        Integer count = 1;
        HashMap<Integer,String> stepToTaskMap = new HashMap<>();
        for(Task t : authorTasks){


                stepToTaskMap.put(count , t.task_id);
                System.out.println(count++ + ". " +  t.task_id + " " + t.title);




        }

        return stepToTaskMap;



    }


    HashMap<Integer,String > displayPersonalTasksList(){

        System.out.println("Select a Task on which you want to perform the operation.");
        Integer count = 1;
        HashMap<Integer,String> stepToTaskMap = new HashMap<>();
        for(Task t : authorTasks){

            if(t instanceof PersonalTask) {
                stepToTaskMap.put(count, t.task_id);
                System.out.println(count++ + ". " + t.task_id + " " + t.title);

            }


        }

        return stepToTaskMap;



    }

    HashMap<Integer,String > displayWorkTasksList(){

        System.out.println("Select a Task on which you want to perform the operation.");
        Integer count = 1;
        HashMap<Integer,String> stepToTaskMap = new HashMap<>();
        for(Task t : authorTasks){

            if(t instanceof WorkTask) {
                stepToTaskMap.put(count, t.task_id);
                System.out.println(count++ + ". " + t.task_id + " " + t.title);

            }


        }

        return stepToTaskMap;



    }

    void  viewPersonalTasks(){

        boolean check = true;

        for(Task t : authorTasks){

            if(t instanceof PersonalTask){
                t.displayTaskInfo();
                System.out.println("----------------");
                check = false;
            }


        }

            if(check){

                System.out.println("No Personal Tasks assigned yet.");


            }



    }

    void viewWorkTasks(){

        boolean check = true;
        for(Task t : authorTasks){

            if(t instanceof WorkTask){
                t.displayTaskInfo();
                System.out.println("----------------");
                check = false;
            }



        }

        if(check){

            System.out.println("No Work Tasks assigned yet.");


        }



    }

    abstract void displayAuthorInfo();

    public static int readAuthorCounter() {

        try (BufferedReader br = new BufferedReader(
                new FileReader("Authors/AuthorCount.txt"))) {

            String line = br.readLine();

            if (line.startsWith("AuthorCount:")) {
                return Integer.parseInt(line.split(": ")[1]);


            }
            else return 0;


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void writeAuthorCounter(){

        try(BufferedWriter br = new BufferedWriter(new FileWriter("Authors/AuthorCount.txt"))){

            br.write("AuthorCount: " + authorCount);
            br.flush();


        }
        catch (IOException e){

            e.printStackTrace();

        }



    }

   abstract void createPersonalTask(String assignee);

     void deleteRegularTask(String task_id)throws IOException{

        String filePath = "Tasks/" + task_id+".txt"; // Replace with the actual file path
        File file = new File(filePath);

        PersonalTask t = new PersonalTask("","","",null);
        t.readFromFile(filePath);

            if (file.delete()) {

                this.authorTasks.remove(t);
                this.writeToFile("Authors/"+this.authorId+".txt");
                System.out.println("Task deleted successfully.");
            } else {
                System.out.println("Failed to delete the Task. It might not exist or there are permission issues.");
            }





    }

    void deleteWorkTask(String task_id)throws IOException{

        String filePath = "Tasks/" + task_id+".txt"; // Replace with the actual file path
        File file = new File(filePath);

        WorkTask t = new WorkTask("","","",null,"","");
        t.readFromFile(filePath);

        if (file.delete()) {

            this.authorTasks.remove(t);
            this.writeToFile("Authors/"+this.authorId+".txt");
            System.out.println("Task deleted successfully.");
        } else {
            System.out.println("Failed to delete the Task. It might not exist or there are permission issues.");
        }





    }

  abstract   void createWorkTask(String assigner,String companyId);







}

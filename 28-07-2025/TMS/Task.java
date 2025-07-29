import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
abstract class Task{


    static int taskCounter = readTaskCounter();

    protected String task_id;
    protected String assignedTo;
    protected Status status;
    protected String desc;
    protected String title;
    protected String assignedBy;
    protected LocalDate dueDate;

    Task(String title , String desc , String assignedBy,LocalDate dueDate){




//        taskCounter++;
        this.task_id = "T-" + taskCounter;
        this.title=title;
        this.desc=desc;
        this.assignedBy = assignedBy;
        this.status = Status.NEW;
        this.dueDate = dueDate;
    }


    public static int readTaskCounter() {

        try (BufferedReader br = new BufferedReader(
                new FileReader("Tasks/TaskCount.txt"))) {

            String line = br.readLine();

            if (line.startsWith("TaskCount:")) {
                return Integer.parseInt(line.split(": ")[1]);


            }
            else return 0;


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void writeTaskCounter(){

        try(BufferedWriter br = new BufferedWriter(new FileWriter("Tasks/TaskCount.txt"))){

            br.write("TaskCount: " + taskCounter);
            br.flush();



        }
        catch (IOException e){

            e.printStackTrace();

        }



    }

    abstract   void displayTaskInfo();

  abstract   void updateTaskStatus();

  abstract void editTask();




}
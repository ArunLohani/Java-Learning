import java.io.IOException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) throws IOException {

        boolean flag = true;

        Scanner sc = new Scanner(System.in);

        System.out.println("--------------------------TASK MANAGEMENT SYSTEM-----------------------------");

        while(flag){

            System.out.println("1. Login as Regular");
            System.out.println("2. Login as Boss");
            System.out.println("3. Register as Regular User");
            System.out.println("4. Register as Boss User");
            System.out.println("5. Exit");
            System.out.println();
            System.out.println("Enter your choice : ");

            int userChoice = sc.nextInt();

            switch(userChoice){

                case 1 :
                    RegularAuthor regularUser = LoginManager.loginRegularAuthor();

                    boolean regularFlag = true;

                    while(regularFlag){

                        System.out.println("1. Create a Personal Task");
                        System.out.println("2. Create a Work Task");
                        System.out.println("3. View all Personal Task");
                        System.out.println("4. View all Work Task");
                        System.out.println("5. Edit a Personal Task");
                        System.out.println("6. Update Personal Task Status");
                        System.out.println("7. Edit a Work Task");
                        System.out.println("8. Update Work Task Status");
                        System.out.println("9. Delete a Task");
                        System.out.println("10. View Your Profile");
                        System.out.println("11. Logout");
                        System.out.println();
                        System.out.println("Enter your choice : ");
                        int regularUserChoice = sc.nextInt();

                        switch(regularUserChoice){

                            case 1:
                                regularUser.createPersonalTask(regularUser.authorId);
                                break;
                            case 2:
                                if(regularUser.companyId.equals("NA")) {
                                    System.out.println("You are not associated with any company.");
                                }
                                else{
                                    regularUser.createWorkTask(regularUser.authorId,regularUser.companyId );
                                }
                                break;
                            case 3:
                                regularUser.viewPersonalTasks();
                                break;
                            case 4:
                                regularUser.viewWorkTasks();
                                break;
                            case 5 :
                                HashMap<Integer,String> stepToTaskMap = regularUser.displayPersonalTasksList();

                                System.out.println("Enter Your choice : ");
                                Integer step = sc.nextInt();
                                String taskId = stepToTaskMap.get(step);
                                PersonalTask task = PersonalTask.loadFromFile("Tasks/" + taskId + ".txt");
                                task.editTask();

                                break;
                            case 6:
                                HashMap<Integer,String> stepToTask2Map = regularUser.displayPersonalTasksList();

                                System.out.println("Enter Your choice : ");
                                Integer step2 = sc.nextInt();
                                String taskId2 = stepToTask2Map.get(step2);
                                PersonalTask task2 = PersonalTask.loadFromFile("Tasks/" + taskId2 + ".txt");
                                task2.updateTaskStatus();

                                break;
                            case 7 :
                                HashMap<Integer,String> stepToTask3Map = regularUser.displayWorkTasksList();

                                System.out.println("Enter Your choice : ");
                                Integer step3 = sc.nextInt();
                                String taskId3 = stepToTask3Map.get(step3);
                                WorkTask task3 = WorkTask.loadFromFile("Tasks/" + taskId3 + ".txt");
                                task3.editTask();

                                break;
                            case 8:
                                HashMap<Integer,String> stepToTask4Map = regularUser.displayWorkTasksList();

                                System.out.println("Enter Your choice : ");
                                Integer step4 = sc.nextInt();
                                String taskId4 = stepToTask4Map.get(step4);
                                WorkTask task4 = WorkTask.loadFromFile("Tasks/" + taskId4 + ".txt");
                                task4.updateTaskStatus();

                                break;

                            case 9:
                                HashMap<Integer,String> stepToTask5Map = regularUser.displayTasksList();

                                System.out.println("Enter Your choice : ");
                                Integer step5 = sc.nextInt();
                                String taskId5 = stepToTask5Map.get(step5);

                                regularUser.deleteRegularTask(taskId5);

                                break;
                            case 10:
                                regularUser.displayAuthorInfo();
                                break;
                            case 11 :
                                regularFlag = false;
                                break;

                        }


                    }


                   break;

                case 2 :
                    BossAuthor bossUser = LoginManager.loginBossAuthor();
                    boolean bossFlag = true;

                    while(bossFlag){

                        System.out.println("1. Create a Personal Task");
                        System.out.println("2. Create a Work Task");
                        System.out.println("3. View all Personal Task");
                        System.out.println("4. View all Work Task");
                        System.out.println("5. Edit a Personal Task");
                        System.out.println("6. Update Personal Task Status");
                        System.out.println("7. Edit a Work Task");
                        System.out.println("8. Update Work Task Status");
                        System.out.println("9. Delete a Task");
                        System.out.println("10. View Your Profile");
                        System.out.println("11. Create a Company");
                        System.out.println("12. View your Company");
                        System.out.println("13. View your Company's Tasks");
                        System.out.println("14. Add Employee to your Company.");
                        System.out.println("15. Logout");
                        System.out.println();
                        System.out.println("Enter your choice : ");
                        int bossUserChoice = sc.nextInt();

                        switch(bossUserChoice){

                            case 1:
                                bossUser.createPersonalTask(bossUser.authorId);
                                break;
                            case 2:
                                if(bossUser.companyId.equals("NA")) {
                                    System.out.println("You are not associated with any company.");
                                }
                                else{
                                    bossUser.createWorkTask(bossUser.authorId,bossUser.companyId );
                                }
                                break;
                            case 3:
                                bossUser.viewPersonalTasks();
                                break;
                            case 4:
                                bossUser.viewWorkTasks();
                                break;
                            case 5 :
                                HashMap<Integer,String> stepToTaskMap = bossUser.displayPersonalTasksList();

                                System.out.println("Enter Your choice : ");
                                Integer step = sc.nextInt();
                                String taskId = stepToTaskMap.get(step);
                                PersonalTask task = PersonalTask.loadFromFile("Tasks/" + taskId + ".txt");
                                task.editTask();

                                break;
                            case 6:
                                HashMap<Integer,String> stepToTask2Map = bossUser.displayPersonalTasksList();

                                System.out.println("Enter Your choice : ");
                                Integer step2 = sc.nextInt();
                                String taskId2 = stepToTask2Map.get(step2);
                                PersonalTask task2 = PersonalTask.loadFromFile("Tasks/" + taskId2 + ".txt");
                                task2.updateTaskStatus();

                                break;
                            case 7 :
                                HashMap<Integer,String> stepToTask3Map = bossUser.displayWorkTasksList();

                                System.out.println("Enter Your choice : ");
                                Integer step3 = sc.nextInt();
                                String taskId3 = stepToTask3Map.get(step3);
                                WorkTask task3 = WorkTask.loadFromFile("Tasks/" + taskId3 + ".txt");
                                task3.editTask();

                                break;
                            case 8:
                                HashMap<Integer,String> stepToTask4Map = bossUser.displayWorkTasksList();

                                System.out.println("Enter Your choice : ");
                                Integer step4 = sc.nextInt();
                                String taskId4 = stepToTask4Map.get(step4);
                                WorkTask task4 = WorkTask.loadFromFile("Tasks/" + taskId4 + ".txt");
                                task4.updateTaskStatus();

                                break;

                            case 9:
                                HashMap<Integer,String> stepToTask5Map = bossUser.displayTasksList();

                                System.out.println("Enter Your choice : ");
                                Integer step5 = sc.nextInt();
                                String taskId5 = stepToTask5Map.get(step5);

                                bossUser.deleteRegularTask(taskId5);

                                break;
                            case 10:
                                bossUser.displayAuthorInfo();
                                break;

                            case 11:
                                if(bossUser.companyId.equals("NA")) {
                                    bossUser.createCompany();

                                }
                                else{
                                    System.out.println("You are already associated with a company.");
                                }
                                break;
                            case 12:if(bossUser.companyId.equals("NA")) {
                                System.out.println("You are not associated with any company.");
                            }
                            else{
                                Company company =  Company.loadFromFile("Companies/"+bossUser.companyId+".txt");
                                company.displayCompanyInfo();
                            }

                                break;
                            case 13:if(bossUser.companyId.equals("NA")) {
                                System.out.println("You are not associated with any company.");
                            }
                            else{
                                Company company2 =  Company.loadFromFile("Companies/"+bossUser.companyId+".txt");
                                company2.viewCompanyTasks();
                            }

                                break;

                            case 14:if(bossUser.companyId.equals("NA")) {
                                System.out.println("You are not associated with any company.");
                            }
                            else{
                                Company company3 =  Company.loadFromFile("Companies/"+bossUser.companyId+".txt");
                                company3.addEmployeeToCompany();
                            }
                            break;

                            case 15 :
                                bossFlag = false;
                                break;

                        }


                    }
                    break;
                case 3:
                    System.out.println("Hello there. Welcome to you!!!");
                    System.out.println("Enter your Info.");
                    RegularAuthor registerUser = RegularAuthor.createRegularAuthor();
                    System.out.println("Your Id is " + registerUser.authorId + ".Remember this as this will help you to login.");
                    System.out.println("Your account has been created successfully.");
                    System.out.println("Please login to use the Task Management System.");
                    break;

                case 4:
                    System.out.println("Hello Boss. Welcome to you!!!");
                    System.out.println("Enter your Info.");
                    BossAuthor registerBoss = BossAuthor.createBossAuthor();
                    System.out.println("Your Id is " + registerBoss.authorId + ".Remember this as this will help you to login.");
                    System.out.println("Your account has been created successfully.");
                    System.out.println("Please login to use the Task Management System.");
                    break;


                case 5:
                    System.out.println("GoodBye. Hope you will visit again.");
                        flag = false;

            }










        }







    }
}
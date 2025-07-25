import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

enum TechStack{

    JAVA,
    NODE,
    ANGULAR,
    REACT



}

class Employee{

    String empName;
    String empId;
    String joiningDate;
    String dob;
    float salary;
    int exp;
    boolean deptAssigned = false;

    String deptId = null;

    static int empStrength=0;

    Employee( String empName,String joiningDate,String dob,float salary){


        this.empName = empName;
        this.joiningDate = joiningDate;
        this.dob = dob;
        this.salary = salary;
        empStrength++;
        this.empId = "E-" + empStrength;

    }


    public void displayInfo(){

        System.out.print("ID: " + empId + " Name:" + empName + " dob:"+dob);

        if(deptAssigned){
            System.out.print("DeptId: " + deptId);
        }

        System.out.println();

    }

    public float getSalary (){
        return salary;
    }





}


class Probationer extends Employee {

    int duration;
    TechStack learningPath;

    Probationer(String empName,String joiningDate,String dob,float salary,int duration , TechStack learningPath){

        super(empName,joiningDate,dob,salary);
        this.duration = duration;
        this.learningPath = learningPath;

    }

    @Override

    public void displayInfo(){

        System.out.println("ID: " + empId + " Name:" + empName + " dob:"+dob+" duration: "+duration
                + "Learning Path: " + learningPath
        );

    }


    @Override
    public float getSalary(){

        return this.salary * 0.5f;


    }

}

class ProgramAnalyst extends Employee {

    int exp;
    String project;

    TechStack tech;

    ProgramAnalyst(String empName,String joiningDate,String dob,float salary,int exp, TechStack tech , String project){

        super(empName,joiningDate,dob,salary);
        this.exp = exp;
        this.project = project;
        this.tech = tech;
    }

    @Override

    public void displayInfo(){

        System.out.println("ID: " + empId + " Name:" + empName + " dob:"+dob
                + "Tech : " + tech + " Project: "+ project
        );

    }


    @Override
    public float getSalary(){

        return this.salary * (1 + (float)exp/100);


    }


}

class BusinessAnalyst extends Employee{


    int exp;




    BusinessAnalyst(String empName,String joiningDate,String dob,float salary,int exp){

        super(empName,joiningDate,dob,salary);
        this.exp = exp;

    }


    @Override
    public float getSalary(){

        return this.salary * (1 + (float)exp/200);


    }


}

class Department {

    String deptId;
    String deptName;
    static int deptStrength = 0;
    List<Employee> employees;

    Department(String deptName){
        this.deptName = deptName;
        deptStrength++;
        this.deptId = "D-" + deptStrength;
        this.employees = new ArrayList<>();
    }


    public void addEmployee(Employee e){

        employees.add(e);

    }

    public List<Employee> getEmployees(){

        return employees;

    }

    public String getDeptId (){

        return deptId;
    }

    public String getDeptName(){
        return deptName;
    }

    public void displayDepartmentInfo(){

        System.out.println("Dept Id : "+ deptId +" "+ deptName + " Department");
        System.out.println("Employees Info : ");

        if(employees.isEmpty()){
            System.out.println("No Employees Assigned yet.");
        }else{
            for(Employee e : employees){
                e.displayInfo();
            }
        }


    }

}



class EmployeeManagementSystem {

    static  HashMap<String , List<Employee> > empDB = new HashMap<>();
    static HashMap<String , List<Employee> > empDeptDB = new HashMap<>();
    static List<Department> departments = new ArrayList<>();
    static HashMap<String , Department> deptMap = new HashMap<>();



    public static Employee inputEmployee(int empType) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Employee Name: ");
        String empName = sc.nextLine();
        System.out.println("Enter Joining Date (e.g., 2023-01-01): ");
        String joiningDate = sc.nextLine();
        System.out.println("Enter Date of Birth (e.g., 1990-05-20): ");
        String dob = sc.nextLine();
        System.out.println("Enter Salary: ");
        float salary = sc.nextFloat();
        sc.nextLine();
        switch (empType) {
            case 1:
                System.out.println("Enter Probation Duration (in months): ");
                int duration = sc.nextInt();
                sc.nextLine();
                System.out.println("Select Learning Path:");
                for (TechStack t : TechStack.values()) {
                    System.out.println(t.ordinal() + 1 + ". " + t);
                }
                int lpChoice = sc.nextInt();
                sc.nextLine();
                TechStack learningPath = TechStack.values()[lpChoice - 1];
                return new Probationer(empName, joiningDate, dob, salary, duration, learningPath);
            case 2:
                System.out.println("Enter Experience (in years): ");
                int expPA = sc.nextInt();
                sc.nextLine();
                System.out.println("Select Technology Stack:");
                for (TechStack t : TechStack.values()) {
                    System.out.println(t.ordinal() + 1 + ". " + t);
                }
                int techChoice = sc.nextInt();
                sc.nextLine();
                TechStack tech = TechStack.values()[techChoice - 1];
                System.out.println("Enter Project Name: ");
                String project = sc.nextLine();
                return new ProgramAnalyst(empName, joiningDate, dob, salary, expPA, tech, project);
            case 3:
                System.out.println("Enter Experience (in years): ");
                int expBA = sc.nextInt();
                sc.nextLine();
                return new BusinessAnalyst(empName, joiningDate, dob, salary, expBA);
            default:
                System.out.println("Invalid employee type.");
                return null;
        }
    }

    public static void assignEmployeeToDepartment(Employee e , Department d){

        if(e.deptAssigned){
            System.out.println("Department is already assigned to this Employee");
            return;

        }

        e.deptAssigned = true;
        e.deptId = d.getDeptId();

        d.addEmployee(e);





    }

    public static Employee searchEmployeeById (String empId){

        for(Employee e : empDB.get("All")){

            if(e.empId.equals(empId)) return e;
        }

        return null;
    }

    public static void main(String[] args) {

        empDB.put("Probationer",new ArrayList<>());
        empDB.put("ProgramAnalyst",new ArrayList<>());
        empDB.put("BusinessAnalyst",new ArrayList<>());
        empDB.put("All",new ArrayList<>());



        boolean loop = true;


        while(loop){

            System.out.println("1. Add Employee \n" +
                    "2. Add Department \n" +
                    "3. Assign Employee to Department \n" +
                    "4. View All Employees \n" +
                    "5. View All Departments \n" +
                    "6. Search Employee \n" +
                    "7. Exit");
            System.out.println("Enter step : ");
            Scanner sc = new Scanner(System.in);
            int step = sc.nextInt();


            switch (step){

                case 1 :
                    System.out.println("1. Add Probationer \n" +
                            "2. Add ProgramAnalyst \n" +
                            "3. Add BusinessAnalyst\n"

                    );
                    System.out.println("Enter step : ");
                    int step2 = sc.nextInt();

                    switch (step2){

                        case 1 :

                            Employee e1 = inputEmployee(1);
                            empDB.get("Probationer").add(e1);
                            empDB.get("All").add(e1);
                            break;

                        case 2 :
                            Employee  e2= inputEmployee(2);
                            empDB.get("ProgramAnalyst").add(e2);
                            empDB.get("All").add(e2);
                            break;

                        case 3:
                            Employee  e3= inputEmployee(3);
                            empDB.get("BusinessAnalyst").add(e3);
                            empDB.get("All").add(e3);
                            break;


                    }

                    break;
                case 2 :
                    System.out.println("Enter Department Name");

                    String deptName = sc.next();

                    Department d = new Department(deptName);

                    departments.add(d);
                    deptMap.put(d.deptId , d);
                    break;

                case 3:
                    System.out.print("Enter Employee ID to assign: ");
                    String empIdToAssign = sc.next();
                    Employee empToAssign = searchEmployeeById(empIdToAssign);
                    if (empToAssign == null) {
                        System.out.println("Employee with ID " + empIdToAssign + " not found.");
                        break;
                    }
                    if (departments.isEmpty()) {
                        System.out.println("No departments available. Please add departments first.");
                        break;
                    }
                    System.out.println("Available Departments:");
                    for (Department dep : departments) {
                        System.out.println(dep.getDeptId() + ": " + dep.getDeptName());
                    }
                    System.out.print("Enter Department ID to assign employee: ");
                    String deptIdToAssign = sc.next();
                    Department deptToAssign = deptMap.get(deptIdToAssign);
                    if (deptToAssign == null) {
                        System.out.println("Invalid Department ID.");
                        break;
                    }
                    assignEmployeeToDepartment(empToAssign, deptToAssign);
                    break;
                case 4:
                    List<Employee> allEmp = empDB.get("All");
                    if (allEmp.isEmpty()) {
                        System.out.println("No employees added.");
                    } else {
                        System.out.println("All Employees:");
                        for (Employee emp : allEmp) {
                            emp.displayInfo();
                        }
                    }
                    break;
                case 5:
                    if (departments.isEmpty()) {
                        System.out.println("No departments created.");
                    } else {
                        for (Department dep : departments) {
                            dep.displayDepartmentInfo();
                            System.out.println("------");
                        }
                    }
                    break;
                case 6:
                    System.out.print("Enter Employee ID to search: ");
                    String searchId = sc.next();
                    Employee empFound = searchEmployeeById(searchId);
                    if (empFound != null) {
                        System.out.println("Employee Found:");
                        empFound.displayInfo();
                        System.out.println("Salary: " + empFound.getSalary());
                    } else {
                        System.out.println("Employee not found.");
                    }
                    break;
                case 7:
                    loop = false;
                    System.out.println("Exiting system. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }





    }




}





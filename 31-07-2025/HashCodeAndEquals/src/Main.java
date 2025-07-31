

class Student  {

    public String name;
    public int rollNo;

    Student(int rollNo , String name){
        this.name = name;
        this.rollNo = rollNo;
    }


    public boolean equals(Student s){
        return s.rollNo == this.rollNo;

    }


    public int hashcode(){
        return this.rollNo;
    }



}




public class Main  {

    public static void main(String[] args) {
     
        Student s1 = new Student(1 , "Arun");
        Student s2 = new Student(1,"Arun");


        System.out.println(s1.equals(s2));
        System.out.println("s1 hashcode : " + s1.hashcode());
        System.out.println("s2 hashcode : " + s2.hashcode());

    }
}
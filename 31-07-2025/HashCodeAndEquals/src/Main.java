import java.util.HashSet;
import java.util.Set;

class Student  {

    public String name;
    public int rollNo;

    Student(int rollNo , String name){
        this.name = name;
        this.rollNo = rollNo;
    }


    @Override
    public boolean equals(Object obj){

        if(this == obj) return true;

        if(obj == null) return false;

        if(this.getClass() != obj.getClass()) return false;

        Student s = (Student) obj;

        if(name == null){

            if(s.name!=null) return false;


        }else if (  !s.name.equals(name)) return false;

        if(s.rollNo != rollNo) return false;


        return true;



    }


    @Override
    public int hashCode(){
        return this.rollNo + this.name.hashCode();
    }


    @Override
    public String toString(){

        return this.rollNo + " " + this.name;

    }


}




public class Main  {

    public static void main(String[] args) {

        Student s1 = new Student(1 , "Arun");
        Student s2 = new Student(1,"Arun");


        System.out.println(s1.equals(s2));
        System.out.println("s1 hashcode : " + s1.hashCode());
        System.out.println("s2 hashcode : " + s2.hashCode());

        Set<Student>s = new HashSet<>();

        s.add(s1);
        s.add(s2);

        for (Student st : s) System.out.println(st);

        // Set will have only one element as both the Student have same hashcode and give true for equals.
    }
}
import java.util.ArrayList;

public class StudentService {
    private final ArrayList<Student>students=new ArrayList<>();
    //Add Students
    public void addStudent(Student s){
        students.add(s);
        System.out.println("Student added Successfully");
    }
    //View Students
    public void viewStudents(){
        if(students.isEmpty()){
            System.out.printf("No Students Found!");
            return;
        }
        for(Student s:students){
            s.Display();
        }
    }
    //Delete Student
    public void deleteStudent(int id){
        boolean found=false;
        for(Student s:students){
            if(s.getId()==id){
                students.remove(s);
                System.out.println("Student deleted Successfully");
                found=true;
                break;
            }
        }
        if(!found){
            System.out.println("Student not Found");
        }
    }
    //Update Student
    public void updateStudent(int id,String name,int age){
        for(Student s:students){
            if(s.getId()==id){
                s.setName(name);
                s.setAge(age);
                System.out.println("Student updated Successfully");
                return;
            }
        }
        if(students.isEmpty()){
            System.out.printf("No Students Found!");
        }
    }
}


import java.io.*;
import java.util.ArrayList;

public class StudentService {
    private final ArrayList<Student>students=new ArrayList<>();
    private final String FILE_NAME="students.txt";

    public StudentService() {
        LoadFromFile();
    }

    //Add Students
    public void addStudent(Student s){
        students.add(s);
        saveToFile();
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
                saveToFile();
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
                saveToFile();
                System.out.println("Student updated Successfully");
                return;
            }
        }
        if(students.isEmpty()){
            System.out.printf("No Students Found!");
        }
    }
    private void saveToFile(){
        try(BufferedWriter writer=new BufferedWriter(new FileWriter(FILE_NAME))) {
            for(Student s:students){
                writer.write(s.getId()+","+s.getName()+","+s.getAge());
                writer.newLine();
            }
        }catch (IOException e){
            System.out.println("Error Saving Data");
        }
    }

    private void LoadFromFile(){
        try(BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))){
            String Line;

            while((Line=reader.readLine())!=null){
                String[] data=Line.split(",");
                int id=Integer.parseInt(data[0]);
                String name= data[1];
                int age=Integer.parseInt(data[2]);

                students.add(new Student(id,name,age));
            }
            }catch(IOException e){
            System.out.println("No Privious data Found");
        }
    }
}


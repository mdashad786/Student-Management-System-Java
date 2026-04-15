import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        StudentService service=new StudentService();

        while(true){
            System.out.println("\n==== Student Management System ====");
            System.out.println("1. Add Student");
            System.out.println("2. View Student");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Students");
            System.out.println("5. Exit");

            System.out.println("Enter your choice");
            int choice=sc.nextInt();

            switch (choice){
                case 1:
                    System.out.println("Enter Student ID");
                    int id=sc.nextInt();
                    sc.nextLine();
                    System.out.println("Enter Student Name");
                    String name=sc.nextLine();
                    System.out.println("Enter Student Age");
                    int age=sc.nextInt();
                    service.addStudent(new Student(id,name,age));
                    break;

                case 2:
                    service.viewStudents();
                    break;

                case 3:
                    System.out.println("Enter Student ID");
                    int uid=sc.nextInt();
                    sc.nextLine();
                    System.out.println("Enter Student Name");
                    String name1=sc.nextLine();
                    System.out.println("Enter Student Age");
                    int age1=sc.nextInt();
                    service.updateStudent(uid,name1,age1);
                    break;

                case 4:
                    System.out.println("Enter Student ID");
                    int did=sc.nextInt();
                    service.deleteStudent(did);
                    break;

                case 5:
                    System.out.println("Exiting");
                    break;

                default:
                    System.out.println("Invalid Choice");
            }
        }
    }
}
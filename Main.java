import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){

        StudentRepository repo = new StudentRepository();
        StudentService service = new StudentService(repo);

        service.seedData();

        Scanner sc = new Scanner(System.in);

        // TODO: app loop goes here
        while(true) {
            System.out.println("\n==== Student Management System ====");
            System.out.println("Choose an option");
            System.out.println("1. Add Student");
            System.out.println("2. View Student");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            String choice = sc.nextLine().trim();
            
            try{
                switch (choice) {
                case "1":
                    // TODO add student
                    addStudentUI(sc, service);
                    break;
                case "2":
                    // TODO view student
                    viewStudenstUI(sc, service);
                    break;
                case "3":
                    // TODO update student
                    updateStudentUI(sc, service);
                    break;
                case "4":
                    // TODO delete student
                    deleteStudentUI(sc, service);
                    break;
                case "5":
                    System.out.println("Goodbye!");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice, Try 1-5.");
            }
            }catch(IllegalAccessError e){
                System.out.println("Error: " + e.getMessage());
            }

        }
       

        // sc.close();

    }
     private static void addStudentUI(Scanner sc, StudentService service){
                    
            System.out.println("Enter name: ");       
            String name = sc.nextLine();
            System.out.println("Enter age: ");
            int age = Integer.parseInt(sc.nextLine().trim());
            System.out.println("Enter course: ");
            String course = sc.nextLine();
            System.out.println("Enter email: ");
            String email = sc.nextLine();

            service.addStudent(name, age, course, email);
            System.out.println("Student added successfully");
            System.out.println("\n");
        
        }

    private static void viewStudenstUI(Scanner sc, StudentService service){
        List<Student> students = service.getAllStudents();
        if(students.isEmpty()) {
            System.out.println("No students found");
            return;
        }    
        System.out.println("\n--- Students ---");
        for(Student student : students){
            System.out.println(student);
        }
        System.out.println("\n");
    }

    private static void updateStudentUI(Scanner sc, StudentService service){
        System.out.println("Enter id: ");
        int id = Integer.parseInt(sc.nextLine().trim());
        Student student = service.findStudentById(id);

        System.out.println("Enter name: ");
        String name = sc.nextLine();

        System.out.println("Enter Course: ");
        String course = sc.nextLine();

        System.out.println("Enter Email: ");
        String email = sc.nextLine();




        //Final Validation converting blank strings to nulls
        String nameValue = name.trim().isEmpty() ? null: name;
        String courseValue = course.trim().isEmpty() ? null: course;
        String emailValue = email.trim().isEmpty() ? null: email;



        service.updateStudent(id, nameValue, courseValue, emailValue);
        System.out.println("Student updated successfully");
        

    }

    private static void deleteStudentUI(Scanner sc, StudentService service){
        System.out.println("Enter the student's ID: ");
        int id = Integer.parseInt(sc.nextLine());
        service.deleteStudent(id);

        System.out.println("Student deleted successfully");

    }
}

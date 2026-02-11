import java.util.Scanner;

public class Main {
    public static void main(String[] args){

        StudentRepository repo = new StudentRepository();
        StudentService service = new StudentService(repo);

        service.seedData();

        Scanner sc = new Scanner(System.in);

        // TODO: app loop goes here
        while(true) {
            System.out.println("Choose an option");
            System.out.println("1. Add Student");
            System.out.println("2. View Student");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            String choice = sc.nextLine().trim();
            switch (choice) {
                case "1":
                    // TODO add student
                    break;
                case "2":
                    // TODO view student
                    break;
                case "3":
                    // TODO update student
                    break;
                case "4":
                    // TODO delete student
                    break;
                case "5":
                    System.out.println("Goodbye!");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice, Try 1-5.");
            }

        }

        // sc.close();

    }
}

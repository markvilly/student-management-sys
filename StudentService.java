public class StudentService {

    private StudentRepository studentRepository;
    private int nextId = 1;

    public StudentService(StudentRepository repo){
        this.studentRepository = repo;
    }

    private void validateName(String name){
        if(name == null || name.trim().isEmpty()){
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
    }

    private void validateAge(int age){
        if(age<4){
            throw new IllegalArgumentException("Age cannot be less than 0");
        }
    }

    private void validateCourse(String course){
        if(course == null || course.trim().isEmpty()){
            throw new IllegalArgumentException("Course cannot be null or empty");
        }
    }

    private void validateEmail(String email){
        if(email == null || email.trim().isEmpty()){
            throw new IllegalArgumentException("Email cannot be null or empty");
        }
    }

    private void validateStudentInput(String name, int age, String course, String email){
        validateName(name);
        validateAge(age);
        validateCourse(course);
        validateEmail(email);
    }

}

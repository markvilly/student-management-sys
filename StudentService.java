import java.util.*;

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

    public Student addStudent(String name, int age, String course, String email){
        validateStudentInput(name, age, course, email);
        Student student = new Student(nextId++, name, age, course, email);
        studentRepository.addStudent(student);
        return student;
    }

    public List<Student> getAllStudents(){
        return studentRepository.getAllStudents();
    }

    public Student findStudentById(int id){
        return studentRepository.findById(id);
    }

    public boolean deleteStudentById(int id){
        return studentRepository.deleteById(id);
    }

    public Student updateStudent(int id, String name, int age, String course, String email){

        Student student = findStudentById(id);
        if(student == null) throw new IllegalArgumentException("Student not found");

        if(name != null && !name.trim().isEmpty()){
            student.setName(name);
        }

        if(age > 0){
            student.setAge(age);
        }

        if(course != null && !course.trim().isEmpty()){
            student.setCourse(course);
        }

        if(email != null && !email.trim().isEmpty()){
            student.setEmail(email);
        }
        return student;   
    }
}
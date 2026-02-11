import java.util.List;

public class StudentService {

    private final StudentRepository studentRepository;
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
        if(age<=0){
            throw new IllegalArgumentException("Age must be greater than 0");
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
        if(!email.contains("@")){
            throw new IllegalArgumentException("Email must contain @");
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
        Student s = studentRepository.findById(id);
        if(s == null) throw new IllegalArgumentException("Student not found");
        return s;
    }

    public Student updateStudent(int id, String name, Integer age, String course, String email){

        Student student = findStudentById(id);
       
        if(name != null && !name.trim().isEmpty()){
            validateName(name);
            student.setName(name);
        }
        
       if(age != null){
            validateAge(age);
            student.setAge(age);
        }
        
        if(course != null && !course.trim().isEmpty()){
            validateCourse(course);
            student.setCourse(course);
        }
        if(email != null && !email.trim().isEmpty()){
            validateEmail(email);
            student.setEmail(email);
        }
       
        return student;
    }

    public boolean deleteStudent(int id){
        boolean deleted = studentRepository.deleteById(id);
        if(!deleted){
            throw new IllegalArgumentException("Student not found");
        }
        return true;
    }

    public void seedData(){
        addStudent("John Jones", 20, "Computer Science", "john@gmail.com");
        addStudent("Jane Smith", 22, "Mathematics", "janesmith@gmail.com");
        addStudent("Bob Johnson", 21, "Physics", "bobjohns@gmail.com");
    }
}
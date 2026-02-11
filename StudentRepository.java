import java.util.ArrayList;
import java.util.List;


public class StudentRepository {

    private final List<Student> students = new ArrayList<>();

    public void addStudent(Student student){

        students.add(student);
    }

    public List<Student> getAllStudents(){

        return students;
    }
    
    public Student findById(int id){

        for(Student student : students){
            if(student.getId() == id){
                return student;
            }
        }
        return null;
    }
    public boolean deleteById(int id){

        Student student = findById(id);
            if(student != null){
                students.remove(student);
                return true;
            }
        return false;
    }

}

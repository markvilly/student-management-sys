import java.util.ArrayList;
import java.util.List;


public class StudentRepository {

    private final List<Student> students;
    private final StudentFileStorage storage;

    public StudentRepository() {
        this.storage = new StudentFileStorage("students.csv");
        this.students = storage.load();
    }

    public void addStudent(Student student){

        students.add(student);
        storage.save(students);
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
                storage.save(students);
                return true;
            }
        return false;
    }

    public void saveAll(){
        storage.save(students);
    }

    public int getNextId(){
        int max = 0;
        for(Student s: students){
            if(s.getId() > max){
                max = s.getId();
            }
        }
        return max + 1;
    }


}

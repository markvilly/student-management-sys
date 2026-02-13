import java.util.*;
import java.util.List;
import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.BufferedWriter;

import java.io.IOException;;

public class StudentFileStorage {
    // Only does disk reading/ writing.
    private final String filename;

    public StudentFileStorage(String filename){
        this.filename = filename;
    }

    public List<Student> load() {
        
        List<Student> students = new ArrayList<>();


        File file = new File(filename);
        if(!file.exists()){
            return students;
        }

        try(BufferedReader reader = new BufferedReader(new FileReader(file))){
            String line;
            while((line = reader.readLine()) != null){
                String[] parts = line.split(",");

                int id = Integer.parseInt(parts[0].trim());
                String name = parts[1];
                int age = Integer.parseInt(parts[2].trim());
                String course = parts[3];
                String email = parts[4];

                students.add(new Student(id, name, age, course, email));

            }
        }catch (IOException e){
            throw new RuntimeException("Error loading students", e);
        }

        return students;

    }

    public void save(List<Student> students){
        // TODO: implement file writing
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(filename))){
            for(Student s: students){
                writer.write(
                    s.getId() + "," +
                    s.getName() + "," + 
                    s.getAge() + "," +
                    s.getCourse() + "," + 
                    s.getEmail()
                );
                writer.newLine();
            }
        }catch (IOException e){
            throw new RuntimeException("Error saving students", e);
        }


    }
}

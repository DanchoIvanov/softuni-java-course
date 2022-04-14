package student_system;

import java.util.HashMap;
import java.util.Map;

public class StudentSystem {
    private final Map<String, Student> students;

    public StudentSystem() {
        this.students = new HashMap<>();
    }

    public Map<String, Student> getStudents() {
        return this.students;
    }

    public void create (String name, int age, double grade){
       this.students.putIfAbsent(name, new Student(name, age, grade));
    }

    private Student getStudent(String name){
        if (students.containsKey(name)){
            return students.get(name);
        }
        return null;
    }

    public void show(String name){
        Student student = getStudent(name);
        if (student != null){
            System.out.println(student);
        }
    }
}

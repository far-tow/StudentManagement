package se.fartow.data_access.impl;

import org.springframework.stereotype.Component;
import se.fartow.data_access.StudentDao;
import se.fartow.models.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class StudentDaoListImpl implements StudentDao {


    List<Student> storage = new ArrayList<>();

    @Override
    public Student save(Student student) {
        if (student == null) throw new IllegalArgumentException("Student was null");
        if (student.getId() != 0) {
            storage.add(student);
        } else {
            storage.forEach(element -> {
                if (element.getId() == student.getId()) element.setName(student.getName());
            });
        }
        //storage.add(student);
        return student;
    }

    @Override
    public Student find(int id) {
        if (id == 0) throw new IllegalArgumentException("Id was null");
        Optional<Student> student = storage.stream()
                .filter(student1 -> student1.getId() == id)
                .findFirst();
        return student.orElse(null);
    }

    @Override
    public List<Student> findAll() {
        return new ArrayList<>(storage);
    }

    @Override
    public void delete(int id) {
        Student student = find(id);
        storage.remove(student);
    }
}

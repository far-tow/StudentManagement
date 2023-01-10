package se.fartow.data_access.impl;

import org.springframework.stereotype.Component;
import se.fartow.data_access.StudentDao;
import se.fartow.models.Student;

import java.util.ArrayList;
import java.util.List;

@Component
public class StudentDaoListImpl implements StudentDao {

    private List<Student> storage = new ArrayList<>();

    @Override
    public Student save(Student student) {
        if (student == null) throw new IllegalArgumentException("Student was null");
        storage.add(student);
        return student;
    }

    @Override
    public Student find(int id) {
        if (id == 0) throw new IllegalArgumentException("Id was null");
        return (Student) storage.stream()
                .filter(student -> student.getId() == id);
    }

    @Override
    public List<Student> findAll() {
        return new ArrayList<>(storage);
    }

    @Override
    public void delete(int id) {
    storage.remove(id);
    }
}

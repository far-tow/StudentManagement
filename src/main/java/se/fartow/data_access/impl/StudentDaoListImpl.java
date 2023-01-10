package se.fartow.data_access.impl;

import org.springframework.stereotype.Component;
import se.fartow.data_access.StudentDao;
import se.fartow.models.Student;

import java.util.List;

@Component
public class StudentDaoListImpl implements StudentDao {

    @Override
    public Student save(Student student) {
        return null;
    }

    @Override
    public Student find(int id) {
        return null;
    }

    @Override
    public List<Student> findAll() {
        return null;
    }

    @Override
    public void delete(int id) {

    }
}

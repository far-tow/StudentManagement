package se.fartow.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import se.fartow.data_access.StudentDao;
import se.fartow.data_access.impl.StudentDaoListImpl;
import se.fartow.models.Student;
import se.fartow.service.StudentManagement;
import se.fartow.util.UserInputService;

import java.util.List;

@Component
public class StudentManagementConsoleImpl implements StudentManagement {

    StudentDao studentDao;
    UserInputService userInputService;

    @Autowired
    public StudentManagementConsoleImpl(StudentDao studentDao, UserInputService userInputService) {
        this.studentDao = studentDao;
        this.userInputService = userInputService;
    }

    @Override
    public Student create() {
        System.out.println("Please enter you Personal Id Number: ");
        int studentId = userInputService.getInt();
        if (studentId == 0) throw new IllegalArgumentException("P.I.N can not be 0");

        System.out.println("Please type in your name: ");
        String studentName = userInputService.getString();
        if (studentName == null) throw new IllegalArgumentException("Name is null");


        Student student = new Student(studentId, studentName);
        return student;
    }

    @Override
    public Student save(Student student) {
        Student createdStudent = studentDao.save(student);
        return createdStudent;
    }

    @Override
    public Student find(int id) {
        return studentDao.find(id);

    }

    @Override
    public Student remove(int id) {
        Student result = find(id);
        studentDao.delete(id);
        return result;
    }

    @Override
    public List<Student> findAll() {
        List<Student> studentList = studentDao.findAll();
        return studentList;
    }

    @Override
    public Student edit(Student student) {
        //if (studentDao.find(student.getId()) == null) throw new IllegalArgumentException("id was null");
        return studentDao.save(student);

    }
}

package se.fartow;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import se.fartow.config.ComponentScanConfig;
import se.fartow.data_access.StudentDao;
import se.fartow.data_access.impl.StudentDaoListImpl;
import se.fartow.models.Student;
import se.fartow.service.StudentManagement;
import se.fartow.service.impl.StudentManagementConsoleImpl;
import se.fartow.util.UserInputService;

public class Main
{
    public static void main( String[] args ) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ComponentScanConfig.class);
        StudentDao studentDao = context.getBean(StudentDao.class);
        UserInputService userInputService = context.getBean(UserInputService.class);
        StudentManagementConsoleImpl studentManagementConsole = context.getBean(StudentManagementConsoleImpl.class);

        Student createdStudent = studentManagementConsole.create();
        Student createdStudent1= studentManagementConsole.create();
        System.out.println( studentManagementConsole.save(createdStudent));
        System.out.println(studentManagementConsole.save(createdStudent1));



        //find by id
        //System.out.println(studentManagementConsole.find(createdStudent.getId()));

        //find all
        studentManagementConsole.findAll().forEach(System.out::println);

        //update student

        createdStudent1.setName("test");
        studentManagementConsole.edit(createdStudent1);
        System.out.println(studentManagementConsole.find(createdStudent1.getId()));

        //remove student by id
        studentManagementConsole.remove(createdStudent.getId());

        studentManagementConsole.findAll().forEach(System.out::println);





    }
}

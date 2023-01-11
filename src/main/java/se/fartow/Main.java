package se.fartow;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import se.fartow.config.ComponentScanConfig;
import se.fartow.data_access.StudentDao;
import se.fartow.models.Student;
import se.fartow.util.UserInputService;

public class Main
{
    public static void main( String[] args ) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ComponentScanConfig.class);
        StudentDao studentDao = context.getBean(StudentDao.class);
        UserInputService userInputService = context.getBean(UserInputService.class);

        //Just to test it first
        System.out.println(studentDao.save(new Student(1, "Farhad")));

    }
}

package se.fartow;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import se.fartow.config.ComponentScanConfig;
import se.fartow.data_access.StudentDao;

public class Main
{
    public static void main( String[] args ) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ComponentScanConfig.class);
        StudentDao studentDao = context.getBean(StudentDao.class);

    }
}

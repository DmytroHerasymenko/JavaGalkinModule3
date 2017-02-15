import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by dima on 14.02.17.
 */
public class Main {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext
                (new String[] {"services.xml"});
        AirCompany service = context.getBean("aircompany", AirCompany.class);
        double prof = service.profit();
        System.out.println(prof);
    }
}

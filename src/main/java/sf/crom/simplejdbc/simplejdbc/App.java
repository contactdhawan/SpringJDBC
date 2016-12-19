package sf.crom.simplejdbc.simplejdbc;

import java.sql.SQLException;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import sf.crom.beans.Circle;
import sf.crom.dto.Circledto;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException
    {
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
    	Circledto dto = context.getBean("circledto",Circledto.class);
        Circle circle = dto.getCircle(2);
        System.out.println(circle.getName());
    }
}
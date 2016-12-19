package sf.crom.simplejdbc.simplejdbc;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbcp.BasicDataSource;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import sf.crom.beans.Circle;
import sf.crom.dto.Circledto;

/**
 * Hello world!
 * 
 */
public class App {
	public static void main(String[] args) throws InstantiationException,
			IllegalAccessException, ClassNotFoundException, SQLException {
		AbstractApplicationContext context = new ClassPathXmlApplicationContext(
				"spring.xml");
		Circledto dto = context.getBean("circledto", Circledto.class);
		/*
		 * Circle circle = dto.getCircle(2);
		 * System.out.println(circle.getName());
		 */
		System.out.println(dto.getCircleCount());
		System.out.println(dto.getCircleName(2));
		System.out.println(dto.getCircle(2).getCircleID());

		List<Circle> circles = dto.getCircles();
		for (Circle circle : circles) {
			System.out.println(circle.getCircleID() + " " + circle.getName());
		}

	}
}

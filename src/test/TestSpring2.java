package test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import pojo.Source;
import pojo.Student;
import pojo.StudentConfig;

public class TestSpring2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext student1context = new AnnotationConfigApplicationContext(StudentConfig.class);
		Student student = (Student) student1context.getBean("student1", Student.class);
		student.printInformation();
	}

}

package test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import pojo.StudentConfig;
import service.StudentService;
import service.StudentServiceImp;

public class studenttest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 通过注解的方式初始化 Spring IoC 容器
		ApplicationContext context = new AnnotationConfigApplicationContext(StudentConfig.class);

		StudentService studentService = context.getBean("studentService", StudentServiceImp.class);
		studentService.printStudentInfo();
	}

}

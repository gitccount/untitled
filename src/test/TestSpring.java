package test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import pojo.JuiceMaker;
import pojo.Source;
import pojo.Student;
import pojo.StudentConfig;
import service.ProductService;

public class TestSpring {
//	@Test
	public void test() {
		ApplicationContext context = new ClassPathXmlApplicationContext(new String[] { "applicationContext.xml" });

		Source source = (Source) context.getBean("source", Source.class);
		System.out.println(source.getFruit());
		System.out.println(source.getSugar());
		System.out.println(source.getSize());

		JuiceMaker juiceMaker = (JuiceMaker) context.getBean("juickMaker", JuiceMaker.class);
		System.out.println(juiceMaker.makeJuice());

		ProductService s = (ProductService) context.getBean("productService", ProductService.class);
		s.doSomeService();

		Student st = (Student) context.getBean("student2", Student.class);
		System.out.println(st.getName() + st.getId());
		
		ApplicationContext student1context = new AnnotationConfigApplicationContext(StudentConfig.class);
		Student student = (Student) student1context.getBean("student1", Student.class);
		student.printInformation();
	}
}

package pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

//@Component(value = "student1")
@Component("student1")
public class Student {
	@Value("1")
	int id;
	@Value("student_name_1C")
	String name;

	public Student(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void printInformation() {
		// TODO Auto-generated method stub
		System.out.println("name:" + name);
		System.out.println("id:" + id);
	}
}

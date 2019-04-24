package service;

import pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import pojo.Student;
@Service("studentService")
@Component("studentService")
public class StudentServiceImp implements StudentService {
	@Autowired
	private Student student = null;

	// getter and setter

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public void printStudentInfo() {
		System.out.println("学生的 id 为：" + student.getName());
		System.out.println("学生的 name 为：" + student.getName());
	}
}

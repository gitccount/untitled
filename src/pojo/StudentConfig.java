package pojo;

import org.springframework.context.annotation.ComponentScan;

//@ComponentScan(basePackageClasses = pojo.Student.class)
@ComponentScan(basePackages = {"pojo", "service"})
public class StudentConfig {

}

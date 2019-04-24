package test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import pojo.UserService;

public class demo02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	       //从spring容器获得
        //1 获得容器
        String xmlPath = "bean.xml";
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
        //2获得内容 --不需要自己new，都是从spring容器获得
        UserService userService = (UserService) applicationContext.getBean("userServiceId");
        userService.addUser();  
	}

}

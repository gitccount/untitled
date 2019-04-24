package aop;

public class userdemo01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UserService userService = MyBeanFactory.createService();
		userService.addUser();
		userService.updateUser();
		userService.deleteUser();
	}

}

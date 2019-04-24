package aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.aspectj.lang.annotation.Before;

public class LoggerExecute implements MethodInterceptor {

	@Override
	public Object invoke(MethodInvocation arg0) throws Throwable {
		// TODO Auto-generated method stub
		before();
		arg0.proceed();
		return null;
	}

	private void before() {
		// TODO Auto-generated method stub
		System.out.println("程序开始执行");
	}

}

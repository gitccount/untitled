package aop;

import org.springframework.aop.framework.ProxyFactory;

public class Manager {
	public static void main(String[] argStrings) {
		Target target = new Target();
		ProxyFactory diFactory = new ProxyFactory();
		diFactory.addAdvice(new LoggerExecute());
		diFactory.setTarget(target);
		Target proxyTarget = (Target) diFactory.getProxy();
		proxyTarget.execute("简单的AOP实现");
	}
}

package Action;

import com.opensymphony.xwork2.ActionSupport;

public class HelloAction extends ActionSupport {
    public String execute() throws Exception { //这里取execute代表默认执行这个方法
        System.out.println("我是执行的内容...");
        return "excutesuccess";  //有返回值，我们用来跳转页面
    }
}

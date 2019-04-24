import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/HelloWorld")
public class HelloWorld extends javax.servlet.http.HttpServlet {
    private String message;

    @Override
    public void init() throws ServletException {
        super.init();
        message = "Hello world, this message is from servlet!";

    }

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
//设置响应内容类型
        response.setContentType("text/html");
//设置逻辑实现
        PrintWriter out = response.getWriter();
        out.println("<h3>" + message + "</h3>");
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doPost(request, response);
    }

    @Override
    public void destroy() {
        super.destroy();
    }
}

package com.helloservlet.hello;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ContextLog
 */
@WebServlet("/ContextLog")
public class ContextLog extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ContextLog() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		  String par = request.getParameter("par1");
	      // 调用两个 ServletContext.log 方法
	      ServletContext context = getServletContext( );

	      if (par == null || par.equals(""))
	      // 通过 Throwable 参数记录版本
	      context.log("No message received:",
	          new IllegalStateException("Missing parameter"));
	      else
	          context.log("Here is the visitor's message: " + par);
	      
	      response.setContentType("text/html;charset=UTF-8");
	      java.io.PrintWriter out = response.getWriter( );
	      String title = "Context Log";
	      String docType = "<!DOCTYPE html> \n";
	      out.println(docType +
	        "<html>\n" +
	        "<head><title>" + title + "</title></head>\n" +
	        "<body bgcolor=\"#f0f0f0\">\n" +
	        "<h1 align=\"center\">" + title + "</h1>\n" +
	        "<h2 align=\"center\">Messages sent</h2>\n" +
	        "</body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

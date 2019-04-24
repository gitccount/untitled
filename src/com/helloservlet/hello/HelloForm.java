package com.helloservlet.hello;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.helloservlet.hello.utils.GsonUtil;

import net.sf.json.JSONObject;

/**
 * Servlet implementation class HelloForm
 */
@WebServlet("/HelloForm")
public class HelloForm extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private boolean getRequest = true;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public HelloForm() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
        // 为名字和姓氏创建 Cookie      
        Cookie name = new Cookie("name",
                URLEncoder.encode(request.getParameter("name"), "UTF-8")); // 中文转码
        Cookie url = new Cookie("url",
                      request.getParameter("url"));
        
        // 为两个 Cookie 设置过期日期为 24 小时后
        name.setMaxAge(60*60*24); 
        url.setMaxAge(60*60*24); 
        
        // 在响应头中添加两个 Cookie
        response.addCookie( name );
        response.addCookie( url );
        
		//请求解决乱码
		response.setContentType("text/html;charset=UTF-8");
		//响应解决乱码
		request.setCharacterEncoding("utf-8");
		
		PrintWriter out = response.getWriter();
		String title = "使用 GET 方法读取表单数据";
		// 处理中文
		String name1;
		 name1 =new String(request.getParameter("name"));
		if (getRequest) {
			title = "使用 GET 方法读取表单数据";
//			 name =URLDecoder.decode(request.getParameter("name"), "utf-8");
		}else {
//			 name = new String(request.getParameter("name").getBytes("ISO8859-1"), "UTF-8");
			title = "使用 POST 方法读取表单数据";
		}
		String docType = "<!DOCTYPE html> \n";
		JSONObject jsonObject1 = new JSONObject();
		jsonObject1.put("title", title);
		jsonObject1.put("站点名称", name);
		jsonObject1.put("站点URL", url);
		out.println(GsonUtil.GsonString(jsonObject1));
//        out.println(docType +
//        		"<html>\n" +
//        		"<head><title>" + title + "</title></head>\n" +
//        		"<body bgcolor=\"#f0f0f0\">\n" +
//        		"<h1 align=\"center\">" + title + "</h1>\n" +
//        		"<ul>\n" +
//        		"  <li><b>站点名</b>："
//        		+ name1+ "\n" +
//        		"  <li><b>网址</b>："
//        		+ request.getParameter("url") + "\n" +
//        		"</ul>\n" +
//        		"</body></html>");
		out.close();
		getRequest = true;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		getRequest = false;
		doGet(request, response);
//		// TODO Auto-generated method stub
//		// 设置响应内容类型
//		response.setContentType("text/html;charset=UTF-8");
//
//		PrintWriter out = response.getWriter();
//		String title = "使用POST 方法读取表单数据";
//		// 处理中文
//		String name = new String(request.getParameter("name").getBytes("ISO8859-1"), "UTF-8");
////		String name =URLDecoder.decode(request.getParameter("name"), "utf-8");
//		String docType = "<!DOCTYPE html> \n";
//        out.println(docType +
//                "<html>\n" +
//                "<head><title>" + title + "</title></head>\n" +
//                "<body bgcolor=\"#f0f0f0\">\n" +
//                "<h1 align=\"center\">" + title + "</h1>\n" +
//                "<ul>\n" +
//                "  <li><b>站点名</b>："
//                + name+ "\n" +
//                "  <li><b>网址</b>："
//                + request.getParameter("url") + "\n" +
//                "</ul>\n" +
//                "</body></html>");
//		out.close();
	}

}

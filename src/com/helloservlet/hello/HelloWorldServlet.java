package com.helloservlet.hello;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.helloservlet.hello.utils.GsonUtil;

import net.sf.json.JSONObject;


/**
 * Servlet implementation class HelloWorldServlet
 */
@WebServlet("/HelloWorldServlet")
public class HelloWorldServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String message;
	private List<JSONObject> jsonObjects;
	private String data;

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();

		message = "{\r\n" + "    \"sites\": [\r\n" + "    { \"name\":\"菜鸟教程\" , \"url\":\"www.runoob.com\" }, \r\n"
				+ "    { \"name\":\"google\" , \"url\":\"www.google.com\" }, \r\n"
				+ "    { \"name\":\"微博\" , \"url\":\"www.weibo.com\" }\r\n" + "    ]\r\n" + "}";
		System.out.println("servlet初始化……");
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("name", "王尼玛");

		// 粉丝是个数组,其实就是嵌套json
		JSONObject jsonObject1 = new JSONObject();
		jsonObject1.put("name", "小王");
		jsonObject1.put("age", "7");

		JSONObject jsonObject2 = new JSONObject();
		jsonObject2.put("name", "小尼玛");
		jsonObject2.put("age", "10");

		// 从此处可以看出其实list和json也是互相转换的
		jsonObjects = new ArrayList<JSONObject>();
		jsonObjects.add(jsonObject1);
		jsonObjects.add(jsonObject2);
		jsonObject.put("fans", jsonObjects);
		data = GsonUtil.GsonString(jsonObject);
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public HelloWorldServlet() {
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
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		// 设置响应内容类型
		response.setContentType("text/html;charset=UTF-8");

		// 实际的逻辑是在这里
		PrintWriter out = response.getWriter();
//		out.println("<h1>" + message + "</h1>");
		out.println(data);
		out.close();
		request.getParameterValues(message);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

package com.helloservlet.hello;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.helloservlet.hello.utils.GsonUtil;

import net.sf.json.JSONObject;

/**
 * Servlet implementation class DateLocale
 */
@WebServlet("/DateLocale")
public class DateLocale extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DateLocale() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	    // 设置响应内容类型
	    response.setContentType("text/html;charset=UTF-8");
	    PrintWriter out = response.getWriter();
	    // 获取客户端的区域设置
	    Locale locale = request.getLocale( );
	    String date = DateFormat.getDateTimeInstance(
	                                  DateFormat.FULL, 
	                                  DateFormat.SHORT, 
	                                  locale).format(new Date( ));

	    String title = "特定于区域设置的日期";
	    String docType = "<!DOCTYPE html> \n";
//	      out.println(docType +
//	      "<html>\n" +
//	      "<head><title>" + title + "</title></head>\n" +
//	      "<body bgcolor=\"#f0f0f0\">\n" +
//	      "<h1 align=\"center\">" + date + "</h1>\n" +
//	      "</body></html>");
			JSONObject jsonObject1 = new JSONObject();
			jsonObject1.put("title", title);
			jsonObject1.put("站点date", date);
			out.println(GsonUtil.GsonString(jsonObject1));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

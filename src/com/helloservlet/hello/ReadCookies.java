package com.helloservlet.hello;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.helloservlet.hello.utils.GsonUtil;

import net.sf.json.JSONObject;

/**
 * Servlet implementation class ReadCookies
 */
@WebServlet("/ReadCookies")
public class ReadCookies extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReadCookies() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	       Cookie cookie = null;
	        Cookie[] cookies = null;
	        // 获取与该域相关的 Cookie 的数组
	        cookies = request.getCookies();
	         
	         // 设置响应内容类型
	         response.setContentType("text/html;charset=UTF-8");
	    
	         PrintWriter out = response.getWriter();
	         String title = "Delete Cookie Example";
	         String docType = "<!DOCTYPE html>\n";
//	         out.println(docType +
//	                   "<html>\n" +
//	                   "<head><title>" + title + "</title></head>\n" +
//	                   "<body bgcolor=\"#f0f0f0\">\n" );
	          if( cookies != null ){
//	            out.println("<h2>Cookie 名称和值</h2>");
	        	  JSONObject jsonObject1 = new JSONObject();
	            for (int i = 0; i < cookies.length; i++){
	               cookie = cookies[i];
					

	               if((cookie.getName( )).compareTo("name") == 0 ){
	                    cookie.setMaxAge(0);
	                    response.addCookie(cookie);
//	                    out.print("已删除的 cookie：" + 
//	                                 cookie.getName( ) + "<br/>");
						jsonObject1.put("已删除的 cookie", cookie.getName( ));

	               }
//	               out.print("名称：" + cookie.getName( ) + "，");
//	               out.print("值：" +  URLDecoder.decode(cookie.getValue(), "utf-8") +" <br/>");
//					jsonObject1.put("站点名称", cookie.getName( ));
					jsonObject1.put(cookie.getName( ), URLDecoder.decode(cookie.getValue(), "utf-8"));
	            }
	            out.println(GsonUtil.GsonString(jsonObject1));
	         }else{
	             out.println(
	               "No Cookie founds");
//	         "<h2 class=\"tutheader\">No Cookie founds</h2>");
	         }
//	         out.println("</body>");
//	         out.println("</html>");
	         out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

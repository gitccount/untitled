package com.helloservlet.hello;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.NumberFormat;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.helloservlet.hello.utils.GsonUtil;

import net.sf.json.JSONObject;

/**
 * Servlet implementation class CurrencyLocale
 */
@WebServlet("/CurrencyLocale")
public class CurrencyLocale extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CurrencyLocale() {
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
	    NumberFormat nft = NumberFormat.getCurrencyInstance(locale);
	    String formattedCurr = nft.format(1000000);

	    NumberFormat nft1 = NumberFormat.getPercentInstance(locale);
	    String formattedPerc = nft1.format(0.51);
	    
	    String title = "特定于区域设置的货币";
	    String docType = "<!DOCTYPE html> \n";
//	      out.println(docType +
//	      "<html>\n" +
//	      "<head><title>" + title + "</title></head>\n" +
//	      "<body bgcolor=\"#f0f0f0\">\n" +
//	      "<h1 align=\"center\">" + formattedCurr + "</h1>\n" +
//	      "</body></html>");
			JSONObject jsonObject1 = new JSONObject();
			jsonObject1.put("title", title);
			jsonObject1.put("formattedCurr", formattedCurr);
			jsonObject1.put("formattedPerc", formattedPerc);
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

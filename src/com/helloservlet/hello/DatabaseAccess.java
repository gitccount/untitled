package com.helloservlet.hello;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
 * Servlet implementation class DatabaseAccess
 */
@WebServlet("/DatabaseAccess")
public class DatabaseAccess extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// JDBC 驱动名及数据库 URL
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/RUNOOB?serverTimezone=GMT%2B8&useSSL=false";
//	    static final String DB_URL = "jdbc:mysql://localhost:3306/RUNOOB?useSSL=false";

	// 数据库的用户名与密码，需要根据自己的设置
	static final String USER = "root";
//	    static final String PASS = "kstyeCyBe5+Y"; 
	static final String PASS = "password";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DatabaseAccess() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Connection conn = null;
		Statement stmt = null;
		// 设置响应内容类型
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		String title = "Servlet Mysql 测试 - 菜鸟教程";
		String docType = "<!DOCTYPE html>\n";
//		out.println(docType + "<html>\n" + "<head><title>" + title + "</title></head>\n"
//				+ "<body bgcolor=\"#f0f0f0\">\n" + "<h1 align=\"center\">" + title + "</h1>\n");
		try {
			// 注册 JDBC 驱动器
//			Class.forName("com.mysql.jdbc.Driver");
			Class.forName("com.mysql.cj.jdbc.Driver");

			// 打开一个连接
			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			// 执行 SQL 查询
			stmt = conn.createStatement();
			String sql;
//	            sql = "set password for root@localhost = password('abc123')";

//			sql = "CREATE TABLE `websites` (\r\n" + 
//					"  `id` int(11) NOT NULL AUTO_INCREMENT,\r\n" + 
//					"  `name` char(20) NOT NULL DEFAULT '' COMMENT '站点名称',\r\n" + 
//					"  `url` varchar(255) NOT NULL DEFAULT '',\r\n" + 
//					"  `alexa` int(11) NOT NULL DEFAULT '0' COMMENT 'Alexa 排名',\r\n" + 
//					"  `country` char(10) NOT NULL DEFAULT '' COMMENT '国家',\r\n" + 
//					"  PRIMARY KEY (`id`)\r\n" + 
//					") ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8";
//			sql = "CREATE TABLE `websites`(`id` int(11) NOT NULL AUTO_INCREMENT,`name` char(20),PRIMARY KEY (`id`))";
//			sql = "DROP TABLE websites ";
//			sql = "INSERT INTO `websites` VALUES ('1', 'Google', 'https://www.google.cm/', '1', 'USA'), ('2', '淘宝', 'https://www.taobao.com/', '13', 'CN'), ('3', '菜鸟教程', 'http://www.runoob.com', '5892', ''), ('4', '微博', 'http://weibo.com/', '20', 'CN'), ('5', 'Facebook', 'https://www.facebook.com/', '3', 'USA')";
//				boolean rs = stmt.execute(sql);
			sql = "SELECT id, name, url FROM websites";
			ResultSet rs = stmt.executeQuery(sql);

//			if (!rs) {
//				System.out.println(" 实例化Statement对象...");
//			}

//	             展开结果集数据库
			List<JSONObject> jsonObjects = new ArrayList<JSONObject>();
			while (rs.next()) {
				// 通过字段检索
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String url = rs.getString("url");

				// 输出数据
//				out.println("ID: " + id);
//				out.println(", 站点名称: " + name);
//				out.println(", 站点 URL: " + url);
//				out.println("<br />");

				JSONObject jsonObject1 = new JSONObject();
				jsonObject1.put("ID", id);
				jsonObject1.put("站点名称", name);
				jsonObject1.put("站点URL", url);
				jsonObjects.add(jsonObject1);
			}
//			out.println("</body></html>");
			out.println(GsonUtil.GsonString(jsonObjects));

			// 完成后关闭
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException se) {
			// 处理 JDBC 错误
			se.printStackTrace();
		} catch (Exception e) {
			// 处理 Class.forName 错误
			e.printStackTrace();
		} finally {
			// 最后是用于关闭资源的块
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {
			}
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}

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

package info.fuchao.model;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * 返回数据库链接
 */
public class ConnDB {
	private Connection con=null;
	public Connection getConn(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			// 2.得到链接
			 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Servlet", "root", "root");
			// 3. 创建 Statement
		} catch (Exception e){
			e.printStackTrace();
		}
		return con;
	}
}

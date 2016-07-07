package info.fuchao.model;

import java.sql.*;
import java.util.ArrayList;

/**
 * Created by elephant on 16/7/5.
 */
public class UserBeanCL {
	private Connection con = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	private int pageSize = 3;// 每页显示3条记录
	private int rowCount = 0;// 记录总数
	private int pageCount = 0;// 页数

	/**
	 * 验证用户是否存在
	 *
	 * @param name
	 * @param password
	 * @return
	 */
	public boolean checkUser(String name, String password) {
		boolean flag = false;
		try {
			ConnDB connDB = new ConnDB();
			con = connDB.getConn();
			ps = con.prepareStatement("SELECT  password FROM  users WHERE user = '" + name + "' LIMIT 0, 1");
			rs = ps.executeQuery();

			if (rs.next()) {
				String password1 = rs.getString(1);
				if (password1.equals(password)) {
					// 合法
					flag = true;
				} else {
					// 用户名存在，密码错误
					flag = false;
				}
			} else {
				// 用户不存在
				flag = false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.close();
		}
		return flag;
	}

	/**
	 * 返回当前页面显示的用户
	 *
	 * @param pageNow
	 * @return
	 */
	public ArrayList<UserBean> getUserByPageNow(int pageNow) {
		ArrayList<UserBean> arrayList = new ArrayList<UserBean>();
		try {
			int rowCount = 0;// 共有多少条记录 ，查表

			ConnDB connDB = new ConnDB();
			con = connDB.getConn();
			//  创建Statement
			ps = con.prepareStatement("select count(*) from users");
			rs = ps.executeQuery();
			if (rs.next()) {
				rowCount = rs.getInt(1);
			}
			// 计算pageCount
			if (rowCount / pageSize == 0) {
				pageCount = rowCount / pageSize;
			} else {
				pageCount = rowCount / pageSize + 1;
			}
//select id,name from test limit 参数1,参数2;
			//	参数1，从第几条开始
			//	参数2，返回多少条数据
			ps = con.prepareStatement("select  * from users limit " + (pageNow - 1) * pageSize + "," + pageSize);
			// 给?赋值
			//ps.setInt(1,pageSize);
			//ps.setInt(2,pageSize*pageNow-1);

			// 查询
			rs = ps.executeQuery();

			while (rs.next()) {
				// 将 rs中的每一条记录 封装到 userBean中
				UserBean ub = new UserBean();
				ub.setId(rs.getInt(1));
				ub.setUser(rs.getString(2));
				ub.setPassword(rs.getString(3));
				ub.setMail(rs.getString(4));
				ub.setGrade(rs.getInt(5));
				arrayList.add(ub);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.close();
		}
		return arrayList;
	}

	/**
	 * 添加用户
	 *
	 * @param name
	 * @param password
	 * @param mail
	 * @param grade
	 * @return
	 */
	public boolean addUser(String name,String password,String mail,int  grade){
		boolean flag=false;
		try {
			ConnDB connDB = new ConnDB();
			con = connDB.getConn();
			ps = con.prepareStatement("INSERT INTO users(user,password,mail,grade) VALUES ('"+name+"','"+password+"','"+mail+"','"+grade+"')");
			int num = ps.executeUpdate();
			if (num!=0)
				flag=true;
		} catch (Exception e){
			e.printStackTrace();
		}finally {
			this.close();
		}

		return flag;
	}
	/**
	 * 返回总页数
	 *
	 * @return
	 */
	public int getPageCount() {
		return this.pageCount;
	}

	public void close() {
		try {
			if (rs != null)
				rs.close();
			if (ps != null)
				ps.close();
			if (con != null)
				con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 删除用户
	 *
	 * @param id
	 * @return
	 */
	public boolean delUser(int id) {
		boolean flag = false;
		try {
			ConnDB connDB = new ConnDB();
			con = connDB.getConn();
			ps = con.prepareStatement("DELETE FROM users WHERE id="+id);
			int num = ps.executeUpdate();
			if (num != 0) {
				flag = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.close();
		}
		return flag;
	}
	/**
	 * 修改用户
	 *
	 * @param name
	 * @param password
	 * @param mail
	 * @param grade
	 * @return
	 */
	public boolean updateUser(int id,String name,String password,String mail,int  grade){
		boolean flag=false;
		try {
			ConnDB connDB = new ConnDB();
			con = connDB.getConn();
			ps = con.prepareStatement("UPDATE users SET NAME ='"+name+"',password='"+password+"',mail='"+mail+"',grade='"+grade+"'");
			int num = ps.executeUpdate();
			if (num!=0)
				flag=true;
		} catch (Exception e){
			e.printStackTrace();
		}finally {
			this.close();
		}

		return flag;
	}
}

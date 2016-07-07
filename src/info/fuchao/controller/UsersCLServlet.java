package info.fuchao.controller;

import info.fuchao.model.UserBeanCL;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 * 控制分页显示，
 * 用户增加，修改，删除，查询
 * <p>
 * Created by elephant on 16/7/6.
 */
@WebServlet(name = "UsersCLServlet", urlPatterns = {"/usersclservlet"})
public class UsersCLServlet extends HttpServlet {
	/**
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String flag = request.getParameter("flag");
		UserBeanCL ubc = new UserBeanCL();

		// 分页
		if (flag.equals("fenye")) {
			String pageNow_temp = request.getParameter("pageNow");
			int pageNow = Integer.parseInt(pageNow_temp);
			// 将Arrlist,pageCount放入Request
			// 获得当前 page的 arraylist
			ArrayList arrayList = ubc.getUserByPageNow(pageNow);
			int pageCount = ubc.getPageCount();
			request.setAttribute("al", arrayList);
			request.setAttribute("pc", pageCount);
			request.setAttribute("pn", pageNow);
			request.getRequestDispatcher("welcome.jsp").forward(request, response);
		}
		// 添加用户
		if (flag.equals("useradd")) {
			String name = request.getParameter("username");
			String password = request.getParameter("password");
			String mail = request.getParameter("mail");
			Integer grade = Integer.parseInt(request.getParameter("grade"));
			if (ubc.addUser(name, password, mail, grade)) {
				response.sendRedirect("sucess.jsp");
			} else {
				response.sendRedirect("failed.jsp");
			}
		}
		// 修改用户
		if (flag.equals("updateUser")) {
			int id = Integer.parseInt(request.getParameter("id"));
			String name = request.getParameter("username");
			String password = request.getParameter("password");
			String mail = request.getParameter("mail");
			Integer grade = Integer.parseInt(request.getParameter("grade"));
			if (ubc.updateUser(id, name, password, mail, grade)) {
				response.sendRedirect("sucess.jsp");
			} else {
				response.sendRedirect("failed.jsp");
			}
		}
		// 删除用户
		if (flag.equals("delUser")) {
			int id = Integer.parseInt(request.getParameter("id"));
			if (ubc.delUser(id)) {
				response.sendRedirect("sucess.jsp");
			} else {
				response.sendRedirect("failed.jsp");
			}
		}
	}

	/**
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			this.doPost(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

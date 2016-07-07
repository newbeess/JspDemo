package info.fuchao.controller;

import info.fuchao.model.UserBeanCL;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

/**
 * 控制用户对验证
 * <p>
 * Created by elephant on 16/7/6.
 */
@WebServlet(name = "LoginCLServlet", urlPatterns = {"/loginclservlet"})
public class LoginCLServlet extends HttpServlet {
	/**
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		// 调用Model
		// 创建UserBean处理
		UserBeanCL ubc = new UserBeanCL();
		if (ubc.checkUser(username, password)) {
			// 设置Session
			HttpSession session = request.getSession();
			session.setAttribute("username", username);
			session.setMaxInactiveInterval(300);    // 设置session存活时间为300s
			// 将Arrlist,pageCount,pageNow放入Request
			ArrayList arrayList = ubc.getUserByPageNow(1);
			int pageCount = ubc.getPageCount();
			request.setAttribute("al", arrayList);
			request.setAttribute("pc", pageCount);
			request.setAttribute("pn", 1);
			// 转发请求,效率比较高
			request.getRequestDispatcher("main.jsp").forward(request, response);

			// 重定向,
			// response.sendRedirect("welcome.jsp");
		} else {
			request.getRequestDispatcher("login.jsp").forward(request, response);
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

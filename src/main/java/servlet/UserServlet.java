package servlet;

import entity.User;
import mysql.DataBase;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;


public class UserServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = req.getServletPath();
		resp.setContentType("text/html;charset=utf-8");
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		if ("/login.user".equals(path)) {
			login(req, resp);
		}
		if ("/register.user".equals(path)) {
			register(req, resp);
		}

	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = req.getServletPath();
		resp.setContentType("text/html;charset=utf-8");
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		if ("/logout.user".equals(path)) {
			logout(req, resp);
		}
		if ("/check_food.user".equals(path)) {
			check_food(req, resp);
		}
		if ("/check_fruit.user".equals(path)) {
			check_fruit(req, resp);
		}

		if ("/check_mobile.user".equals(path)) {
			check_mobile(req, resp);
		}
		if ("/check_cloth.user".equals(path)) {
			check_cloth(req, resp);
		}
		if ("/check_mall.user".equals(path)) {
			check_mall(req, resp);
		}
	}

	protected void register(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
//		String phone=req.getParameter("phone");
//		String address=req.getParameter("address");
		DataBase db = new DataBase();
		ResultSet rs = db.getData("SELECT * FROM user where user_name='" + username + "'");
		try {
			if (rs.next()) {
				req.setAttribute("msg", "用户名已注册，请重新注册！！！");
				req.getRequestDispatcher("/register.jsp").forward(req, resp);
				rs.close();
				db.close();
				return;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String sql = "insert into user(user_name,user_password) values('" + username + "','" + password + "')";
		db.setData(sql);
		resp.sendRedirect(req.getContextPath() + "/login.jsp");
		db.close();
	}

	protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		HttpSession session = req.getSession();
		DataBase db = new DataBase();
		ResultSet rs = db.getData("SELECT * FROM user where user_name='" + username + "' and user_password='" + password + "'");
		System.out.println("调试3");
		try {
			if (rs.next()) {
				User u = new User();
				u.setUsername(rs.getString("user_name"));
				u.setPassword(rs.getString("user_password"));
//				u.setPhone(rs.getString(3));
//				u.setAddress(rs.getString(4));
				session.setAttribute("user", u);
				System.out.println("调试2");
				resp.sendRedirect(req.getContextPath() + "/show.goods");
				System.out.println("调试1");
				return;
			}
			req.setAttribute("msg", "用户名或密码错误！！！");
			req.getRequestDispatcher("/login.jsp").forward(req, resp);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		db.close();

	}

	protected void logout(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		session.invalidate();
		resp.sendRedirect(req.getContextPath() + "/show.goods");
	}

	protected void check_food(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		User u = (User) req.getSession().getAttribute("user");
		if (u == null) {

			resp.sendRedirect(req.getContextPath() + "/login.jsp");
			return;
		}

		String tag = req.getParameter("tag");
		if ("AddCart".equals(tag)) {
			String index = req.getParameter("index");

			resp.sendRedirect(req.getContextPath() + "/add_food.cart?index=" + index);

		} else {

			resp.sendRedirect(req.getContextPath() + "/show.cart");
		}
	}

	protected void check_fruit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		User u = (User) req.getSession().getAttribute("user");
		if (u == null) {

			resp.sendRedirect(req.getContextPath() + "/login.jsp");
			return;
		}

		String tag = req.getParameter("tag");
		if ("AddCart".equals(tag)) {
			String index = req.getParameter("index");

			resp.sendRedirect(req.getContextPath() + "/add_fruit.cart?index=" + index);
		} else {
			resp.sendRedirect(req.getContextPath() + "/show.cart");
		}
	}

	protected void check_mobile(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		User u = (User) req.getSession().getAttribute("user");
		if (u == null) {

			resp.sendRedirect(req.getContextPath() + "/login.jsp");
			return;
		}

		String tag = req.getParameter("tag");
		if ("AddCart".equals(tag)) {
			String index = req.getParameter("index");
			resp.sendRedirect(req.getContextPath() + "/add_mobile.cart?index=" + index);
		} else {
			resp.sendRedirect(req.getContextPath() + "/show.cart");
		}
	}

	protected void check_cloth(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		User u = (User) req.getSession().getAttribute("user");
		if (u == null) {
			resp.sendRedirect(req.getContextPath() + "/login.jsp");
			return;
		}
		String tag = req.getParameter("tag");
		if ("AddCart".equals(tag)) {
			String index = req.getParameter("index");
			resp.sendRedirect(req.getContextPath() + "/add_cloth.cart?index=" + index);
		} else {
			resp.sendRedirect(req.getContextPath() + "/show.cart");
		}
	}

	protected void check_mall(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		User u = (User) req.getSession().getAttribute("user");
		if (u == null) {
			resp.sendRedirect(req.getContextPath() + "/login.jsp");
			return;
		}

		String tag = req.getParameter("tag");
		if ("Del".equals(tag)) {
			String mall_name = req.getParameter("mall_name");
			String id = req.getParameter("id");
			resp.sendRedirect(req.getContextPath() + "/del.mall?mall_name=" + mall_name + "&id=" + id);
		}
		if ("Update".equals(tag)) {
			String mall_name = req.getParameter("mall_name");
			String id = req.getParameter("id");
			resp.sendRedirect(req.getContextPath() + "/update.mall?mall_name=" + mall_name + "&id=" + id);

		}

	}


}

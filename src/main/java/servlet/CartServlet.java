package servlet;

import entity.Cart;
import entity.User;
import mysql.DataBase;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class CartServlet extends HttpServlet {
	public static List<Cart> cart = new ArrayList<Cart>();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = req.getServletPath();
		resp.setContentType("text/html;charset=utf-8");
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		if ("/add_food.cart".equals(path)) {
			add_food(req, resp);
		}
		if ("/add_fruit.cart".equals(path)) {
			add_fruit(req, resp);
		}
		if ("/add_mobile.cart".equals(path)) {
			add_mobile(req, resp);
		}
		if ("/add_cloth.cart".equals(path)) {
			add_cloth(req, resp);
		}

		if ("/show.cart".equals(path)) {
			show(req, resp);
		}
		if ("/delete.cart".equals(path)) {
			delete(req, resp);
		}
	}

	protected void add_food(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String index = req.getParameter("index");
		User u = (User) req.getSession().getAttribute("user");
		String username = u.getUsername();
		DataBase db = new DataBase();
		ResultSet rs = db.getData("SELECT * FROM mall_food where id=" + index);
		String goodsname = "";

		Double price = 0.0;
		try {
			if (rs.next()) {
				goodsname = rs.getString("name");
				price = rs.getDouble("price");

			} else {
				System.out.println("获取出错！！！");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		rs = db.getData("SELECT * FROM cart  where name='" + goodsname + "' and un='" + username + "'");
		try {
			if (rs.next()) {

				String sql = "UPDATE cart SET number=" + (rs.getInt("number") + 1) + ",price=" + (price * (rs.getInt("number") + 1)) + " where name='" + goodsname + "' and un='" + username + "'";
				db.setData(sql);
				req.setAttribute("msg", "商品" + goodsname + "加入购物成成功！");
				req.getRequestDispatcher("/show.goods").forward(req, resp);
			} else {
				String sql = "insert into cart(name,number,price,un) values('" + goodsname + "',1,'" + price + "','" + username + "')";
				System.out.print(sql);
				db.setData(sql);
				req.setAttribute("msg", "商品" + goodsname + "加入购物成成功！");
				req.getRequestDispatcher("/show_food.goods").forward(req, resp);
			}

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

	protected void add_fruit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String index = req.getParameter("index");
		User u = (User) req.getSession().getAttribute("user");
		String username = u.getUsername();
		DataBase db = new DataBase();
		ResultSet rs = db.getData("SELECT * FROM mall_fruit where id=" + index);
		String goodsname = "";
		Double price = 0.0;
		try {
			if (rs.next()) {
				goodsname = rs.getString("name");
				price = rs.getDouble("price");
				System.out.println("水果调试1" + goodsname);
			} else {
				System.out.println("获取出错！！！");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		rs = db.getData("SELECT * FROM cart  where name='" + goodsname + "' and un='" + username + "'");
		try {
			if (rs.next()) {
				System.out.println("水果调试2");
				String sql = "UPDATE cart SET number=" + (rs.getInt("number") + 1) + ",price=" + (price * (rs.getInt("number") + 1)) + " where name='" + goodsname + "' and un='" + username + "'";
				db.setData(sql);
				req.setAttribute("msg", "商品" + goodsname + "加入购物成成功！");
				req.getRequestDispatcher("/show_fruit.goods").forward(req, resp);
			} else {
				String sql = "insert into cart(name,number,price,un) values('" + goodsname + "',1,'" + price + "','" + username + "')";
				System.out.print(sql);
				db.setData(sql);
				req.setAttribute("msg", "商品" + goodsname + "加入购物成成功！");
				req.getRequestDispatcher("/show_fruit.goods").forward(req, resp);
			}

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

	protected void add_mobile(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String index = req.getParameter("index");
		User u = (User) req.getSession().getAttribute("user");
		String username = u.getUsername();
		DataBase db = new DataBase();
		ResultSet rs = db.getData("SELECT * FROM mall_mobile where id=" + index);
		String goodsname = "";
		Double price = 0.0;
		try {
			if (rs.next()) {
				goodsname = rs.getString("name");
				price = rs.getDouble("price");

			} else {
				System.out.println("获取出错！！！");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		rs = db.getData("SELECT * FROM cart  where name='" + goodsname + "' and un='" + username + "'");
		try {
			if (rs.next()) {

				String sql = "UPDATE cart SET number=" + (rs.getInt("number") + 1) + ",price=" + (price * (rs.getInt("number") + 1)) + " where name='" + goodsname + "' and un='" + username + "'";
				db.setData(sql);
				req.setAttribute("msg", "商品" + goodsname + "加入购物成成功！");
				req.getRequestDispatcher("/show_mobile.goods").forward(req, resp);
			} else {
				String sql = "insert into cart(name,number,price,un) values('" + goodsname + "',1,'" + price + "','" + username + "')";
				System.out.print(sql);
				db.setData(sql);
				req.setAttribute("msg", "商品" + goodsname + "加入购物成成功！");
				req.getRequestDispatcher("/show_mobile.goods").forward(req, resp);
			}

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

	protected void add_cloth(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String index = req.getParameter("index");
		User u = (User) req.getSession().getAttribute("user");
		String username = u.getUsername();
		DataBase db = new DataBase();
		ResultSet rs = db.getData("SELECT * FROM mall_cloth where id=" + index);
		String goodsname = "";
		Double price = 0.0;
		try {
			if (rs.next()) {
				goodsname = rs.getString("name");
				price = rs.getDouble("price");

			} else {
				System.out.println("获取出错！！！");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		rs = db.getData("SELECT * FROM cart  where name='" + goodsname + "' and un='" + username + "'");
		try {
			if (rs.next()) {

				String sql = "UPDATE cart SET number=" + (rs.getInt("number") + 1) + ",price=" + (price * (rs.getInt("number") + 1)) + " where name='" + goodsname + "' and un='" + username + "'";
				db.setData(sql);
				req.setAttribute("msg", "商品" + goodsname + "加入购物成成功！");
				req.getRequestDispatcher("/show_cloth.goods").forward(req, resp);
			} else {
				String sql = "insert into cart(name,number,price,un) values('" + goodsname + "',1,'" + price + "','" + username + "')";
				System.out.print(sql);
				db.setData(sql);
				req.setAttribute("msg", "商品" + goodsname + "加入购物成成功！");
				req.getRequestDispatcher("/show_cloth.goods").forward(req, resp);
			}

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

	protected void show(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		User u = (User) req.getSession().getAttribute("user");
		String username = u.getUsername();
		DataBase db = new DataBase();
		ResultSet rs = db.getData("SELECT * FROM cart where un='" + username + "'");

		try {
			while (rs.next()) {
				Cart c = new Cart();
				c.setGoodsname(rs.getString("name"));
				c.setNumber(rs.getInt("number"));
				c.setPrice(rs.getDouble("price"));
				c.setUsername(username);
				cart.add(c);
			}


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
		req.setAttribute("cart", cart);
		System.out.println("添加购物车调试接口4");
		req.getRequestDispatcher("/cart1.jsp").forward(req, resp);
		System.out.println("添加购物车调试接口5");
		cart.clear();
		db.close();
	}

	protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		DataBase db = new DataBase();
		String type = req.getParameter("type");
		//清空
		if ("All".equals(type)) {
			String sql = "DELETE FROM cart";
			db.setData(sql);
			resp.sendRedirect(req.getContextPath() + "/show.cart");
		}
		//删除某个
		else {
			String goodsname = req.getParameter("goodsname");
			byte[] b = goodsname.getBytes("ISO8859-1");
			goodsname = new String(b, "utf-8");
//			这里取得的编码是utf-8不做处理，tomcat版本不同返回的值编码可能不一样，如果中文乱码，则对编码进行处理
			String sql = "DELETE FROM cart WHERE name='" + goodsname + "'";
			db.setData(sql);
			resp.sendRedirect(req.getContextPath() + "/show.cart");
		}
		db.close();
	}

}

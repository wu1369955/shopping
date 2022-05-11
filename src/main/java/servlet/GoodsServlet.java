package servlet;

import entity.Goods;
import entity.mall;
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

public class GoodsServlet extends HttpServlet {
	public static List<Goods> goods = new ArrayList<Goods>();
	public static List<mall> mall_food = new ArrayList<mall>();
	public static List<mall> mall_cloth = new ArrayList<mall>();
	public static List<mall> mall_fruit = new ArrayList<mall>();
	public static List<mall> mall_mobile = new ArrayList<mall>();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String path = req.getServletPath();
		resp.setContentType("text/html;charset=utf-8");
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		if ("/show_food.goods".equals(path)) {
			show_food(req, resp);
		}
		if ("/show_fruit.goods".equals(path)) {
			show_fruit(req, resp);
		}
		if ("/show_mobile.goods".equals(path)) {
			show_mobile(req, resp);
		}
		if ("/show_cloth.goods".equals(path)) {
			show_cloth(req, resp);
		}
		if ("/show_mall.goods".equals(path)) {
			show_mall(req, resp);
		}


	}

	protected void show_mall(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		DataBase db = new DataBase();
		ResultSet rs_food = db.getData("SELECT * FROM mall_food");
		try {
			while (rs_food.next()) {
				mall g = new mall();
				g.setGoodsname(rs_food.getString("name"));
				g.setPrice(rs_food.getDouble("price"));
				g.setDescribe(rs_food.getString("describe"));
				mall_food.add(g);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (rs_food != null) {
				try {
					rs_food.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}


		ResultSet rs_cloth = db.getData("SELECT * FROM mall_cloth");
		try {
			while (rs_cloth.next()) {
				mall g = new mall();
				g.setGoodsname(rs_cloth.getString("name"));
				g.setPrice(rs_cloth.getDouble("price"));
				g.setDescribe(rs_cloth.getString("describe"));
				mall_cloth.add(g);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (rs_cloth != null) {
				try {
					rs_cloth.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}


		ResultSet rs_mobile = db.getData("SELECT * FROM mall_mobile");
		try {
			while (rs_mobile.next()) {
				mall g = new mall();
				g.setGoodsname(rs_mobile.getString("name"));
				g.setPrice(rs_mobile.getDouble("price"));
				g.setDescribe(rs_mobile.getString("describe"));
				mall_mobile.add(g);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (rs_mobile != null) {
				try {
					rs_mobile.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}


		ResultSet rs_fruit = db.getData("SELECT * FROM mall_fruit");
		try {
			while (rs_fruit.next()) {
				mall g = new mall();
				g.setGoodsname(rs_fruit.getString("name"));
				g.setPrice(rs_fruit.getDouble("price"));
				g.setDescribe(rs_fruit.getString("describe"));
				mall_fruit.add(g);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (rs_fruit != null) {
				try {
					rs_fruit.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		req.setAttribute("mall_cloth", mall_cloth);
		req.setAttribute("mall_food", mall_food);
		req.setAttribute("mall_fruit", mall_fruit);
		req.setAttribute("mall_mobile", mall_mobile);
		req.getRequestDispatcher("/mall.jsp").forward(req, resp);
		mall_cloth.clear();
		mall_food.clear();
		mall_mobile.clear();
		mall_fruit.clear();
		db.close();

	}

	protected void show_cloth(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		DataBase db = new DataBase();
		ResultSet rs = db.getData("SELECT * FROM mall_cloth");
		try {
			while (rs.next()) {
				Goods g = new Goods();
				g.setGoodsname(rs.getString("name"));
				g.setPrice(rs.getDouble("price"));
				g.setDescribe(rs.getString("describe"));
				goods.add(g);

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
		req.setAttribute("goods", goods);
		req.getRequestDispatcher("mall_cloth.jsp").forward(req, resp);
		goods.clear();
		db.close();

	}


	protected void show_food(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		DataBase db = new DataBase();
		ResultSet rs = db.getData("SELECT * FROM mall_food");
		try {
			while (rs.next()) {
				Goods g = new Goods();
				g.setGoodsname(rs.getString("name"));
				g.setPrice(rs.getDouble("price"));
				g.setDescribe(rs.getString("describe"));
				goods.add(g);

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
		req.setAttribute("goods", goods);
		req.getRequestDispatcher("mall_food.jsp").forward(req, resp);
		goods.clear();
		db.close();

	}

	protected void show_fruit(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		DataBase db = new DataBase();
		ResultSet rs = db.getData("SELECT * FROM mall_fruit");
		try {
			while (rs.next()) {
				Goods g = new Goods();
				g.setGoodsname(rs.getString("name"));
				g.setPrice(rs.getDouble("price"));
				g.setDescribe(rs.getString("describe"));
				goods.add(g);

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
		req.setAttribute("goods", goods);
		req.getRequestDispatcher("mall_fruit.jsp").forward(req, resp);
		goods.clear();
		db.close();

	}

	protected void show_mobile(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		DataBase db = new DataBase();
		ResultSet rs = db.getData("SELECT * FROM mall_mobile");
		try {
			while (rs.next()) {
				Goods g = new Goods();
				g.setGoodsname(rs.getString("name"));
				g.setPrice(rs.getDouble("price"));
				g.setDescribe(rs.getString("describe"));
				goods.add(g);

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
		req.setAttribute("goods", goods);
		req.getRequestDispatcher("mall_mobile.jsp").forward(req, resp);
		goods.clear();
		db.close();

	}
}

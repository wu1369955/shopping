package servlet;

import mysql.DataBase;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MallServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getServletPath();
        resp.setContentType("text/html;charset=utf-8");
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        if ("/del.mall".equals(path)) {
            del(req, resp);
        }
        if ("/update.mall".equals(path)) {
            update(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

    private void del(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DataBase db = new DataBase();
        String goodsname = req.getParameter("mall_name");
        String id = req.getParameter("id");
        byte[] b = goodsname.getBytes("ISO8859-1");
        goodsname = new String(b, "utf-8");
        if (id.equals("food")) {
            System.out.println("删除调试1" + goodsname);
            String sql = "DELETE FROM mall_food WHERE name='" + goodsname + "'";
            db.setData(sql);
            resp.sendRedirect(req.getContextPath() + "/show_mall.goods");
            db.close();
        }
        if (id.equals("fruit")) {
            System.out.println("删除调试1" + goodsname);
            String sql = "DELETE FROM mall_fruit WHERE name='" + goodsname + "'";
            db.setData(sql);
            resp.sendRedirect(req.getContextPath() + "/show_mall.goods");
            db.close();
        }
        if (id.equals("cloth")) {
            System.out.println("删除调试1" + goodsname);
            String sql = "DELETE FROM mall_cloth WHERE name='" + goodsname + "'";
            db.setData(sql);
            resp.sendRedirect(req.getContextPath() + "/show_mall.goods");
            db.close();
        }
        if (id.equals("mobile")) {
            System.out.println("删除调试1" + goodsname);
            String sql = "DELETE FROM mall_mobile WHERE name='" + goodsname + "'";
            db.setData(sql);
            resp.sendRedirect(req.getContextPath() + "/show_mall.goods");
            db.close();
        }

    }

    private void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect(req.getContextPath() + "/update.mall");
    }
}

<%@page import="entity.User" %>
<%@page import="entity.Goods" %>
<%@page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%
    List<Goods> goods = (List<Goods>) request.getAttribute("goods");
    User u = (User) session.getAttribute("user");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>食品展示区</title>
    <link href="css/object.css" rel="stylesheet">
</head>
<body>
<h1>商品列表</h1>
<%if (u != null) { %>
<b style="color: red;">用户<%=u.getUsername() %>在线... </b>
<a href="<%=request.getContextPath()%>/logout.user">注销</a>
<a href="<%=request.getContextPath()%>/showOrders.order">我的历史订单</a><%} else { %>
<a href="login.jsp">登录</a>
<a href="register.jsp">注册</a><%} %>
<hr>
<div id="wrapper">
    <table id="keywords" cellpadding="0" cellspacing="1">
        <thead>
        <tr>
            <th><span>序号</span></th>
            <th><span>商品</span></th>
            <th><span>介绍</span></th>
            <th><span>价格</span></th>
            <th><span>操作</span></th>
        </tr>
        </thead>
        <%
            for (int i = 1; i <= goods.size(); i++) {
                Goods g = goods.get(i - 1);
        %>
        <tr>
            <td><%=i %>
            </td>
            <td><%=g.getGoodsname() %>
            </td>
            <td><%=g.getDescribe() %>
            </td>
            <td><%=g.getPrice() %>
            </td>
            <td><a href="/check_food.user?tag=AddCart&index=<%=i%>">加入购物车</a></td>
        </tr>
        <%
            }
        %>
    </table>
</div>
<% String msg = (String) request.getAttribute("msg");%>
<h1 style="color: red;"><%=msg != null ? msg : "" %>
</h1>
<br>
<a href="/check_food.user?tag=ShowCart">查看购物车</a>
</body>
</html>